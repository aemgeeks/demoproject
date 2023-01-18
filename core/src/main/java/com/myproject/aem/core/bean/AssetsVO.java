package com.myproject.aem.core.bean;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class AssetsVO {
	@Inject
	@Optional
	@Named(com.day.cq.commons.jcr.JcrConstants.JCR_CREATED)
	private String createdDate;

	@Inject
	@Optional
	@Named(com.day.cq.commons.jcr.JcrConstants.JCR_CREATED_BY)
	private String createdBy;

	@Inject
	@Optional
	@Named("jcr:content/jcr:lastModified")
	private String lastModified;

	@Inject
	@Optional
	@Named("jcr:content/metadata/dc:title")
	private String title;

	@Inject
	@Optional
	@Named("jcr:content/metadata/dc:description")
	private String description;

	private String assetPath;

	@Inject
	@Optional
	@Named("jcr:content/metadata/aspectRatio")
	private String aspectRatio;

	@Inject
	@Optional
	@Named("jcr:content/metadata/certificateDescription")
	private String certificateDescription;

	@Inject
	@Optional
	@Named("jcr:content/metadata/certificateTitle")
	private String certificateTitle;

	@Inject
	@Optional
	@Named("jcr:content/metadata/length")
	private String length;

	@Inject
	@Optional
	@Named("jcr:content/metadata/productType")
	private String productType;

	@Inject
	@Optional
	@Named("jcr:content/metadata/softwareDescription")
	private String softwareDescription;

	@Inject
	@Optional
	@Named("jcr:content/metadata/softwareTitle")
	private String softwareTitle;

	@Inject
	@Optional
	@Named("jcr:content/metadata/videoDescription")
	private String videoDescription;

	@Inject
	@Optional
	@Named("jcr:content/metadata/videoTitle")
	private String videoTitle;

	@Inject
	@Optional
	@Named("jcr:content/metadata/whitepaperDescription")
	private String whitepaperDescription;

	@Inject
	@Optional
	@Named("jcr:content/metadata/whitepaperTitle")
	private String whitepaperTitle;

	@Inject
	@Optional
	@Named(com.day.cq.commons.jcr.JcrConstants.JCR_UUID)
	private String uuid;

	@Inject
	@Optional
	@Named("jcr:content/metadata/dc:language")
	private String language;

	@Inject
	@Optional
	@Named("jcr:content/metadata/format")
	private String format;

	@Inject
	@Optional
	@Named("jcr:content/metadata/material")
	private String material;

	@Inject
	@Optional
	@Named("jcr:content/metadata/imageURL")
	private String imageURL;

	@Inject
	@Optional
	@Named("jcr:content/metadata/softwareURL")
	private String softwareURL;

	@Inject
	@Optional
	@Named("jcr:content/metadata/videoPath")
	private String videoPath;

	@Inject
	@Named("jcr:content/metadata/mailSubject")
	@Optional
	private String subjectLine;

	@Inject
	@Named("jcr:content/metadata/mailMessage")
	@Optional
	private String messageBody;

	@Inject
	@Optional
	@Named("jcr:content/metadata/pageName")
	private String pageName;

	private String videothumbnailUrl;

	@Inject
	@Optional
	@Named("jcr:content/metadata/videoDuration")
	private String videoDuration;

	@Inject
	@Optional
	@Named("jcr:content/metadata/videoUploadDate")
	private String videoUploadDate;
	
	@Inject
	@Optional
	@Named("jcr:content/metadata/breadcrumbTitle")
	private String breadcrumbTitle;
	
	@Inject
	@Optional
	@Named("jcr:content/metadata/downloadFormH1Title")
	private String downloadFormH1Title;
	
	@Inject
	@Optional
	@Named("jcr:content/metadata/altText")
	private String altText;
	
	@Inject
	@Optional
	@Named("jcr:content/metadata/pageTitle")
	private String pageTitle;
	
	@Inject
	@Optional
	@Named("jcr:content/metadata/seoPageDescription")
	private String seoPageDescription;
	
	@Inject
	@Optional
	@Named
	private String faqQuestion;
	
	@Inject
	@Optional
	@Named
	private String faqAnswer;
	
	@Inject
	@Optional
	@Named
	private String uniqueId;
	
	
	public String getPageTitle() {
		return pageTitle;
	}
	
	public String getSeoPageDescription() {
		return seoPageDescription;
	}
	
	public String getBreadcrumbTitle() {
		return breadcrumbTitle;
	}
	
	public String getFaqQuestion() {
		return faqQuestion;
	}

	public void setFaqQuestion(String faqQuestion) {
		this.faqQuestion = faqQuestion;
	}

	public String getFaqAnswer() {
		return faqAnswer;
	}

	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getDownloadFormH1Title() {
		return downloadFormH1Title;
	}
	
	public String getAltText() {
		return altText;
	}

	public String getVideothumbnailUrl() {
		return videothumbnailUrl;
	}
	
	public void setVideothumbnailUrl(String videothumbnailUrl) {
		this.videothumbnailUrl = videothumbnailUrl;
	}

	public String getVideoDuration() {
		return videoDuration;
	}

	public String getVideoUploadDate() {
		return videoUploadDate;
	}

	public String getPageName() {
		return pageName;
	}

	private String assetRenditionImgPath48;

	private String assetRenditionImgPath140;

	public String getSubjectLine() {
		return subjectLine;
	}

	public void setSubjectLine(String subjectLine) {
		this.subjectLine = subjectLine;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getSoftwareURL() {
		return softwareURL;
	}

	public void setSoftwareURL(String softwareURL) {
		this.softwareURL = softwareURL;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	private String imgPath;

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getAspectRatio() {
		return aspectRatio;
	}

	public void setAspectRatio(String aspectRatio) {
		this.aspectRatio = aspectRatio;
	}

	public String getCertificateDescription() {
		return certificateDescription;
	}

	public void setCertificateDescription(String certificateDescription) {
		this.certificateDescription = certificateDescription;
	}

	public String getCertificateTitle() {
		return certificateTitle;
	}

	public void setCertificateTitle(String certificateTitle) {
		this.certificateTitle = certificateTitle;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getSoftwareDescription() {
		return softwareDescription;
	}

	public void setSoftwareDescription(String softwareDescription) {
		this.softwareDescription = softwareDescription;
	}

	public String getSoftwareTitle() {
		return softwareTitle;
	}

	public void setSoftwareTitle(String softwareTitle) {
		this.softwareTitle = softwareTitle;
	}

	public String getVideoDescription() {
		return videoDescription;
	}

	public void setVideoDescription(String videoDescription) {
		this.videoDescription = videoDescription;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getWhitepaperDescription() {
		return whitepaperDescription;
	}

	public void setWhitepaperDescription(String whitepaperDescription) {
		this.whitepaperDescription = whitepaperDescription;
	}

	public String getWhitepaperTitle() {
		return whitepaperTitle;
	}

	public void setWhitepaperTitle(String whitepaperTitle) {
		this.whitepaperTitle = whitepaperTitle;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getAssetPath() {
		return assetPath;
	}

	public void setAssetPath(String assetPath) {
		this.assetPath = assetPath;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
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

	public String getAssetRenditionImgPath140() {
		return assetRenditionImgPath140;
	}

	public void setAssetRenditionImgPath140(String assetRenditionImgPath140) {
		this.assetRenditionImgPath140 = assetRenditionImgPath140;
	}

	public String getAssetRenditionImgPath48() {
		return assetRenditionImgPath48;
	}

	public void setAssetRenditionImgPath48(String assetRenditionImgPath48) {
		this.assetRenditionImgPath48 = assetRenditionImgPath48;
	}

}
