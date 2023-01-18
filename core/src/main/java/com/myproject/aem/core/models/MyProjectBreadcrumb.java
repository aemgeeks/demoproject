package com.myproject.aem.core.models;

import java.util.List;

import com.adobe.cq.wcm.core.components.models.Breadcrumb;
import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;

public interface MyProjectBreadcrumb extends Breadcrumb{
	/**
	 * List to return custom breadcrumb items
	 * @return List of breadcrumb items
	 */
	List<MyProjectNavigationItem> getNavItems();

	@Override	
	ComponentData getData();
}
