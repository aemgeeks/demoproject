package com.myproject.aem.core.models.impl;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myproject.aem.core.models.ExternalizerConfigData;
import com.myproject.aem.core.services.ExternalLinkBuilderService;

@Model(adaptables = { SlingHttpServletRequest.class, Resource.class }, 
       adapters = ExternalizerConfigData.class, 
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ExternalizerConfigDataImpl implements ExternalizerConfigData {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @OSGiService
    private ExternalLinkBuilderService extLink;

    @SlingObject
    private SlingHttpServletRequest request;

    private String externalLink;

    private String domainName;

    @PostConstruct
    protected void init() {

        externalLink = extLink.buildExternalLink(request);
        logger.info("externalLink: {}", externalLink);

        domainName = extLink.domainName(request);
        logger.info("domainName: {}", domainName);
    }

    @Override
    public String getExternalLink() {
        return externalLink;
    }

    @Override
    public String getDomainName() {
        return domainName;
    }

}
