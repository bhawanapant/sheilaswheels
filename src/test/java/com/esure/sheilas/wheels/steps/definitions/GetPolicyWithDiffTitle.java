package com.esure.sheilas.wheels.steps.definitions;

import com.esure.sheilas.wheels.steps.pageobjects.HomepageObject;
import com.esure.sheilas.wheels.steps.pageobjects.YourDetailsPageObject;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import static com.esure.sheilas.wheels.utility.Driver.getBrowser;
import static com.esure.sheilas.wheels.utility.Driver.open;


/**
 * Created by bhawana on 22/04/2017.
 */
public class GetPolicyWithDiffTitle implements En {
    public static WebDriver browser;
    public static HomepageObject homepageObject;
    public static YourDetailsPageObject yourDetailsPageObject;
    public static String givenURL = "https://www.sheilaswheels.com/";

    @Before
    public static void setUp() {
        try {
            browser = getBrowser();
        } catch (IOException e) {
            e.printStackTrace();
        }
        open(givenURL);
    }

    @Given("^user chooses to get car insurance quote$")
    public void userChoosesToGetCarInsuranceQuote() throws Throwable {
        homepageObject = new HomepageObject(browser);
        homepageObject.clickOnMotorQuote();
    }

    @When("^user enter all the necessary details with different title \"([^\"]*)\"$")
    public void userEnterAllTheNecessaryDetailsWithDifferentTitle(String title) throws Throwable {
        //Enter details in Your Details page.
        yourDetailsPageObject = new YourDetailsPageObject(browser);
        yourDetailsPageObject.enterDeatilsOnYourDetailsPageWithDifferentTitle(title);



    }

    @Then("^she should get the motor policy$")
    public void sheShouldGetTheMotorPolicy() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}