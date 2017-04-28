package com.esure.sheilas.wheels.steps.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by bhawana on 27/04/2017.
 */
public class AboutYouPOF {
    WebDriver webDriver;

    @FindBy(how = How.XPATH , using = "//h1[contains(text(),'About you')]")
    public WebElement aboutYouHeading;

    @FindBy(how = How.CSS , using = "input[id='input-dob.day']")
    public WebElement dayDOB;

    @FindBy(how = How.CSS , using = "input[id='input-dob.month']")
    public WebElement monthDOB;

    @FindBy(how = How.CSS , using = "input[id='input-dob.year']")
    public WebElement yearDOB;

    @FindBy(how = How.ID , using = "ukResident_0")
    public WebElement residentUKYes;

    @FindBy(how = How.ID , using = "ukResident_1")
    public WebElement residentUKNo;

    @FindBy(how = How.CSS , using = "select[id='employmentStatus']")
    public WebElement employmentStatus;

    @FindBy(how = How.CSS , using = "input[id='occupationOther']")
    public WebElement occupation;

    @FindBy(how = How.CSS , using = "input[id='secondaryOccupationFlag_0']")
    public WebElement occupationOtherYes;

    @FindBy(how = How.CSS , using = "input[id='secondaryOccupationFlag_1']")
    public WebElement occupationOtherNo;

    @FindBy(how = How.CSS , using = "input[id='industry']")
    public WebElement industry;

    @FindBy(how = How.ID , using = "gender_0")
    public WebElement genderMale;

    @FindBy(how = How.ID , using = "gender_1")
    public WebElement genderFemale;

    @FindBy(how = How.CSS , using = "select[id='maritalStatus']")
    public WebElement maritalStatus;

    @FindBy(how = How.CSS , using = "select[id='motorNumberOfChildren']")
    public WebElement motorNumberOfChildren;

    @FindBy(how = How.CSS , using = "select[id='residentialStatus']")
    public WebElement residentialStatus;

    @FindBy(how = How.CSS , using = "select[id='renewalMonthContents']")
    public WebElement renewalMonthContents;

    @FindBy(how = How.CSS , using = "select[id='renewalMonthBuildings']")
    public WebElement renewalMonthBuildings;

    @FindBy(how = How.CSS , using = "select[id='numberOfHouseholdCars']")
    public WebElement numberOfHouseholdCars;

    @FindBy(how = How.CSS , using = "select[id='useOtherCars']")
    public WebElement useOtherVehicle;

    @FindBy(how = How.CSS , using = "select[id='licenseType']")
    public WebElement licenseType;

    @FindBy(how = How.CSS , using = "select[id='licenceHeldYearList']")
    public WebElement licenceHeldYear;

    @FindBy(how = How.CSS , using = "select[id='licenceHeldMonthList']")
    public WebElement licenceHeldMonth;

    @FindBy(how = How.CSS , using = "select[id='ncd']")
    public WebElement ncd;

    @FindBy(how = How.CSS , using = "input[id='coverStartDate.day']")
    public WebElement coverStartDay;

    @FindBy(how = How.CSS , using = "input[id='coverStartDate.month']")
    public WebElement coverStartMonth;

    @FindBy(how = How.CSS , using = "input[id='coverStartDate.year']")
    public WebElement coverStartYear;

    @FindBy(how = How.ID , using = "registrationNumber")
    public WebElement registrationNumber;

    @FindBy(how = How.ID , using = "postCode")
    public WebElement postCode;

    @FindBy(how = How.XPATH , using = "//input[@id='findAddress']")
    public WebElement findAddress;

    @FindBy(how = How.CSS , using = "select[id='addressList']")
    public WebElement addressList;

    @FindBy(how = How.CSS , using = "input[id='coverDeclarations_0']")
    public WebElement coverDeclarationYes;

    @FindBy(how = How.CSS , using = "input[id='additionalCoverDeclarations_0']")
    public WebElement additionalCoverDeclarationYes;

    @FindBy(how = How.XPATH , using = "//input[@id='next']")
    public WebElement nextPage;

    public void AboutYouPOF(WebDriver driver){
        this.webDriver = driver;
    }
}
