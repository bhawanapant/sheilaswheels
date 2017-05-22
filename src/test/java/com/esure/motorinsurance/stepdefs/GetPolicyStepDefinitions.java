package com.esure.motorinsurance.stepdefs;

import com.esure.motorinsurance.config.ConfigVariables;
import com.esure.motorinsurance.domain.InsuranceData;
import com.esure.motorinsurance.domain.enumType.EmploymentStatus;
import com.esure.motorinsurance.domain.enumType.MaritalStatus;
import com.esure.motorinsurance.domain.enumType.ResidentialStatus;
import com.esure.motorinsurance.domain.enumType.Title;
import com.esure.motorinsurance.utility.Driver;
import com.esure.motorinsurance.webpages.*;
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


/**
 * Created by bhawana on 22/04/2017.
 */
public class GetPolicyStepDefinitions implements En {

    private WebDriver webDriver;
    private InsuranceData insuranceData;


    private Homepage homepage;
    private YourDetailsPage yourDetailsPage;
    private AboutYouPage aboutYouPage;
    private YourCarPage yourCarPage;
    private YourQuotePage yourQuotePage;
    private BreakdownOptionPage breakdownOptionPage;
    private QuoteDetailPage quoteDetailPage;
    private String browser;


    @Autowired
    private ConfigVariables configVariables;

    @Before
    public void setUp() {
        browser = configVariables.getBrowser();
        try {
            if(browser == null){
                browser = System.getProperty("browser");
            }
            else {
                webDriver = Driver.getBrowser(browser);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Driver.open(configVariables.getUrl());
    }

    @Given("^user chooses to get car insurance quote$")
    public void userChoosesToGetCarInsuranceQuote() throws Throwable {
        homepage = new Homepage(webDriver);
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
            .yourDetails(InsuranceData.YourDetails.builder()
                .title(Title.get(title)).build())
            .aboutYou(InsuranceData.AboutYou.builder()
                .employmentStatus(EmploymentStatus.get(empStatus))
                .maritalStatus(MaritalStatus.get(mStatus))
                .residentialStatus(ResidentialStatus.get(resStatus)).build())
            .yourCar(InsuranceData.YourCar.builder().build())
            .motorClaims(InsuranceData.MotorClaims.builder().build())
            .additionalPartner(InsuranceData.AdditionalPartner.builder().build())
            .boostInsuranceCover(InsuranceData.BoostInsuranceCover.builder().build())
            .build();

        yourDetailsPage = new YourDetailsPage(webDriver);
        yourDetailsPage.populateYourDetails(insuranceData);

        aboutYouPage = new AboutYouPage(webDriver);
        aboutYouPage.populateAboutYouDetails(insuranceData);

        yourCarPage = new YourCarPage(webDriver);
        yourCarPage.populateYourCarDetails(insuranceData);

        yourQuotePage = new YourQuotePage(webDriver);
        yourQuotePage.selectExtraBoostOptionsAndRecalculateQuote(insuranceData);

        breakdownOptionPage = new BreakdownOptionPage(webDriver);
        breakdownOptionPage.selectBreakdownOptionsAndRecalculateQuote(insuranceData);

        quoteDetailPage = new QuoteDetailPage(webDriver);
        quoteDetailPage.verifyThatQuoteHasBeenCreatedWithCorrectValues(insuranceData);

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot camera = (TakesScreenshot) webDriver;
            byte[] screenShot = camera.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShot, "image/png");
        } else {
            scenario.write("Quote Detail is found in testData.log file ");
        }
    }
}
