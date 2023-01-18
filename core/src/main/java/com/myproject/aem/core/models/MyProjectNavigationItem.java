package com.myproject.aem.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;

public class MyProjectNavigationItem{
	
	private String title;
	
	private String URL;
	
	private String navDescription;
	
	private String subSectionImage;
	
	private boolean isAddLink;
	
	private boolean isCurrent;
	
	private boolean isActive;
	
	private ComponentData data;
	
	private List<MyProjectNavigationItem> children = new ArrayList<>();

	public List<MyProjectNavigationItem> getChildren() {
		return Collections.unmodifiableList(children);
	}
	
	public void setChildren(List<MyProjectNavigationItem> children) {
		this.children = Collections.unmodifiableList(children);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getNavDescription() {
		return navDescription;
	}

	public void setNavDescription(String navDescription) {
		this.navDescription = navDescription;
	}
	
	public String getSubSectionImage() {
		return subSectionImage;
	}

	public void setSubSectionImage(String subSectionImage) {
		this.subSectionImage = subSectionImage;
	}

	public boolean isAddLink() {
		return isAddLink;
	}

	public void setAddLink(boolean isAddLink) {
		this.isAddLink = isAddLink;
	}

	public boolean isCurrent() {
		return isCurrent;
	}

	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public ComponentData getData() {
		return data;
	}

	public void setData(ComponentData data) {
		this.data = data;
	}
}
