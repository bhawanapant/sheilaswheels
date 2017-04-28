package com.esure.sheilas.wheels.steps.definitions;

import com.esure.sheilas.wheels.domain.YourDetails;
import com.esure.sheilas.wheels.domain.enumType.Title;
import com.esure.sheilas.wheels.steps.pageobjects.AboutYouPage;
import com.esure.sheilas.wheels.steps.pageobjects.Homepage;
import com.esure.sheilas.wheels.steps.pageobjects.YourDetailsPage;
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
public class GetPolicyStepDefinitions implements En {
    private static WebDriver browser;
    private static Homepage homepage;
    private YourDetailsPage yourDetailsPage;
    private static AboutYouPage aboutYouPage;
    public static String givenURL = "http://www.sheilaswheels.com";
    private YourDetails yourDetails;

    @Before
    public static void setUp() {
        try {
            browser = getBrowser();
        }catch (IOException e) {
            e.printStackTrace();
        }
            open(givenURL);
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
        yourDetailsPage.yourDetailsWithTitle(yourDetails);

        aboutYouPage = new AboutYouPage(browser);
        aboutYouPage.populateAboutYouDetails(yourDetails);


    }

    @Then("^she should get the motor policy$")
    public void sheShouldGetTheMotorPolicy() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Yet to Implement");
    }
}