package com.myproject.aem.core.models;

import java.util.List;

import com.adobe.cq.wcm.core.components.models.Navigation;

public interface MyProjectNavigation extends Navigation{
	/**
	 * List to return custom navigation items
	 * @return List of navigation items
	 */
	List<MyProjectNavigationItem> getNavItems();
}
