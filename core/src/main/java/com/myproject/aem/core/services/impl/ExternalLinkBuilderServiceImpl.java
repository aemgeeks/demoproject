package com.myproject.aem.core.services.impl;

import com.day.cq.commons.Externalizer;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.settings.SlingSettingsService;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.myproject.aem.core.services.ExternalLinkBuilderService;


@Component(service = ExternalLinkBuilderService.class, immediate = true)
public class ExternalLinkBuilderServiceImpl implements ExternalLinkBuilderService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Reference 
	private ResourceResolverFactory resolverFactory;
	

	@Reference
	private SlingSettingsService slingSettingsService;

	@Reference
	private Externalizer externalizer;
	
	private static final String HTML_SLASH = ".html/";
	private static final String HTML = ".html";
	
	
	public String buildExternalLink(SlingHttpServletRequest request){
		logger.debug("Inside ExternalLinkBuilderServiceImpl getExternalLink");
		String externalLink = null;
		String internalPath = "";
		String requestURI = request.getRequestURI();
		String uriSuffix = requestURI.contains(HTML_SLASH) && requestURI.split(HTML_SLASH).length > 1 ? requestURI.split(HTML_SLASH)[1] : StringUtils.EMPTY;
		String videoPageName = uriSuffix.contains(HTML) ? uriSuffix.split(HTML)[0] : StringUtils.EMPTY;
		ResourceResolver resourceResolver = request.getResourceResolver();
		PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
		Page currentPage = pageManager.getContainingPage(request.getResource());
		internalPath = currentPage.getPath();

		if(slingSettingsService!=null){
			if(slingSettingsService.getRunModes().contains("author")){
				externalLink = externalizer.authorLink(resolverFactory.getThreadResourceResolver(),
				internalPath);
			}else if(slingSettingsService.getRunModes().contains("publish")){
				externalLink = externalizer.publishLink(resolverFactory.getThreadResourceResolver(),
				internalPath);
				if (externalLink.contains("/expert-talk-videos")) {
					externalLink = externalLink.replace("expert-talk-videos", videoPageName);
				} else if (externalLink.contains("/whitepapers/download-form")) {
					externalLink = externalLink.replace("download-form", videoPageName);
				} else if (externalLink.contains("/product-datasheets/download-form")) {
					externalLink = externalLink.replace("download-form", videoPageName);
				} else if (externalLink.contains("/certificates/download-form")) {
					externalLink = externalLink.replace("download-form", videoPageName);
				} else if (externalLink.contains("/guias-informativas/descargar-formulario")) {
					externalLink = externalLink.replace("descargar-formulario", videoPageName);
				} else if (externalLink.contains("/documentos-tecnicos/descargar-formulario")) {
					externalLink = externalLink.replace("descargar-formulario", videoPageName);
				} else if (externalLink.contains("/certificados/descargar-formulario")) {
					externalLink = externalLink.replace("descargar-formulario", videoPageName);
				}
			}
		}
		return externalLink;
	}
	
	public String domainName(SlingHttpServletRequest request){
		logger.debug("Inside ExternalLinkBuilderServiceImpl getDomainName");
		String externalLink = null;
		String internalPath = "";
		ResourceResolver resourceResolver = request.getResourceResolver();
		PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
		Page currentPage = pageManager.getContainingPage(request.getResource());
		
		internalPath = currentPage.getPath();

		if(slingSettingsService!=null){
			if(slingSettingsService.getRunModes().contains("author")){
				externalLink = externalizer.authorLink(resolverFactory.getThreadResourceResolver(),
				internalPath);
			}else if(slingSettingsService.getRunModes().contains("publish")){
				externalLink = externalizer.publishLink(resolverFactory.getThreadResourceResolver(),
				internalPath);
			}
		}
		
		String domainName = "";
		String[] splitString=null;
		if(externalLink!=null) {
		splitString = externalLink.split("");
		}
		int count = 3;
		
		if(splitString!=null) {
		for(int i=0;i<splitString.length;i++)
		{
			logger.debug("Inside For Loop");
			if(count > 0)
			{
				domainName = domainName + splitString[i];
				if(splitString[i].equals("/"))
				{
					count--;  
					logger.debug("Count of '/':{}",count);
				}
			}
			else
				break;
		}
		}
		domainName = domainName.substring(0, domainName.length() - 1); 
		return domainName;
	}

	@Override
	public String deviceOS(SlingHttpServletRequest request) {
		String  browserDetails  =   request.getHeader("User-Agent");
        String  userAgent       =   "";
		if(browserDetails != null && browserDetails.length() > 0){
			userAgent = browserDetails;
		}
        
        String os = "";

         if (userAgent.toLowerCase().indexOf("windows") >= 0 )
         {
             os = "Windows";
         } else if(userAgent.toLowerCase().indexOf("mac") >= 0)
         {
             os = "Mac";
         } else if(userAgent.toLowerCase().indexOf("x11") >= 0)
         {
             os = "Unix";
         } else if(userAgent.toLowerCase().indexOf("android") >= 0)
         {
             os = "Android";
         } else if(userAgent.toLowerCase().indexOf("iphone") >= 0)
         {
             os = "IPhone";
         }else{
             os = "UnKnown, More-Info: "+userAgent;
         }
         
        
        return os;
	}

	
	
	
	
}