package com.myproject.aem.core.bean;

import java.util.ArrayList;
import java.util.List;

public class Filter {
	String heading;
	List<TagItem> tagData = new ArrayList<>();
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public List<TagItem> getTagData() {
		return tagData;
	}
	public void setTagData(List<TagItem> tagData) {
		this.tagData = tagData;
	}
	
	
}
