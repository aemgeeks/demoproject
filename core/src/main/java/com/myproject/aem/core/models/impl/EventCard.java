package com.myproject.aem.core.models.impl;



import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.google.gson.annotations.Expose;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class EventCard {
	
	
	
	@Self
	private Resource resource;

	@Expose
	@ValueMapValue
	private String image;

	@Expose
	@ValueMapValue
	private String alt;
	
	@Expose
	@ValueMapValue
	private String title;
	
	@Expose
	@ValueMapValue
	private String description;
	
	@Expose
	@ValueMapValue
	private String eventType;
	
	@Expose
	@ValueMapValue
	private String linkTitle;
	
	@Expose
	@ValueMapValue
	private String linkUrl;
	
	@Expose
	@ValueMapValue
	private boolean newTab;
	
	@ValueMapValue
	private String tagName;
	
	@ValueMapValue
	private String tagLink;
	
	
	public boolean isNewTab() {
		return newTab;
	}

	public String getImage() {
		return image;
	}
	
	public String getAlt() {
		return alt;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
	
	public String getEventType() {
		return eventType;
	}

	public String getLinkTitle() {
		return linkTitle;
	}

	public String getLinkUrl() {
		return linkUrl;
	}
	
	public String getTagName() {
		return tagName;
	}

	public String getTagLink() {
		return tagLink;
	}
}
 