package com.sheilaswheels.stepdefs;

import com.sheilaswheels.config.ConfigVariables;
import com.sheilaswheels.domain.YourDetails;
import com.sheilaswheels.domain.enumType.Title;
import com.sheilaswheels.webpages.AboutYouPage;
import com.sheilaswheels.webpages.Homepage;
import com.sheilaswheels.webpages.YourDetailsPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static com.sheilaswheels.utility.Driver.getBrowser;
import static com.sheilaswheels.utility.Driver.open;


/**
 * Created by bhawana on 22/04/2017.
 */
public class GetPolicyStepDefinitions implements En {
    private static WebDriver browser;
    private static Homepage homepage;
    private YourDetailsPage yourDetailsPage;
    private static AboutYouPage aboutYouPage;
    private YourDetails yourDetails;

    @Autowired
    private ConfigVariables configVariables;

    @Before
    public void setUp() {
        try {
            browser = getBrowser();
        }catch (IOException e) {
            e.printStackTrace();
        }
            open(configVariables.getUrl());
    }

    @Given("^user chooses to get car insurance quote$")
    public void userChoosesToGetCarInsuranceQuote() throws Throwable {
        homepage = new Homepage(browser);
        homepage.clickOnMotorQuote();
    }

    @When("^user enter all the necessary details with different title \"([^\"]*)\"$")
    public void userEnterAllTheNecessaryDetailsWithDifferentTitle(String title) throws Throwable {
        yourDetails = YourDetails.builder()
            .customerDetails(YourDetails.CustomerDetails.builder()
                .title(Title.get(title)).build())
            .build();

        yourDetailsPage = new YourDetailsPage(browser);
        yourDetailsPage.populatePage(yourDetails);

        aboutYouPage = new AboutYouPage(browser);
        aboutYouPage.populateAboutYouDetails(yourDetails);
    }

    @Then("^she should get the motor policy$")
    public void sheShouldGetTheMotorPolicy() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Yet to Implement");
    }
}