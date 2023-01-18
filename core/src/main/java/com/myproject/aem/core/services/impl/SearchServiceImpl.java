package com.myproject.aem.core.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.factory.ModelFactory;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.day.cq.wcm.api.Page;
import com.myproject.aem.core.bean.SearchRecordVO;
import com.myproject.aem.core.bean.SearchResultVO;
import com.myproject.aem.core.services.SearchService;
import com.myproject.aem.core.utility.SearchConstants;

@Component(service = SearchService.class, property = { Constants.SERVICE_ID + "=Search Service",
		SearchServiceImpl.DESC })
public class SearchServiceImpl implements SearchService {

	static final String DESC = Constants.SERVICE_DESCRIPTION + "=This services uses QueryBuilder API to search in JCR";
	@Reference
	transient QueryBuilder queryBuilder;
	@Reference
	private ModelFactory modelFactory;
	@Reference
	ResourceResolverFactory resourceResolverFactory;

	protected static final Logger LOG = LoggerFactory.getLogger(SearchServiceImpl.class);

	@Override
	public ResourceResolver getResourceResolver() {
		try {
			Map<String, Object> param = new HashMap<>();
			param.put(ResourceResolverFactory.SUBSERVICE, "searchuser");

			if (resourceResolverFactory != null) {
				ResourceResolver resourceResolver = resourceResolverFactory.getServiceResourceResolver(param);
				return resourceResolver;
			} 
		} catch (LoginException exception) {
			LOG.error("getConfResourceResolver(): not able to fetch conf resource resolver : {}",
					exception.getMessage());
		}
		return null;
	}

	public SearchResultVO searchByKeyword(String keyword, String offset, String rootpath, String assetpath) {
		SearchResultVO sResult = new SearchResultVO();
		try {
			ResourceResolver resResolver = getResourceResolver();
			Map<String, String> map = new HashMap<>();

			int pageSize = 15;
			if (offset.isEmpty() || offset == null) {
				offset = "0";
			}

			int offsetValue = Integer.parseInt(offset);
			offsetValue = (offsetValue - 1) * pageSize;
			
			map.put(SearchConstants.FULLTEXT, keyword.replace("-", ""));
			map.put(SearchConstants.GROUP_P_OR, SearchConstants.TRUE);
			map.put("group.1_group.1_group.path", rootpath);
			map.put("group.1_group.1_group.type", SearchConstants.CQ_PAGE);
			map.put("group.1_group.1_group.fulltext.relpath", SearchConstants.JCR_CONTENT);
			map.put("group.1_group.2_group.1_property", "jcr:content/hideInSearch");
			map.put("group.1_group.2_group.1_property.value", "false");
			map.put("group.1_group.2_group.2_property", "jcr:content/hideInSearch");
            map.put("group.1_group.2_group.2_property.operation", "not");
            map.put("group.1_group.2_group.p.or", "true");
            
             	
			map.put(SearchConstants.GROUP_2_TYPE, SearchConstants.DAM_ASSET);
			map.put(SearchConstants.GROUP_2_FULLTEXT_REL_PATH, SearchConstants.JCR_CONTENT_DAM);
			map.put(SearchConstants.GROUP_TWO_PATH, assetpath);
			map.put(SearchConstants.GROUP_2_PROPERTY, SearchConstants.JCR_CONTENT_DAM_TYPE);
			map.put(SearchConstants.GROUP_2_PROPERTY_2_VALUE, SearchConstants.ASSET_IMAGE);
			map.put(SearchConstants.GROUP_2_PROPERTY_2, SearchConstants.CQ_TAGS_ASSETS);
            map.put(SearchConstants.GROUP_2_PROPERTY_2_OPERATION, "exists");
            map.put("group.2_group.group.property", SearchConstants.CQ_TAGS_ASSETS);
            map.put("group.2_group.group.property.value", "dramix:experttalks%");
            map.put("group.2_group.group.property.operation", "like");
            map.put("group.2_group.group.p.not", "true");
                                 
			map.put(SearchConstants.P_OFFSET, Integer.toString(offsetValue));
			map.put(SearchConstants.P_LIMIT, Integer.toString(15));
			
			Query query = queryBuilder.createQuery(PredicateGroup.create(map), resResolver.adaptTo(Session.class));
			SearchResult searchResult = query.getResult();
			LOG.info(" number of results returned: {}", searchResult.getHits().size());
			Resource resource;
			List<SearchRecordVO> recordList = new ArrayList<SearchRecordVO>();
			for (Hit hit : searchResult.getHits()) {

				SearchRecordVO sRecord = new SearchRecordVO();
				if (hit.getPath().contains("/content/myproject")) {

					if(hit.getPath().contains("expert-talks") || hit.getPath().contains( "platicas-con-expertos") ){
						sRecord.setContentType("webinars");
					}else{
						sRecord.setContentType("projects");
					}
					Page page = hit.getResource().adaptTo(Page.class);
					ValueMap valuemap = page.getProperties();
					String[] tags = valuemap.get("cq:tags", String[].class);
					if(null != tags){
						sRecord.setTags(tags);
					}else{
						sRecord.setTags(new String[]{});
					}
					sRecord.setPath(getResourceResolver().map(hit.getPath()));
					sRecord.setTitle(page.getTitle());
					sRecord.setDescription(page.getDescription());
					sRecord.setUrl(valuemap.get("backgroundImage", String.class));
					recordList.add(sRecord);
				} else if (hit.getPath().contains("/content/dam")) {
					
					resource = hit.getResource();
					String resourcePath = resource.getPath();

					if (resource != null) {
					    
					    if(resourcePath.contains(".jpg")) {
		                    String[] pdfPath = resourcePath.split(".jpg");
		                    String finalpath = pdfPath[0] + ".pdf";
		                    sRecord.setAssetPath(finalpath);
		                    }else {
		                        String[] pngpath=resourcePath.split(".png");
		                        String finalpath = pngpath[0] + ".pdf";
		                        sRecord.setAssetPath(finalpath);
		                    }
					    
						ValueMap vmap = resource.getValueMap();
						String[] tags = vmap.get("jcr:content/metadata/cq:tags", String[].class);
						if(null != tags){
							sRecord.setTags(tags);
						}else{
							sRecord.setTags(new String[]{});
						}
							sRecord.setPath(hit.getPath());
							if (hit.getPath().contains("/certificate/")) {
								sRecord.setContentType("certificate");
								sRecord.setTitle((String) vmap.get("jcr:content/metadata/certificateTitle"));
								sRecord.setDescription(
										(String) vmap.get("jcr:content/metadata/certificateDescription"));
								sRecord.setUrl(resourcePath);
								sRecord.setAssetRenditionImgPath48(
	                                    "/content/dam/myproject/kcenter/en/certificate/certificate.jpg");
							} else if (hit.getPath().contains("/whitepaper/")) {
								sRecord.setContentType("whitepaper");
								sRecord.setTitle((String) vmap.get("jcr:content/metadata/whitepaperTitle"));
								sRecord.setDescription((String) vmap.get("jcr:content/metadata/whitepaperDescription"));
								sRecord.setUrl(resourcePath);
								sRecord.setAssetRenditionImgPath48(
	                                    "/content/dam/myproject/kcenter/en/whitepaper/whitepaper.jpg");
							} else if (hit.getPath().contains("/productdatasheet/")) {
								sRecord.setContentType("productdatasheet");
								sRecord.setTitle((String) vmap.get("jcr:content/metadata/dc:title"));
								sRecord.setDescription((String) vmap.get("jcr:content/metadata/dc:description"));
								sRecord.setUrl(resourcePath);
								String productType = vmap.get("jcr:content/metadata/productType", String.class);
								if (null != productType) {
								    if(productType.contains("3D")) {
	                                    sRecord.setAssetRenditionImgPath48(
	                                            "/content/dam/myproject/kcenter/en/productdatasheet/productdatasheet.jpg");
	                                } else if (productType.contains("4D")) {
	                                    sRecord.setAssetRenditionImgPath48(
	                                            "/content/dam/myproject/kcenter/en/productdatasheet/productdatasheet4D.jpg");
	                                } else {
	                                    sRecord.setAssetRenditionImgPath48(
	                                            "/content/dam/myproject/kcenter/en/productdatasheet/productdatasheet5D.jpg");
	                                }
								}
							}
								sRecord.setUuid((String) vmap.get(com.day.cq.commons.jcr.JcrConstants.JCR_UUID));

					}
					recordList.add(sRecord);
				
				}

			}
			sResult.setSearchKeyword(keyword);
			sResult.setResults(recordList);
			sResult.setHitCount(searchResult.getHits().size());
			sResult.setTotalMatches(searchResult.getTotalMatches());
			sResult.setOffset(offset);
		} catch (RepositoryException e) {
			LOG.error("cannot search due to: {}", e.getMessage());
		}
		return sResult;
	}

}