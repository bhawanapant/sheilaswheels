package com.sheilaswheels.webpages;

import com.sheilaswheels.domain.YourDetails;
import com.sheilaswheels.domain.YourDetails.AboutYourCar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

import static com.sheilaswheels.domain.enumType.Gender.MALE;

/**
 * Created by bhawana on 27/04/2017.
 */
public class AboutYouPage {
    private final WebDriver aDriver;
    private Select employmentStatusSelect;
    private WebElement otherOccupation;
    private  Select numberOfChildren;
    private Select carInHousehold;
    private Select userOtherVehicle;
    private Select licenceType;
    private Select ncdYear;
    private Select address;
    private Select selectLicenceHeldYear;
    private Select selectLicenceHeldMonth;
    private Select selectResidentialStatus;
    private Select selectMaritalStatus;


    @FindBy(how = How.XPATH , using = "//h1[contains(text(),'About you')]")
    private WebElement aboutYouHeading;

    @FindBy(how = How.CSS , using = "input[id='input-dob.day']")
    private WebElement dayDOB;

    @FindBy(how = How.CSS , using = "input[id='input-dob.month']")
    private WebElement monthDOB;

    @FindBy(how = How.CSS , using = "input[id='input-dob.year']")
    private WebElement yearDOB;

    @FindBy(how = How.ID , using = "ukResident_0")
    private WebElement residentUKYes;

    @FindBy(how = How.ID , using = "ukResident_1")
    private WebElement residentUKNo;

    @FindBy(how = How.CSS , using = "select[id='employmentStatus']")
    private WebElement employmentStatus;

    @FindBy(how = How.CSS , using = "input[id='occupationOther']")
    private WebElement occupation;

    @FindBy(how = How.CSS , using = "input[id='secondaryOccupationFlag_0']")
    private WebElement occupationOtherYes;

    @FindBy(how = How.CSS , using = "input[id='secondaryOccupationFlag_1']")
    private WebElement occupationOtherNo;

    @FindBy(how = How.CSS , using = "input[id='industry']")
    private WebElement industry;

    @FindBy(how = How.ID , using = "gender_0")
    private WebElement genderMale;

    @FindBy(how = How.ID , using = "gender_1")
    private WebElement genderFemale;

    @FindBy(how = How.CSS , using = "select[id='maritalStatus']")
    private WebElement maritalStatus;

    @FindBy(how = How.CSS , using = "select[id='motorNumberOfChildren']")
    private WebElement motorNumberOfChildren;

    @FindBy(how = How.CSS , using = "select[id='residentialStatus']")
    private WebElement residentialStatus;

    @FindBy(how = How.CSS , using = "select[id='renewalMonthContents']")
    private WebElement renewalMonthContents;

    @FindBy(how = How.CSS , using = "select[id='renewalMonthBuildings']")
    private WebElement renewalMonthBuildings;

    @FindBy(how = How.CSS , using = "select[id='numberOfHouseholdCars']")
    private WebElement numberOfHouseholdCars;

    @FindBy(how = How.CSS , using = "select[id='useOtherCars']")
    private WebElement useOtherVehicle;

    @FindBy(how = How.CSS , using = "select[id='licenseType']")
    private WebElement licenseType;

    @FindBy(how = How.CSS , using = "select[id='licenceHeldYearList']")
    private WebElement licenceHeldYear;

    @FindBy(how = How.CSS , using = "select[id='licenceHeldMonthList']")
    private WebElement licenceHeldMonth;

    @FindBy(how = How.CSS , using = "select[id='ncd']")
    private WebElement ncd;

    @FindBy(how = How.CSS , using = "input[id='coverStartDate.day']")
    private WebElement coverStartDay;

    @FindBy(how = How.CSS , using = "input[id='coverStartDate.month']")
    private WebElement coverStartMonth;

    @FindBy(how = How.CSS , using = "input[id='coverStartDate.year']")
    private WebElement coverStartYear;

    @FindBy(how = How.ID , using = "registrationNumber")
    private WebElement registrationNumber;

    @FindBy(how = How.ID , using = "postCode")
    private WebElement postCode;

    @FindBy(how = How.XPATH , using = "//input[@id='findAddress']")
    private WebElement findAddress;

    @FindBy(how = How.CSS , using = "select[id='addressList']")
    private WebElement addressList;

    @FindBy(how = How.CSS , using = "input[id='coverDeclarations_0']")
    private WebElement coverDeclarationYes;

    @FindBy(how = How.CSS , using = "input[id='additionalCoverDeclarations_0']")
    private WebElement additionalCoverDeclarationYes;

    @FindBy(how = How.XPATH , using = "//input[@id='next']")
    private WebElement nextPage;

    public AboutYouPage(WebDriver driver) {
        this.aDriver = driver;
        PageFactory.initElements(driver,this);
    }

    public void populateAboutYouDetails(YourDetails yourDetails) {
        AboutYourCar aboutYourCar = yourDetails.getAboutYourCar();

        waitForAboutYouPageToLoad();

        populateDateOfBirthOfCustomer(yourDetails);

        selectCustomerIsResidentOfUK(yourDetails);

        populateCustomerEmploymentInformation(yourDetails);

        selectCustomerGender(yourDetails);

        selectMaritalStatusAndNoOfChildrenAtAddress(yourDetails);

        selectResidentialStatus(yourDetails);

        populateCarInformation(aboutYourCar);

        setCarCoverStartDate(yourDetails);

        selectAddressOfRegisterVehicle(yourDetails);

        try {
            selectDeclarationsAndClickOnNextPage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void selectDeclarationsAndClickOnNextPage() throws InterruptedException {
        coverDeclarationYes.click();
        additionalCoverDeclarationYes.click();
        nextPage.click();
        Thread.sleep(20);
    }

    private void selectAddressOfRegisterVehicle(YourDetails yourDetails) {
        postCode.sendKeys(yourDetails.getCustomerDetails().getPostcode());
        findAddress.click();

        new WebDriverWait(aDriver, 10).until(
            (ExpectedCondition<Boolean>) webdriver -> addressList.isDisplayed());
        address = new Select(addressList);
        address.selectByIndex(4);
    }

    private void setCarCoverStartDate(YourDetails yourDetails) {
        LocalDate coverStart = yourDetails.getCustomerDetails().getCoverStartDate();
        coverStartDay.sendKeys(String.valueOf(coverStart.getDayOfMonth()));
        coverStartMonth.sendKeys(String.valueOf(coverStart.getMonthValue()));
        coverStartYear.sendKeys(String.valueOf(coverStart.getYear()));
    }

    private void populateCarInformation(AboutYourCar aboutYourCar) {

        carInHousehold = new Select(numberOfHouseholdCars);
        carInHousehold.selectByVisibleText(aboutYourCar
                        .getCarInHousehold().getValue());

        userOtherVehicle = new Select(useOtherVehicle);
        userOtherVehicle.selectByVisibleText(aboutYourCar
                        .getAccessOfVehicle().getValue());

        licenceType = new Select(licenseType);
        licenceType.selectByVisibleText(aboutYourCar
                        .getLicenceType().getValue());

        selectLicenceHeldYear = new Select(licenceHeldYear);
        selectLicenceHeldYear.selectByVisibleText(aboutYourCar
                        .getLicenceHeldYear().getValue());

        new WebDriverWait(aDriver, 10).until(
            (ExpectedCondition<Boolean>) webdriver -> licenceHeldMonth.isDisplayed());

        selectLicenceHeldMonth = new Select(licenceHeldMonth);
        selectLicenceHeldMonth.selectByVisibleText(aboutYourCar.getLicenceHeldMonth().getValue());

        ncdYear = new Select((ncd));
        ncdYear.selectByVisibleText(aboutYourCar
                        .getNcdYear().getValue());
        registrationNumber.sendKeys(aboutYourCar.getRegistrationNo());


    }

    private void selectResidentialStatus(YourDetails yourDetails) {
        selectResidentialStatus = new Select(residentialStatus);
        selectResidentialStatus.selectByVisibleText(yourDetails.getCustomerDetails()
                         .getResidentialStatus().getValue());
    }

    private void selectMaritalStatusAndNoOfChildrenAtAddress(YourDetails yourDetails) {
        selectMaritalStatus = new Select(maritalStatus);
        selectMaritalStatus.selectByVisibleText(yourDetails.getCustomerDetails()
                     .getMaritalStatus().getValue());

        numberOfChildren = new Select(motorNumberOfChildren);
        numberOfChildren.selectByVisibleText(yourDetails
                        .getCustomerDetails().getChildrenatAddress().getValue());
    }


    private void selectCustomerGender(YourDetails yourDetails) {
        if (yourDetails.getCustomerDetails().getGender().equals(MALE)) {
            genderMale.click();
        }
        else {
            genderFemale.click();
        }
    }

    private void selectCustomerIsResidentOfUK(YourDetails yourDetails) {
        WebElement UKResidentFlag =  yourDetails.getCustomerDetails().isUkResident()
                ? residentUKYes : residentUKNo;
        UKResidentFlag.click();
    }

    private void populateCustomerEmploymentInformation(YourDetails yourDetails) {
        employmentStatusSelect = new Select(employmentStatus);
        employmentStatusSelect.selectByVisibleText(yourDetails.getCustomerDetails()
                              .getEmploymentStatus().getValue());

        new WebDriverWait(aDriver,10).until(
            (ExpectedCondition<Boolean>) webdriver -> occupation.isDisplayed());
        occupation.sendKeys(yourDetails.getCustomerDetails().getOccupation());


        industry.sendKeys(yourDetails.getCustomerDetails().getIndustry());

        otherOccupation = yourDetails.getCustomerDetails().isSecondOccupation()
            ? occupationOtherYes : occupationOtherNo;
        otherOccupation.click();
    }

    private void populateDateOfBirthOfCustomer(YourDetails yourDetails) {
        LocalDate DOB = yourDetails.getCustomerDetails().getDob();
        dayDOB.sendKeys(String.valueOf(DOB.getDayOfMonth()));
        monthDOB.sendKeys(String.valueOf(DOB.getMonthValue()));
        yearDOB.sendKeys(String.valueOf(DOB.getYear()));
    }

    private void waitForAboutYouPageToLoad() {
        new WebDriverWait(aDriver, 10).until(
            (ExpectedCondition<Boolean>) webdriver -> aboutYouHeading.isDisplayed());
    }

}