package com.esure.sheilas.wheels.steps.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by bhawana on 27/04/2017.
 */
public class YourDetailsPOF {
    WebDriver driver;

    @FindBy(how = How.XPATH , using = "//h1[contains(text(),'Your details')]")
    public WebElement yourDetailHeading;

    @FindBy(how = How.CSS , using = "select[id='title']")
    public WebElement customerTitle;

    @FindBy(how = How.ID , using = "firstName")
    public WebElement firstName;

    @FindBy(how = How.ID , using = "lastName")
    public WebElement lastName;

    @FindBy(how = How.ID , using = "email")
    public WebElement email;

    @FindBy(how = How.ID , using = "confirmEmail")
    public WebElement confirmEmail;

    @FindBy(how = How.ID , using = "phoneNight")
    public WebElement phoneNumber;

    @FindBy(how = How.ID , using = "phoneDay")
    public WebElement additionalPhoneNumber;

    @FindBy(how = How.ID , using = "claimsFlag_0")
    public WebElement moterClaimYes;

    @FindBy(how = How.ID , using = "claimsFlag_1")
    public WebElement moterClaimNo;

    @FindBy(how = How.ID , using = "convictionsFlag_0")
    public WebElement motorConvictionYes;

    @FindBy(how = How.ID , using = "convictionsFlag_1")
    public WebElement motorConvictionNo;

    @FindBy(how = How.ID , using = "noOfAdditionalDrivers_0")
    public WebElement additionalDriverYes;

    @FindBy(how = How.ID , using = "noOfAdditionalDrivers_1")
    public WebElement additionalDriverNo;

    @FindBy(how = How.CSS , using = "select[id='sourceCode']")
    public WebElement sourceOfYourVisit;

    @FindBy(how = How.XPATH , using = "//input[@id='next']")
    public WebElement nextPage;

    public YourDetailsPOF(WebDriver driver){
        this.driver = driver;
    }
}
