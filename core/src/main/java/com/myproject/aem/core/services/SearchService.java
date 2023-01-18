package com.myproject.aem.core.services;


import org.apache.sling.api.resource.ResourceResolver;

import com.myproject.aem.core.bean.SearchResultVO;
public interface SearchService {
    
    public SearchResultVO searchByKeyword(String keyword, String offset, String rootpath, String assetpath);

    public ResourceResolver getResourceResolver();
}
