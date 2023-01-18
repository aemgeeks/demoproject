package com.myproject.aem.core.bean;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AnimationDetails {
    @ValueMapValue
    private String title;
    @ValueMapValue
    private String subHeading;
    @ValueMapValue
    private String buttonlabel;
    @ValueMapValue
    private String buttonLink;
    @ValueMapValue
    private String newTab;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSubHeading() {
        return subHeading;
    }
    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }
    public String getButtonlabel() {
        return buttonlabel;
    }
    public void setButtonlabel(String buttonlabel) {
        this.buttonlabel = buttonlabel;
    }
    public String getButtonLink() {
        return buttonLink;
    }
    public void setButtonLink(String buttonLink) {
        this.buttonLink = buttonLink;
    }
    public String getNewTab() {
        return newTab;
    }
    public void setNewTab(String newTab) {
        this.newTab = newTab;
    }
   
}
