package com.esure.motorinsurance.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigVariables {

    @Value("${url}")
    private String url;

    @Value("${tester}")
    private String tester;

    @Value("${browser}")
    private String browser;

    public String getUrl() {
        return url;
    }

    public String getTester() {
        return tester;
    }

    public String getBrowser() {
        return browser;
    }
}