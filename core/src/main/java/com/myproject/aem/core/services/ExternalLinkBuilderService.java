package com.myproject.aem.core.services;

import org.apache.sling.api.SlingHttpServletRequest;

public interface ExternalLinkBuilderService {

	public String buildExternalLink(SlingHttpServletRequest request);

	public String domainName(SlingHttpServletRequest request);

	public String deviceOS(SlingHttpServletRequest request);

}
