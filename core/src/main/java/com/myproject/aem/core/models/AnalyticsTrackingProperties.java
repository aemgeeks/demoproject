package com.myproject.aem.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myproject.aem.core.services.ExternalLinkBuilderService;
import com.day.cq.wcm.api.Page;

@Model(adaptables = { SlingHttpServletRequest.class,
		Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AnalyticsTrackingProperties {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@ScriptVariable
	Page currentPage;

	@OSGiService
	ExternalLinkBuilderService extLink;

	@SlingObject
	SlingHttpServletRequest request;

	String domainName;
	String deviceOS;

	String currentPagePath;

	@PostConstruct
	protected void init() {
		domainName = extLink.domainName(request);
		logger.info("domainName: {}", domainName);

		deviceOS = extLink.deviceOS(request);
	}

	public String getDomainName() {
		return domainName;
	}

	public String getCurrentPagePath() {
		String currentPagePath = extLink.buildExternalLink(request);
		if (currentPagePath.contains("/content/myproject")) {
			currentPagePath = currentPagePath.replace("/content/myproject", "/content/myproject");
		}

		return currentPagePath + ".html";
	}

	public String getDeviceOS() {
		String userAgent = request.getHeader("User-Agent");
		String os = "";
		if (userAgent.toLowerCase().indexOf("windows") >= 0) {
			os = "Windows";
		} else if (userAgent.toLowerCase().indexOf("mac") >= 0) {
			os = "Mac";
		} else if (userAgent.toLowerCase().indexOf("x11") >= 0) {
			os = "Unix";
		} else if (userAgent.toLowerCase().indexOf("android") >= 0) {
			os = "Android";
		} else if (userAgent.toLowerCase().indexOf("iphone") >= 0) {
			os = "IPhone";
		} else {
			os = "UnKnown More-Info: " + userAgent;
		}
		return os;
	}

	public String getEnv() {
		String env = "";
		if (domainName.contains("dev")) {
			env = "dev";
		} else if (domainName.contains("qa")) {
			env = "qa";
		} else if (domainName.contains("uat")) {
			env = "uat";
		} else if (domainName.contains("stage")) {
			env = "stage";
		} else if (domainName.contains("localhost")) {
			env = "local";
		}  else {
			env = "prod";
		}
		return env;
	}

	public String getPageType() {
		String type = "";
		if (currentPage.getPath().contains("404")) {
			type = "error page | 404";
		} else {
			type = (currentPage.getPageTitle() != null ? currentPage.getPageTitle() : currentPage.getTitle()) + " Page";
		}
		return type;
	}

	public String getPrevPage() {
		String previousPage = getDomainName() + currentPage.getParent().getPath();
		if (previousPage.contains("/content/myproject")) {
			previousPage = previousPage.replace("/content/myproject", "/content/myproject");
		}
		return previousPage;
	}

}
