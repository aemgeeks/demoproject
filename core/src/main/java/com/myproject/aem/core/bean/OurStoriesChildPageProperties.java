package com.myproject.aem.core.bean;

public class OurStoriesChildPageProperties {
	
	private String title;
	private String description;
	private String link;
	private String imageUrl;
	private String altTag;
	private String[] tags;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String[] getTags() {
		return tags.clone();
	}
	public void setTags(String[] tags) {
		this.tags = tags.clone();
	}
	public String getAltTag() {
		return altTag;
	}
	public void setAltTag(String altTag) {
		this.altTag = altTag;
	}
}
