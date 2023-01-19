package com.myproject.aem.core.models.impl;

import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.settings.SlingSettingsService;

import com.myproject.aem.core.models.EnvironmentModel;

@Model(adaptables = Resource.class, adapters = EnvironmentModel.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class EnvironmentImpl implements EnvironmentModel {

    @OSGiService
    private SlingSettingsService settings;

    private String env;

    @PostConstruct
    void init() {
        Set<String> currentRunModes = settings.getRunModes();
            if (currentRunModes.contains("qa")) {
                env = "qa";
            } else if (currentRunModes.contains("stage")) {
                env = "stage";
            } else if (currentRunModes.contains("prod")) {
                env = "prod";
            } else {
                env = "dev";
            }
    }

    @Override
    public String getEnvironmentName() {
        return env;
    }

}
