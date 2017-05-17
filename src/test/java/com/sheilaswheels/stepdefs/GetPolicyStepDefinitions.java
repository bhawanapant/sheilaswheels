package com.sheilaswheels.stepdefs;

import com.sheilaswheels.config.ConfigVariables;
import com.sheilaswheels.domain.InsuranceData;
import com.sheilaswheels.domain.InsuranceData.*;
import com.sheilaswheels.domain.enumType.EmploymentStatus;
import com.sheilaswheels.domain.enumType.MaritalStatus;
import com.sheilaswheels.domain.enumType.ResidentialStatus;
import com.sheilaswheels.domain.enumType.Title;
import com.sheilaswheels.utility.LogFile;
import com.sheilaswheels.webpages.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static com.sheilaswheels.utility.Driver.getBrowser;
import static com.sheilaswheels.utility.Driver.open;


/**
 * Created by bhawana on 22/04/2017.
 */
public class GetPolicyStepDefinitions implements En {

    private WebDriver browser;
    private InsuranceData insuranceData;


    private Homepage homepage;
    private YourDetailsPage yourDetailsPage;
    private AboutYouPage aboutYouPage;
    private YourCarPage yourCarPage;
    private YourQuotePage yourQuotePage;
    private BreakdownOptionPage breakdownOptionPage;

    @Autowired
    private ConfigVariables configVariables;

    @Before
    public void setUp() {
        try {
            browser = getBrowser();
        } catch (IOException e) {
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
    public void userEnterAllTheNecessaryDetailsWithDifferentTitleAnd(
        String title, String empStatus, String mStatus, String resStatus) throws Throwable {

        insuranceData = InsuranceData.builder()
            .yourDetails(YourDetails.builder()
                .title(Title.get(title)).build())
            .aboutYou(AboutYou.builder()
                .employmentStatus(EmploymentStatus.get(empStatus))
                .maritalStatus(MaritalStatus.get(mStatus))
                .residentialStatus(ResidentialStatus.get(resStatus)).build())
            .yourCar(YourCar.builder().build())
            .motorClaims(MotorClaims.builder().build())
            .additionalPartner(AdditionalPartner.builder().build())
            .boostInsuranceCover(BoostInsuranceCover.builder().build())
            .build();


        LogFile.getDetailsOfObjectUsedInLogFile(insuranceData.getYourDetails());

        yourDetailsPage = new YourDetailsPage(browser);
        yourDetailsPage.populateYourDetails(insuranceData);

        aboutYouPage = new AboutYouPage(browser);
        aboutYouPage.populateAboutYouDetails(insuranceData);

        yourCarPage = new YourCarPage(browser);
        yourCarPage.populateYourCarDetails(insuranceData);

        yourQuotePage = new YourQuotePage(browser);
        yourQuotePage.selectExtraBoostOptionsAndRecalculateQuote(insuranceData);

        breakdownOptionPage = new BreakdownOptionPage(browser);
        breakdownOptionPage.selectBreakdownOptionsAndRecalculateQuote(insuranceData);

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot camera = (TakesScreenshot) browser;
            byte[] screenShot = camera.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShot, "image/png");
            scenario.write("url: "+ browser.getCurrentUrl());
        }
    }
}
