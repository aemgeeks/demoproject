package com.myproject.aem.core.models.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.via.ResourceSuperType;

import com.adobe.cq.wcm.core.components.models.Breadcrumb;
import com.adobe.cq.wcm.core.components.models.NavigationItem;
import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.myproject.aem.core.models.MyProjectBreadcrumb;
import com.myproject.aem.core.models.MyProjectNavigationItem;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { MyProjectBreadcrumb.class,
		Breadcrumb.class }, resourceType = BreadcrumbImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BreadcrumbImpl implements MyProjectBreadcrumb {

	// points to the the component resource path in ui.apps
	protected static final String RESOURCE_TYPE = "myproject/components/breadcrumb";

	@Self
	@Via(type = ResourceSuperType.class)
	private Breadcrumb coreBreadcrumb;

	private List<MyProjectNavigationItem> items;

	@SlingObject
	private ResourceResolver resourceResolver;

	@PostConstruct
	protected void init() {
		items = new ArrayList<>();
		if (null != coreBreadcrumb) {
			for (NavigationItem coreNavItem : coreBreadcrumb.getItems()) {
				if (!isHideInBreadcrumb(coreNavItem)) {
					MyProjectNavigationItem navItem = new MyProjectNavigationItem();
					navItem.setTitle(coreNavItem.getTitle());
					navItem.setURL(coreNavItem.getLink().getURL());
					navItem.setCurrent(coreNavItem.isCurrent());
					navItem.setActive(coreNavItem.isActive());
					navItem.setData(coreNavItem.getData());

					items.add(navItem);
				}
			}
		}
	}

	@Override
	public ComponentData getData() {
		return coreBreadcrumb.getData();
	}

	@Override
	public List<MyProjectNavigationItem> getNavItems() {
		return Collections.unmodifiableList(items);
	}

	/**
	 * Method to check if the item has to be hidden in breadcrumb
	 * 
	 * @param coreNavItem used to read the page path
	 * @return boolean true or false
	 */
	private boolean isHideInBreadcrumb(NavigationItem coreNavItem) {
		if (null != coreNavItem.getPath()) {
			Resource resource = resourceResolver.getResource(coreNavItem.getPath());
			if (null != resource) {
				Resource jcrContentResource = resource.getChild("jcr:content");
				if (null != jcrContentResource) {
					ValueMap valueMap = jcrContentResource.getValueMap();
					return valueMap.get("hideInBreadCrumb", false);
				}
			}
		}
		return false;
	}

}