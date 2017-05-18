package com.esure.motorinsurance.webpages;

import com.esure.motorinsurance.domain.InsuranceData;
import com.esure.motorinsurance.domain.enumType.Title;
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

    @FindBy(how = How.XPATH , using = "//div[@class='content-area-centre']")
    private WebElement contentArea;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[1]//h2")
    private WebElement yourDetailHeading;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//h2")
    private WebElement aboutYouHeading;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//h2")
    private WebElement yourCarHeading;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[1]//span[@class='new__left']/li[1]/span")
    private WebElement titleC;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[1]//span[@class='new__left']/li[2]/span")
    private WebElement firstname;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[1]//span[@class='new__left']/li[3]/span")
    private WebElement surName;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[1]//span[@class='new__right']/li[1]/span")
    private WebElement email;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[1]//span[@class='new__right']/li[2]/span")
    private WebElement phoneNumber;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[1]//span[@class='new__right']/li[3]/span")
    private WebElement mainDriver;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[1]/span")
    private WebElement dob;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[2]/span")
    private WebElement ukResident;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[3]/span")
    private WebElement empStatus;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[4]/span")
    private WebElement occupation;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[5]/span")
    private WebElement industry;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[6]/span")
    private WebElement gender;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[7]/span")
    private WebElement maritalStatus;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[8]/span")
    private WebElement noOfChild;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__left']/li[9]/span")
    private WebElement resStatus;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[1]/span")
    private WebElement noOfCars;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[2]/span")
    private WebElement accessToAnyVehicle;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[3]/span")
    private WebElement licenseType;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[4]/span")
    private WebElement licenseHeldYear;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[5]/span")
    private WebElement ncdYear;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[6]/span")
    private WebElement coverStartDate;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[7]/span")
    private WebElement coverEndDate;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[8]/span")
    private WebElement registrationNum;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[9]/span")
    private WebElement houseNo;

    @FindBy(how = How.XPATH , using = "//div[@id='details-section']/ul[2]//span[@class='new__right']/li[10]/span")
    private WebElement postcode;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__left']//li[1]/span")
    private WebElement carMaker;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__left']//li[2]/span")
    private WebElement carModel;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__left']//li[3]/span")
    private WebElement fuelType;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__left']//li[4]/span")
    private WebElement transmissionType;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__left']//li[5]/span")
    private WebElement carResYear;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__left']//li[6]/span")
    private WebElement carEstimation;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__left']//li[7]/span")
    private WebElement milage;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__left']//li[8]/span")
    private WebElement carKeptOvernight;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__right']//li[1]/span")
    private WebElement carDateOfPurchase;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__right']//li[2]/span")
    private WebElement securityDeviceFitted;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__right']//li[3]/span")
    private WebElement legalOwner;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__right']//li[4]/span")
    private WebElement registerKeeper;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__right']//li[5]/span")
    private WebElement carTrackingDevice;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__right']//li[6]/span")
    private WebElement useOfCar;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__right']//li[7]/span")
    private WebElement coverLevel;

    @FindBy(how = How.XPATH , using = "//ul[@id='car-details']//span[@class='new__right']//li[8]/span")
    private WebElement modification;

    public QuoteDetailPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver,this);
    }

    public void verifyThatQuoteHasBeenCreatedWithCorrectValues(InsuranceData insuranceData)
        throws InterruptedException {

        clickOnYourDetailExpandButton();
        getYourDetailDataFromQuoteDetail();
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

    private InsuranceData createInsuranceDataFromQuoteDetailPage() {
        return InsuranceData.builder()
               .yourDetails(yourDetails)
               .yourCar(InsuranceData.YourCar.builder().build())
               .aboutYou(InsuranceData.AboutYou.builder().build())
               .motorClaims(InsuranceData.MotorClaims.builder().build())
               .additionalPartner(InsuranceData.AdditionalPartner.builder().build())
               .boostInsuranceCover(InsuranceData.BoostInsuranceCover.builder().build())
               .build();
    }

    private void getYourDetailDataFromQuoteDetail() {
        Title value = Title.get(titleC.getText());
        yourDetails = InsuranceData.YourDetails.builder()
                .title(value)
                .firstName(firstname.getText())
                .lastName(surName.getText())
                .emailAddress(email.getText()).build();
    }

    private void clickOnYourDetailExpandButton() {
//        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(yourDetailHeading));
        forcedSleepAsTheToggleTakeTimeToExpand();
        yourDetailHeading.click();
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
