package com.esure.sheilas.wheels.config;

import com.esure.sheilas.wheels.annotation.SpringTestAnnotation;
import com.esure.sheilas.wheels.domain.CustomerDetails;
import cucumber.api.java8.En;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SpringTestAnnotation
public class ConfigTest implements En {

    private final Logger LOGGER = LoggerFactory.getLogger(ConfigTest.class);

    @Autowired
    private ConfigVariable configVariable;

    private CustomerDetails customerDetails;

    public ConfigTest() {
        Given("^the user is on landing page$", () -> {
            LOGGER.info("user landing page is " + configVariable.getUrl());
            LOGGER.info("tester is  " + configVariable.getTester());
        });
    }
}
