package com.esure.motorinsurance.webpages;

import com.esure.motorinsurance.domain.InsuranceData;
import com.esure.motorinsurance.domain.enumType.EmploymentStatus;
import com.esure.motorinsurance.domain.enumType.MaritalStatus;
import com.esure.motorinsurance.domain.enumType.ResidentialStatus;
import com.esure.motorinsurance.domain.enumType.Title;
import com.esure.motorinsurance.utility.Driver;
import com.esure.motorinsurance.utility.LogFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by bhawana on 16/05/2017.
 */
public class QuoteDetailPage {
    WebDriver driver;
    private InsuranceData.YourDetails yourDetails;
    private InsuranceData.AboutYou aboutYou;


    @FindBy(how = How.XPATH , using = "//div[@class='content-area-centre']")
    private WebElement contentArea;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[1]//h2")
    private WebElement yourDetailHeading;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[1]/span")
    private WebElement yourDetailSpan;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]/span")
    private WebElement aboutYouSpan;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//h2")
    private WebElement aboutYouHeading;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//h2")
    private WebElement yourCarHeading;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[1]//span[@class='new__left']/li[1]/span")
    private WebElement titleQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[1]//span[@class='new__left']/li[2]/span")
    private WebElement firstnameQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[1]//span[@class='new__left']/li[3]/span")
    private WebElement surNameQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[1]//span[@class='new__right']/li[1]/span")
    private WebElement emailQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[1]//span[@class='new__right']/li[2]/span")
    private WebElement phoneNumberQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[1]//span[@class='new__right']/li[3]/span")
    private WebElement mainDriverQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[1]/span")
    private WebElement dobQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[2]/span")
    private WebElement ukResidentQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[3]/span")
    private WebElement empStatusQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[4]/span")
    private WebElement occupationQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[5]/span")
    private WebElement industryQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[6]/span")
    private WebElement genderQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[7]/span")
    private WebElement maritalStatusQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[8]/span")
    private WebElement noOfChildQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[9]/span")
    private WebElement resStatusQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[1]/span")
    private WebElement noOfCarsQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[2]/span")
    private WebElement accessToAnyVehicleQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[3]/span")
    private WebElement licenseTypeQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[4]/span")
    private WebElement licenseHeldYearQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[5]/span")
    private WebElement ncdYearQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[6]/span")
    private WebElement coverStartDateQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[7]/span")
    private WebElement coverEndDateQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[8]/span")
    private WebElement registrationNumQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[9]/span")
    private WebElement houseNoQ;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[10]/span")
    private WebElement postcodeQ;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__left']//li[1]/span")
    private WebElement carMakerQ;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__left']//li[2]/span")
    private WebElement carModelQ;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__left']//li[3]/span")
    private WebElement fuelTypeQ;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__left']//li[4]/span")
    private WebElement transmissionTypeQ;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__left']//li[5]/span")
    private WebElement carResYearQ;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__left']//li[6]/span")
    private WebElement carEstimationQ;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__left']//li[7]/span")
    private WebElement milageQ;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__left']//li[8]/span")
    private WebElement carKeptOvernightQ;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__right']//li[1]/span")
    private WebElement carDateOfPurchaseQ;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__right']//li[2]/span")
    private WebElement securityDeviceFittedQ;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__right']//li[3]/span")
    private WebElement legalOwnerQ;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__right']//li[4]/span")
    private WebElement registerKeeperQ;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__right']//li[5]/span")
    private WebElement carTrackingDeviceQ;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__right']//li[6]/span")
    private WebElement useOfCarQ;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__right']//li[7]/span")
    private WebElement coverLevelQ;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__right']//li[8]/span")
    private WebElement modificationQ;

    public QuoteDetailPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver,this);
    }

    public void verifyThatQuoteHasBeenCreatedWithCorrectValues(InsuranceData insuranceData)
        throws InterruptedException {

        clickOnExpandButton(yourDetailHeading);
        Driver.waitForElementToLoad(yourDetailSpan);
        getYourDetailDataFromQuoteDetail();

        clickOnExpandButton(aboutYouHeading);
        Driver.waitForElementToLoad(aboutYouSpan);
        getAboutYouDetailFromQuoteDetail();

        InsuranceData insuranceDataFromQuote = createInsuranceDataFromQuoteDetailPage();

        if(insuranceData.equals(insuranceDataFromQuote)) {
            try {
                LogFile.getDetailsOfObjectUsedInLogFile(insuranceDataFromQuote , "Quote Details are correct");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
            else
        {
            try {
                LogFile.getDetailsOfObjectUsedInLogFile(insuranceDataFromQuote, "Quote Details are not correct");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    private void getYourDetailDataFromQuoteDetail() {
        Title value = Title.get(titleQ.getText());
        yourDetails = InsuranceData.YourDetails.builder()
            .title(value)
            .firstName(firstnameQ.getText())
            .lastName(surNameQ.getText())
            .emailAddress(emailQ.getText()).build();
    }

    private void getAboutYouDetailFromQuoteDetail() {
        EmploymentStatus empS = EmploymentStatus.get(empStatusQ.getText());
        MaritalStatus maritalS = MaritalStatus.get(maritalStatusQ.getText());
        ResidentialStatus resS = ResidentialStatus.get(resStatusQ.getText());
        aboutYou = InsuranceData.AboutYou.builder()
                   .employmentStatus(empS)
                   .maritalStatus(maritalS)
                   .residentialStatus(resS).build();
    }

    private InsuranceData createInsuranceDataFromQuoteDetailPage() {
        return InsuranceData.builder()
               .yourDetails(yourDetails)
               .yourCar(InsuranceData.YourCar.builder().build())
               .aboutYou(aboutYou)
               .motorClaims(InsuranceData.MotorClaims.builder().build())
               .additionalPartner(InsuranceData.AdditionalPartner.builder().build())
               .boostInsuranceCover(InsuranceData.BoostInsuranceCover.builder().build())
               .build();
    }

    private void clickOnExpandButton(WebElement clickingElement) {
        forcedSleepAsTheToggleTakeTimeToExpand();
        clickingElement.click();
    }

    // TODO this is workaround need a proper fix
    private void forcedSleepAsTheToggleTakeTimeToExpand() {
        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
