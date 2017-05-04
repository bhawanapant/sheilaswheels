package com.sheilaswheels.config;

import org.springframework.beans.factory.annotation.Value;

public class ConfigVariables {

    @Value("${url}")
    private String url;

    @Value("${tester}")
    private String tester;

    @Value("${component}")
    private String component;


    public String getUrl() {
        return url;
    }

    public String getTester() {
        return tester;
    }

    public String getComponent() {
        return component;
    }
}
