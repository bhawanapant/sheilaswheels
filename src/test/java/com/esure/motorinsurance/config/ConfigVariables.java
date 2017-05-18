package com.esure.motorinsurance.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
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