package com.esure.motorinsurance;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/sheilaswheels",
    glue = {"com.esure.motorinsurance.stepdefs",
        "cucumber.api.spring"},
    plugin = {"pretty", "html:target/cucumber"})
public class RunCukesTest {
}
