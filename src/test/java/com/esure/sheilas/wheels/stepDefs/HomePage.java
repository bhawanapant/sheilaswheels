package com.esure.sheilas.wheels.stepDefs;

import com.esure.sheilas.wheels.annotation.SpringTestAnnotation;
import com.esure.sheilas.wheels.config.ConfigVariable;
import com.esure.sheilas.wheels.domain.CustomerDetails;
import com.esure.sheilas.wheels.domain.enumType.Title;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SpringTestAnnotation
public class HomePage implements En {

    private final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    @Autowired
    private ConfigVariable configVariable;

    private CustomerDetails customerDetails;

    public HomePage() {
        Given("^the user is on landing page$", () -> {
            LOGGER.info("user landing page is " + configVariable.getUrl());
            LOGGER.info("tester is  " + configVariable.getTester());
        });
        Given("^user chooses to get car insurance quote$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
        When("^user enter all the necessary details$", () -> {
            //Enter Your Details

            //Enter Your Car Details

            //
        });

        When("^user enter all the necessary details with different title \"([^\"]*)\"$", (String title) -> {
            // Write code here that turns the phrase above into concrete actions
            customerDetails = new CustomerDetails.CustomerDetailsBuilder()
                    .title(Title.valueOf(title)).build();

            //pass this to page object
//            setfield(customerDetails)
        });
        Then("^she should get the motor policy$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
