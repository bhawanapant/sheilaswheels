package com.esure.motorinsurance.webpages;

import com.esure.motorinsurance.domain.InsuranceData;
import com.esure.motorinsurance.domain.enumType.Title;
import com.esure.motorinsurance.utility.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by bhawana on 24/05/2017.
 */
public class YourDetailsEsurePage {
    private final WebDriver aDriver;
    private JavascriptExecutor executor;

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Your details')]")
    private WebElement yourDetailHeading;

    @FindBy(how = How.CSS, using = "input#title_MR")
    private WebElement titleMr;

    @FindBy(how = How.CSS, using = "input#title_MRS")
    private WebElement titleMrs;

    @FindBy(how = How.CSS, using = "input#title_MIS")
    private WebElement titleMiss;

    @FindBy(how = How.CSS, using = "input#title_MS")
    private WebElement titleMs;

    @FindBy(how = How.CSS, using = "input#title_DR")
    private WebElement titleDr;

    @FindBy(how = How.ID, using = "firstName")
    private WebElement firstName;

    @FindBy(how = How.ID, using = "lastName")
    private WebElement surName;

    @FindBy(how = How.ID, using = "email")
    private WebElement email;

    @FindBy(how = How.ID, using = "confirmEmail")
    private WebElement confirmEmail;

    @FindBy(how = How.ID, using = "phoneNight")
    private WebElement phoneNumber;

    @FindBy(how = How.ID, using = "claimsFlag_0")
    private WebElement moterClaimYes;

    @FindBy(how = How.ID, using = "claimsFlag_1")
    private WebElement moterClaimNo;

    @FindBy(how = How.ID, using = "convictionsFlag_0")
    private WebElement motorConvictionYes;

    @FindBy(how = How.ID, using = "convictionsFlag_1")
    private WebElement motorConvictionNo;

    @FindBy(how = How.ID, using = "noOfAdditionalDrivers_0")
    private WebElement additionalDriverYes;

    @FindBy(how = How.ID, using = "noOfAdditionalDrivers_1")
    private WebElement additionalDriverNo;

    @FindBy(how = How.XPATH, using = "//input[@id='next']")
    private WebElement nextPage;

    public YourDetailsEsurePage(WebDriver aDriver) {
        this.aDriver = aDriver;
        executor = (JavascriptExecutor) aDriver;
        PageFactory.initElements(aDriver, this);

    }

    public void populateYourDetailsFromEsurePage(InsuranceData insuranceData) {
        Driver.waitForElementToLoad(yourDetailHeading);

        InsuranceData.YourDetails yourDetails = insuranceData.getYourDetails();
        InsuranceData.MotorClaims motorClaims = insuranceData.getMotorClaims();
        InsuranceData.AdditionalPartner additionalPartner = insuranceData.getAdditionalPartner();

        setTitle(yourDetails.getTitle().getValue());
        setFirstName(yourDetails.getFirstName());

        setSurName(yourDetails.getLastName());

        setEmail(yourDetails.getEmailAddress());

        setPhoneNumber(yourDetails.getPhoneNumber());
        setMotorClaimYesOrNo(motorClaims.isMotorClaims());

        setMotorConvictionYesOrNo(motorClaims.isMotorConviction());

        setAdditionalDriverFlag(additionalPartner.isAdditionalDriver());

        moveToNextPage();
    }

    private void setTitle(String value) {
        if (value.equals(Title.MR.getValue())) {
            executor.executeScript("arguments[0].click();", titleMr);
        } else if (value.equals(Title.MRS.getValue())) {
            executor.executeScript("arguments[0].click();", titleMrs);
        } else if (value.equals(Title.MISS.getValue())) {
            executor.executeScript("arguments[0].click();", titleMiss);
        } else if (value.equals(Title.MS.getValue())) {
            executor.executeScript("arguments[0].click();", titleMs);
        } else if (value.equals(Title.DR.getValue())) {
            executor.executeScript("arguments[0].click();", titleDr);
        }
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setSurName(String lasttName) {
        this.surName.sendKeys(lasttName);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.sendKeys(phoneNumber);
    }


    public void setMotorClaimYesOrNo(boolean motorClaimFlag) {
        if (motorClaimFlag) {
            executor.executeScript("arguments[0].click();", moterClaimYes);
        } else {
            executor.executeScript("arguments[0].click();", moterClaimNo);
        }
    }

    public void setMotorConvictionYesOrNo(boolean motorConvictionFlag) {
        if (motorConvictionFlag) {
            executor.executeScript("arguments[0].click();", motorConvictionYes);
        } else {
            executor.executeScript("arguments[0].click();", motorConvictionNo);
        }
    }

    public void setAdditionalDriverFlag(boolean addtionalDriverFlag) {
        if (addtionalDriverFlag) {
            executor.executeScript("arguments[0].click();", additionalDriverYes);
        } else {
            executor.executeScript("arguments[0].click();", additionalDriverNo);
        }
    }

    public void moveToNextPage() {
        nextPage.click();
    }

}
