package com.myproject.aem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BannerDetail {


	@ValueMapValue
	protected String fileReference;

	@Self
	private Resource resource;

	@ValueMapValue
	private String title;

	@ValueMapValue
	private String subHeading;

	@ValueMapValue
	private String heading;

	@ValueMapValue
	private String buttonLink;

	@ValueMapValue
	private boolean newTab;

	@ValueMapValue
	private String video;

	public String getVideo() {
		return video;
	}

	public String getTitle() {
		return title;
	}

	public String getSubHeading() {
		return subHeading;
	}

	public String getHeading() {
		return heading;
	}

	public String getButtonLink() {
		return buttonLink;
	}

	public boolean isNewTab() {
		return newTab;
	}


}
