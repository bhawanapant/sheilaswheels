package com.esure.sheilas.wheels.stepDefs;

import com.esure.sheilas.wheels.annotation.SpringTestAnnotation;
import com.esure.sheilas.wheels.config.ConfigVariable;
import cucumber.api.java8.En;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SpringTestAnnotation
public class HomePage implements En {

    private final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    @Autowired
    private ConfigVariable configVariable;

    public HomePage() {
        Given("^the user is on landing page$", () -> {
            LOGGER.info("user landing page is " + configVariable.getUrl());
            LOGGER.info("tester is  " + configVariable.getTester());
        });

        When("^she chooses to get car insurance quote$", () -> {
        });

        Then("^she should land in car insurance page$", () -> {
        });
    }
}
