package com.esure.sheilas.wheels.steps.pageobjects;

import com.esure.sheilas.wheels.domain.YourDetails;
import com.esure.sheilas.wheels.domain.YourDetails.AboutYourCar;
import com.esure.sheilas.wheels.steps.pagefactory.AboutYouPOF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

import static com.esure.sheilas.wheels.domain.enumType.Gender.MALE;

/**
 * Created by bhawana on 27/04/2017.
 */
public class AboutYouPage {

    private final WebDriver aDriver;
    private final AboutYouPOF aboutYouPOF;
    private WebElement UKResidentFlag;
    private Select employmentStatusSelect;
    private WebElement otherOccupation;
    private Select maritalStatus;
    private  Select numberOfChildren;
    private Select residentialStatus;
    private Select carInHousehold;
    private Select userOtherVehicle;
    private Select licenceType;
    private Select ncdYear;
    private Select addressList;
    private Select licenceHeldYear;
    private Select licenceHeldMonth;


    public AboutYouPage(WebDriver driver) {
        this.aDriver = driver;
        aboutYouPOF = PageFactory.initElements(driver, AboutYouPOF.class);
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
        aboutYouPOF.coverDeclarationYes.click();
        aboutYouPOF.additionalCoverDeclarationYes.click();
        aboutYouPOF.nextPage.click();
        Thread.sleep(20);
    }

    private void selectAddressOfRegisterVehicle(YourDetails yourDetails) {
        aboutYouPOF.postCode.sendKeys(yourDetails.getCustomerDetails().getPostcode());
        aboutYouPOF.findAddress.click();

        new WebDriverWait(aDriver, 10).until(
            (ExpectedCondition<Boolean>) webdriver -> aboutYouPOF.addressList.isDisplayed());
        addressList = new Select(aboutYouPOF.addressList);
        addressList.selectByIndex(4);
    }

    private void setCarCoverStartDate(YourDetails yourDetails) {
        LocalDate coverStart = yourDetails.getCustomerDetails().getCoverStartDate();
        aboutYouPOF.coverStartDay.sendKeys(String.valueOf(coverStart.getDayOfMonth()));
        aboutYouPOF.coverStartMonth.sendKeys(String.valueOf(coverStart.getMonthValue()));
        aboutYouPOF.coverStartYear.sendKeys(String.valueOf(coverStart.getYear()));
    }

    private void populateCarInformation(AboutYourCar aboutYourCar) {

        carInHousehold = new Select(aboutYouPOF.numberOfHouseholdCars);
        carInHousehold.selectByVisibleText(aboutYourCar
                        .getCarInHousehold().getValue());

        userOtherVehicle = new Select(aboutYouPOF.useOtherVehicle);
        userOtherVehicle.selectByVisibleText(aboutYourCar
                        .getAccessOfVehicle().getValue());

        licenceType = new Select(aboutYouPOF.licenseType);
        licenceType.selectByVisibleText(aboutYourCar
                        .getLicenceType().getValue());

        licenceHeldYear = new Select(aboutYouPOF.licenceHeldYear);
        licenceHeldYear.selectByVisibleText(aboutYourCar
                        .getLicenceHeldYear().getValue());

        new WebDriverWait(aDriver, 10).until(
            (ExpectedCondition<Boolean>) webdriver -> aboutYouPOF.licenceHeldMonth.isDisplayed());

        licenceHeldMonth = new Select(aboutYouPOF.licenceHeldMonth);
        licenceHeldMonth.selectByVisibleText(aboutYourCar.getLicenceHeldMonth().getValue());

        ncdYear = new Select((aboutYouPOF.ncd));
        ncdYear.selectByVisibleText(aboutYourCar
                        .getNcdYear().getValue());
        aboutYouPOF.registrationNumber.sendKeys(aboutYourCar.getRegistrationNo());

    }

    private void selectResidentialStatus(YourDetails yourDetails) {
        residentialStatus = new Select(aboutYouPOF.residentialStatus);
        residentialStatus.selectByVisibleText(yourDetails.getCustomerDetails()
                         .getResidentialStatus().getValue());
    }

    private void selectMaritalStatusAndNoOfChildrenAtAddress(YourDetails yourDetails) {
        maritalStatus = new Select(aboutYouPOF.maritalStatus);
        maritalStatus.selectByVisibleText(yourDetails.getCustomerDetails()
                     .getMaritalStatus().getValue());

        numberOfChildren = new Select(aboutYouPOF.motorNumberOfChildren);
        numberOfChildren.selectByVisibleText(yourDetails
                        .getCustomerDetails().getChildrenatAddress().getValue());
    }


    private void selectCustomerGender(YourDetails yourDetails) {
        if (yourDetails.getCustomerDetails().getGender().equals(MALE)) {
            aboutYouPOF.genderMale.click();
        }
        else {
            aboutYouPOF.genderFemale.click();
        }
    }

    private void selectCustomerIsResidentOfUK(YourDetails yourDetails) {
        UKResidentFlag =  yourDetails.getCustomerDetails().isUkResident()
                ? aboutYouPOF.residentUKYes : aboutYouPOF.residentUKNo;
        UKResidentFlag.click();
    }

    private void populateCustomerEmploymentInformation(YourDetails yourDetails) {
        employmentStatusSelect = new Select(aboutYouPOF.employmentStatus);
        employmentStatusSelect.selectByVisibleText(yourDetails.getCustomerDetails()
                              .getEmploymentStatus().getValue());

        new WebDriverWait(aDriver,10).until(
            (ExpectedCondition<Boolean>) webdriver -> aboutYouPOF.occupation.isDisplayed());
        aboutYouPOF.occupation.sendKeys(yourDetails.getCustomerDetails().getOccupation());


        aboutYouPOF.industry.sendKeys(yourDetails.getCustomerDetails().getIndustry());

        otherOccupation = yourDetails.getCustomerDetails().isSecondOccupation()
            ? aboutYouPOF.occupationOtherYes : aboutYouPOF.occupationOtherNo;
        otherOccupation.click();
    }

    private void populateDateOfBirthOfCustomer(YourDetails yourDetails) {
        LocalDate DOB = yourDetails.getCustomerDetails().getDob();
        aboutYouPOF.dayDOB.sendKeys(String.valueOf(DOB.getDayOfMonth()));
        aboutYouPOF.monthDOB.sendKeys(String.valueOf(DOB.getMonthValue()));
        aboutYouPOF.yearDOB.sendKeys(String.valueOf(DOB.getYear()));
    }

    private void waitForAboutYouPageToLoad() {
        new WebDriverWait(aDriver, 10).until(
            (ExpectedCondition<Boolean>) webdriver -> aboutYouPOF.aboutYouHeading.isDisplayed());
    }
}

