package com.esure.motorinsurance.webpages;

import com.esure.motorinsurance.domain.InsuranceData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by bhawana on 24/05/2017.
 */
public class YourDetailsEsurePage {
    private final WebDriver aDriver;

    @FindBy(how = How.XPATH , using = "//h1[contains(text(),'Your details')]")
    private WebElement yourDetailHeading;

    @FindBy(how = How.XPATH , using = "//div[@class='wrapper_row']//label[1]")
    private WebElement titleMr;

    @FindBy(how = How.XPATH , using = "//div[@class='wrapper_row']//label[2]")
    private WebElement titleMrs;

    @FindBy(how = How.XPATH , using = "//div[@class='wrapper_row']//label[3]")
    private WebElement titleMiss;

    @FindBy(how = How.XPATH , using = "//div[@class='wrapper_row']//label[4]")
    private WebElement titleMs;

    @FindBy(how = How.XPATH , using = "//div[@class='wrapper_row']//label[5]")
    private WebElement titleDr;

    @FindBy(how = How.ID , using = "firstName")
    private WebElement firstName;

    @FindBy(how = How.ID , using = "lastName")
    private WebElement surName;

    @FindBy(how = How.ID , using = "email")
    private WebElement email;

    @FindBy(how = How.ID , using = "confirmEmail")
    private WebElement confirmEmail;

    @FindBy(how = How.ID , using = "phoneNight")
    private WebElement phoneNumber;

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

    @FindBy(how = How.XPATH , using = "//input[@id='next']")
    private WebElement nextPage;

    public YourDetailsEsurePage(WebDriver aDriver) {
        this.aDriver = aDriver;
    }

    public void populateYourDetailsFromEsurePage(InsuranceData insuranceData) {
       // Driver.waitForElementToLoad(yourDetailHeading);

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
        if (value.equals("Mr")){
            titleMr.click();
        }
        else
            if (value.equals("Mrs")){
            titleMrs.click();
            }
            else
                if (value.equals("Miss")){
                titleMiss.click();
                }
                else
                    if (value.equals("Ms")){
                    titleMs.click();
                    }
                    else
                        if (value.equals("Dr")){
                        titleDr.click();
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
        (motorClaimFlag ? moterClaimYes : moterClaimNo).click();
    }

    public void setMotorConvictionYesOrNo(boolean motorConvictionFlag) {
        (motorConvictionFlag ? motorConvictionYes : motorConvictionNo).click();
    }

    public void setAdditionalDriverFlag(boolean addtionalDriverFlag) {
        (addtionalDriverFlag ? additionalDriverYes : additionalDriverNo).click();
    }
    public void moveToNextPage() {
        nextPage.click();
    }

}
