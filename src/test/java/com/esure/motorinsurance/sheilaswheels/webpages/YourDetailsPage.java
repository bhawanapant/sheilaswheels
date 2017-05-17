package com.esure.motorinsurance.sheilaswheels.webpages;

import com.esure.motorinsurance.sheilaswheels.domain.InsuranceData;
import com.esure.motorinsurance.sheilaswheels.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by bhawana on 23/04/2017.
 */
public class YourDetailsPage {
    private final WebDriver aDriver;

    @FindBy(how = How.XPATH , using = "//h1[contains(text(),'Your details')]")
    private WebElement yourDetailHeading;

    @FindBy(how = How.CSS , using = "select[id='title']")
    private WebElement customerTitle;

    @FindBy(how = How.ID , using = "firstName")
    private WebElement firstName;

    @FindBy(how = How.ID , using = "lastName")
    private WebElement lastName;

    @FindBy(how = How.ID , using = "email")
    private WebElement email;

    @FindBy(how = How.ID , using = "confirmEmail")
    private WebElement confirmEmail;

    @FindBy(how = How.ID , using = "phoneNight")
    private WebElement phoneNumber;

    @FindBy(how = How.ID , using = "phoneDay")
    private WebElement additionalPhoneNumber;

    @FindBy(how = How.ID , using = "claimsFlag_0")
    private WebElement moterClaimYes;

    @FindBy(how = How.ID , using = "claimsFlag_1")
    private WebElement moterClaimNo;

    @FindBy(how = How.ID , using = "convictionsFlag_0")
    private WebElement motorConvictionYes;

    @FindBy(how = How.ID , using = "convictionsFlag_1")
    private WebElement motorConvictionNo;

    @FindBy(how = How.ID , using = "noOfAdditionalDrivers_0")
    private WebElement additionalDriverYes;

    @FindBy(how = How.ID , using = "noOfAdditionalDrivers_1")
    private WebElement additionalDriverNo;

    @FindBy(how = How.CSS , using = "select[id='sourceCode']")
    private WebElement sourceOfYourVisit;

    @FindBy(how = How.XPATH , using = "//input[@id='next']")
    private WebElement nextPage;

    public YourDetailsPage(WebDriver driver) {
        this.aDriver = driver;
        PageFactory.initElements(driver,this);
    }

    public void populateYourDetails(InsuranceData insuranceData) {
        Driver.waitForPageElementToLoad(yourDetailHeading);

       InsuranceData.YourDetails yourDetails = insuranceData.getYourDetails();
       InsuranceData.MotorClaims motorClaims = insuranceData.getMotorClaims();
       InsuranceData.AdditionalPartner additionalPartner = insuranceData.getAdditionalPartner();

        setTitle(yourDetails.getTitle().getValue());

        setFirstName(yourDetails.getFirstName());

        setLastName(yourDetails.getLastName());

        setEmail(yourDetails.getEmailAddress());

        setConfirmEmail(yourDetails.getEmailAddress());

        setPhoneNumber(yourDetails.getPhoneNumber());

        setAdditionalPhoneNumber(yourDetails.getPhoneNumber());

        setMotorClaimYesOrNo(motorClaims.isMotorClaims());

        setMotorConvictionYesOrNo(motorClaims.isMotorConviction());

        setAdditionalDriverFlag(additionalPartner.isAdditionalDriver());

        setVisitorReason();

        moveToNextPage();
    }

    public void setTitle(String title) {
        new Select(this.customerTitle).selectByVisibleText(title);
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lasttName) {
        this.lastName.sendKeys(lasttName);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail.sendKeys(confirmEmail);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.sendKeys(phoneNumber);
    }

    public void setAdditionalPhoneNumber(String additionalPhoneNumber) {
        this.additionalPhoneNumber.sendKeys(additionalPhoneNumber);
    }

    public void setMotorClaimYesOrNo(boolean motorClaimFlag) {
        (motorClaimFlag ? moterClaimYes : moterClaimNo).click();
    }

    public void setMotorConvictionYesOrNo(boolean motorConvictionFlag) {
        (motorConvictionFlag ? motorConvictionYes : motorConvictionNo).click();
    }

    public void setAdditionalDriverFlag(boolean addtionalDriverFlag) {
        (addtionalDriverFlag ? additionalDriverYes : additionalDriverNo).click();
    }

    public void setVisitorReason() {
        new Select(sourceOfYourVisit).selectByIndex(3);
    }

    public void moveToNextPage() {
        nextPage.click();
    }
}
