package com.sheilaswheels.stepdefs;

import com.sheilaswheels.config.ConfigVariables;
import com.sheilaswheels.domain.YouCar;
import com.sheilaswheels.domain.YourDetails;
import com.sheilaswheels.domain.enumType.EmploymentStatus;
import com.sheilaswheels.domain.enumType.MaritalStatus;
import com.sheilaswheels.domain.enumType.ResidentialStatus;
import com.sheilaswheels.domain.enumType.Title;
import com.sheilaswheels.webpages.AboutYouPage;
import com.sheilaswheels.webpages.Homepage;
import com.sheilaswheels.webpages.YourCarPage;
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
    private YourCarPage yourCarPage;
    private YourDetails yourDetails;
    private YouCar yourCar;


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


    @Then("^she should get the motor policy$")
    public void sheShouldGetTheMotorPolicy() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Yet to Implement");
    }

    @When("^user enter all the necessary details with different title \"([^\"]*)\" And \"([^\"]*)\" ,\"([^\"]*)\",\"([^\"]*)\"$")
    public void userEnterAllTheNecessaryDetailsWithDifferentTitleAnd(String title, String empStatus, String mStatus, String resStatus) throws Throwable {
        yourDetails = YourDetails.builder()
            .customerDetails(YourDetails.CustomerDetails.builder()
                .title(Title.get(title))
                .employmentStatus(EmploymentStatus.get(empStatus))
                .maritalStatus(MaritalStatus.get(mStatus))
                .residentialStatus(ResidentialStatus.get(resStatus)).build())
            .build();

        yourCar = YouCar.builder().build();

        yourDetailsPage = new YourDetailsPage(browser);
        yourDetailsPage.populatePage(yourDetails);

        aboutYouPage = new AboutYouPage(browser);
        aboutYouPage.populateAboutYouDetails(yourDetails);

        yourCarPage = new YourCarPage(browser);
        yourCarPage.populateYourCarDetails(yourCar);
    }
}
