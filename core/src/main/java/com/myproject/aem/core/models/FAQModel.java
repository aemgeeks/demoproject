package com.myproject.aem.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.myproject.aem.core.bean.Filter;
import com.myproject.aem.core.bean.TagItem;
import com.myproject.aem.core.models.impl.EventCard;

@Model(adaptables = { SlingHttpServletRequest.class,
		Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FAQModel {
	private static final Logger LOGGER = LoggerFactory.getLogger(FAQModel.class);

	@Self
	private SlingHttpServletRequest slingHttpServletRequest;

	@SlingObject
	ResourceResolver resourceResolver;

	@ScriptVariable
	private Page currentPage;

	@ChildResource
	private List<EventCard> tagItems;

	@SlingObject
	private Resource resource;


	private List<Filter> filters = new ArrayList<>();

	private List<FAQDetails> details = Collections.emptyList();
	private List<FAQDetails> detailsWithoutHtmlTags = Collections.emptyList();


	@PostConstruct
	protected void init() {
		LOGGER.info("Inside FAQ Model class");

		PageManager pm = resourceResolver.adaptTo(PageManager.class);
		Page currentPage = pm.getContainingPage(resource);

		if(null == tagItems || currentPage == null) {
			return;
		}

		Locale locale = currentPage.getLanguage();

		for(EventCard card: tagItems) {

			String heading = card.getTagName();
			String tagRootPath = card.getTagLink();

			Filter filter = new Filter();
			filter.setHeading(heading);

			TagManager tagManager = resourceResolver.adaptTo(TagManager.class);
			Tag rootTag = tagManager.resolve(tagRootPath);
			if(null != rootTag) {		
				Iterator<Tag> childTagIterator = rootTag.listChildren();
				List<TagItem> filterTagsList = new ArrayList<>();
				while(childTagIterator.hasNext()) {
					Tag childTag = childTagIterator.next();
					TagItem filterTag = new TagItem();
					filterTag.setTitle(childTag.getTitle(locale));
					filterTag.setPath(childTag.getTagID());
					filterTagsList.add(filterTag);
				}
				filter.setTagData(filterTagsList);			
			}
			filters.add(filter);
		}	
	}

	public List<FAQDetails> getFAQs() {
		return Collections.unmodifiableList(details);

	}

	public List<FAQDetails> getFAQsWithoutHtmlTagss() {
		detailsWithoutHtmlTags=new ArrayList<FAQDetails>();
		detailsWithoutHtmlTags.addAll(details);
		detailsWithoutHtmlTags.forEach(e->e.setFaqAnswer(e.getFaqAnswer().replaceAll("<[^>]++>", "")));

		return Collections.unmodifiableList(detailsWithoutHtmlTags);

	}

	public List<Filter> getFilters() {
		return Collections.unmodifiableList(filters);
	}

}
