package com.sheilaswheels.stepdefs;

import com.sheilaswheels.config.ConfigVariables;
import com.sheilaswheels.domain.InsuranceData;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static com.sheilaswheels.utility.Driver.getBrowser;
import static com.sheilaswheels.utility.Driver.open;


/**
 * Created by bhawana on 22/04/2017.
 */
public class GetPolicyStepDefinitions implements En {

    private Logger LOGGER = LoggerFactory.getLogger(GetPolicyStepDefinitions.class);

    private WebDriver browser;
    private InsuranceData.YourDetails yourDetails;
    private InsuranceData.YouCar yourCar;
    private InsuranceData.YourQuote yourQuote;

    private Homepage homepage;
    private YourDetailsPage yourDetailsPage;
    private AboutYouPage aboutYouPage;
    private YourCarPage yourCarPage;
    private YourQuotePage yourQuotePage;
    private BreakdownOptionPage breakdownOptionPage;
    private String csvPath = "/Users/mohanpant/repos/sheilaswheels/src/test/resources/dataFile.csv";

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
    public void userEnterAllTheNecessaryDetailsWithDifferentTitleAnd(String title, String empStatus, String mStatus, String resStatus) throws Throwable {
        yourDetails = InsuranceData.YourDetails.builder()
            .customerDetails(InsuranceData.YourDetails.CustomerDetails.builder()
                .title(Title.get(title))
                .employmentStatus(EmploymentStatus.get(empStatus))
                .maritalStatus(MaritalStatus.get(mStatus))
                .residentialStatus(ResidentialStatus.get(resStatus)).build())
            .build();

        yourCar = InsuranceData.YouCar.builder().build();
        yourQuote = InsuranceData.YourQuote.builder().build();


        LogFile.getDetailsOfObjectUsedInLogFile(yourDetails);

        yourDetailsPage = new YourDetailsPage(browser);
        yourDetailsPage.populatePage(yourDetails);

        aboutYouPage = new AboutYouPage(browser);
        aboutYouPage.populateAboutYouDetails(yourDetails);

        yourCarPage = new YourCarPage(browser);
        yourCarPage.populateYourCarDetails(yourCar);

        yourQuotePage = new YourQuotePage(browser);
        yourQuotePage.selectExtraBoostOptionsAndRecalculateQuote(yourQuote);

        breakdownOptionPage = new BreakdownOptionPage();
        breakdownOptionPage.selectBreakdownOptionsAndRecalculateQuote(yourQuote);

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
