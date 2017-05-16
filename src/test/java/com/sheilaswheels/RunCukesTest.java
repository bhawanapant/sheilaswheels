package com.sheilaswheels;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.sheilaswheels.stepdefs",
        "cucumber.api.spring"},
    plugin = {"pretty", "html:target/cucumber"})
public class RunCukesTest {
}
