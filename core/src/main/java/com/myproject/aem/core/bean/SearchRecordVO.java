package com.myproject.aem.core.bean;

public class SearchRecordVO {

    private String contentType;
    private String assetType;
    private String url;
    private String path;
    private String title;
    private String description;
    private String uuid;
    private String[] tags;
    private String assetPath;
    private String assetRenditionImgPath48;

    
    public String[] getTags() {
        return tags.clone();
    }
    public void setTags(String[] tags) {
        this.tags = tags.clone();
    }
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
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
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
    public String getAssetPath() {
        return assetPath;
    }
    public void setAssetPath(String assetPath) {
        this.assetPath = assetPath;
    }
    public String getAssetRenditionImgPath48() {
        return assetRenditionImgPath48;
    }
    public void setAssetRenditionImgPath48(String assetRenditionImgPath48) {
        this.assetRenditionImgPath48 = assetRenditionImgPath48;
    }
}
