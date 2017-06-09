package com.esure.motorinsurance.webpages;

import com.esure.motorinsurance.domain.InsuranceData;
import com.esure.motorinsurance.domain.enumType.*;
import com.esure.motorinsurance.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;

/**
 * Created by bhawana on 08/05/2017.
 */
public class YourCarPage {
    private final WebDriver aDriver;

    @FindBy(how = How.XPATH , using = "//h1[contains(text(),'Your car')]")
    private WebElement yourCarHeading;

    @FindBy(how = How.CSS , using = "ul#your-car li")
    private WebElement yourCarModel;

    @FindBy(how = How.CSS , using = "select#legalOwner")
    private WebElement legalOwner;

    @FindBy(how = How.CSS , using = "select#registeredKeeper")
    private WebElement registerKeeper;

    @FindBy(how = How.CSS , using = "select#carUsage")
    private WebElement carUsage;

    @FindBy(how = How.CSS , using = "select#securityDevice")
    private WebElement securityDevice;

    @FindBy(how = How.CSS , using = "input#carValueRaw")
    private WebElement motorPrice;

    @FindBy(how = How.CSS , using = "input#trackerFitted_0")
    private WebElement trackeFittedYes;

    @FindBy(how = How.CSS , using = "input#trackerFitted_1")
    private WebElement trackeFittedNo;

    @FindBy(how = How.CSS , using = "select#annualMileage")
    private WebElement annualMilage;

    @FindBy(how = How.CSS , using = "input#differentPostcode_0")
    private WebElement differentPostCodeYes;

    @FindBy(how = How.CSS , using = "input#differentPostcode_1")
    private WebElement differentPostCodeNo;

    @FindBy(how = How.CSS , using = "select#overnightLocation")
    private WebElement overnightLocation;

    @FindBy(how = How.XPATH , using = "//input[@id='carPurchaseDate.day']")
    private WebElement carPurchaseDay;

    @FindBy(how = How.XPATH , using = "//input[@id='carPurchaseDate.month']")
    private WebElement carPurchaseMonth;

    @FindBy(how = How.XPATH , using = "//input[@id='carPurchaseDate.year']")
    private WebElement carPurchaseYear;

    @FindBy(how = How.XPATH , using = "//input[@id='registrationDate.day']")
    private WebElement carRegistrationDay;

    @FindBy(how = How.XPATH , using = "//input[@id='registrationDate.month']")
    private WebElement carRegistrationMonth;

    @FindBy(how = How.XPATH , using = "//input[@id='registrationDate.year']")
    private WebElement carRegistrationYear;

    @FindBy(how = How.CSS , using = "select#coverRequired")
    private WebElement coverRequired;

    @FindBy(how = How.CSS , using = "input#hasMods_0")
    private WebElement hasModifiedYes;

    @FindBy(how = How.CSS , using = "input#hasMods_1")
    private WebElement hasModifiedNo;

    @FindBy(how = How.CSS , using = "input#next")
    private WebElement next;

    public YourCarPage(WebDriver aDriver) {
        this.aDriver = aDriver;
        PageFactory.initElements(aDriver,this);
    }

    public void populateYourCarDetails(InsuranceData insuranceData) {
        InsuranceData.YourCar yourCar = insuranceData.getYourCar();
        Driver.waitForElementToLoad(yourCarHeading);

//        String carDetail[] = getYourCarModelDetails();
//
//        setYourCarDetailValues(yourCar, carDetail);

        populateLegalOwnerOfCar(yourCar.getLegalOwnerOfCar());

        populateRegisteredKeeperOfCar(yourCar.getRegisterKeeperOfCar());

        populateUsageOfCar(yourCar.getUseOfCar());

        populateSecurityDeviceInformation(yourCar.getSecurityDevice());

        populateEstimatedValueOfCar(yourCar.getEstimateValue());

        setTrackingDeviceYesOrNo(yourCar.isTrackingDeviceFitted());

        populateTheAnnualMileage(yourCar.getMileage());

        setCarKeptDiffPostcodeOvernightYesOrNo(yourCar.isCarKeptDiffPostCode());

        populateCarOvernightLocation(yourCar.getCarKeptOvernight());

        populateCarPurchaseDate(yourCar.getCarPurchaseDate());

        populateCarRegistrationDate(yourCar.getCarRegistrationDate());

        populateCarCoverLevel(yourCar.getCoverLevel());

        setYourCarHasBeenModifiedYesOrNo(yourCar.isCarModified());

        moveToNextPage();

    }
//
//    private void setYourCarDetailValues(InsuranceData.YourCar yourCar, String[] carDetail) {
//        yourCar.setCarMaker(carDetail[1]);
//        yourCar.setCarModel(carDetail[2]+ " " +carDetail[3]+ " " +carDetail[4]);
//    }
//
//    private String[] getYourCarModelDetails() {
//        String carDetails = yourCarModel.getText();
//        String car[] = carDetails.split(",");
//       // String carMaker = carDetails.substring(9,carDetails.length());
//        return car;
//    }

    private void moveToNextPage() {
        next.click();
    }

    private void setYourCarHasBeenModifiedYesOrNo(boolean value) {
        (value?hasModifiedYes:hasModifiedNo).click();
    }

    private void populateCarCoverLevel(CoverLevel coverLevel) {
        new Select(coverRequired).selectByVisibleText(coverLevel.getValue());
    }

    private void populateCarOvernightLocation(CarKeptOvernight carKeptOvernight) {
        new Select(overnightLocation).selectByVisibleText(carKeptOvernight.getValue());
    }

    private void setCarKeptDiffPostcodeOvernightYesOrNo(boolean value) {
        (value?differentPostCodeYes:differentPostCodeNo).click();
    }

    private void populateTheAnnualMileage(Mileage mileage) {
        new Select(annualMilage).selectByVisibleText(mileage.getValue());
    }

    private void setTrackingDeviceYesOrNo(boolean value) {
        (value?trackeFittedYes:trackeFittedNo).click();
    }

    private void populateEstimatedValueOfCar(int value) {
        motorPrice.sendKeys(String.valueOf(value));
    }

    private void populateSecurityDeviceInformation(SecurityDevice securityDeviceFitted) {
        new Select(securityDevice).selectByVisibleText(securityDeviceFitted.getValue());
    }

    private void populateUsageOfCar(UseOfCar useOfCar) {
        new Select(carUsage).selectByVisibleText(useOfCar.getValue());
    }

    private void populateRegisteredKeeperOfCar(RegisterKeeperOfCar registerKeeperOfCar) {
        new Select(registerKeeper).selectByVisibleText(registerKeeperOfCar.getValue());
    }

    private void populateLegalOwnerOfCar(LegalOwnerOfCar legalOwnerOfCar) {
        new Select(legalOwner).selectByVisibleText(legalOwnerOfCar.getValue());
    }

    private void populateCarRegistrationDate(LocalDate carRegistrationDate) {
        carRegistrationDay.sendKeys(String.valueOf(carRegistrationDate.getDayOfMonth()));
        carRegistrationMonth.sendKeys(String.valueOf(carRegistrationDate.getMonthValue()));
        carRegistrationYear.sendKeys(String.valueOf(carRegistrationDate.getYear()));
    }

    private void populateCarPurchaseDate(LocalDate carPurchaseDate) {
        carPurchaseDay.sendKeys(String.valueOf(carPurchaseDate.getDayOfMonth()));
        carPurchaseMonth.sendKeys(String.valueOf(carPurchaseDate.getMonthValue()));
        carPurchaseYear.sendKeys(String.valueOf(carPurchaseDate.getYear()));
    }
}
