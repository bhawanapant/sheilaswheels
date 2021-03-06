package com.esure.motorinsurance.webpages;

import com.esure.motorinsurance.domain.InsuranceData;
import com.esure.motorinsurance.domain.enumType.*;
import com.esure.motorinsurance.utility.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;

/**
 * Created by bhawana on 27/04/2017.
 */
public class AboutYouPage {
    private final WebDriver aDriver;
    private JavascriptExecutor javascriptExecutor;


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

    @FindBy(how = How.CSS , using = "select[id='occupationEducation']")
    private WebElement occupationEducation;

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

    @FindBy(how = How.XPATH , using = "//input[@id='findAddress']")
    private WebElement findAddress;

    @FindBy(how = How.CSS , using = "select#addressList")
    private WebElement addressList;

    @FindBy(how = How.CSS , using = "input#coverDeclarations_0")
    private WebElement coverDeclarationYes;

    @FindBy(how = How.CSS , using = "input#additionalCoverDeclarations_0")
    private WebElement additionalCoverDeclarationYes;

    @FindBy(how = How.XPATH , using = "//input[@id='next']")
    private WebElement nextPage;

    public AboutYouPage(WebDriver driver) {
        this.aDriver = driver;
        javascriptExecutor = (JavascriptExecutor)aDriver;
        PageFactory.initElements(driver,this);
    }

    public void populateAboutYouDetails(InsuranceData insuranceData) {
        Driver.waitForElementToLoad(aboutYouHeading);

        InsuranceData.AboutYou aboutYou = insuranceData.getAboutYou();

        populateDateOfBirthOfCustomer(aboutYou.getDob());

        setCustomerIsUKResidentYesOrNo(aboutYou.isUkResident());

        selectEmploymentStatus(aboutYou.getEmploymentStatus());

        selectOccupationWithRespetToEmploymentStatus(aboutYou);

        setCustomerGender(aboutYou.getGender());

        setMaritalStatusOfCustomer(aboutYou.getMaritalStatus());

        setNoOfChildrenAtAddress(aboutYou.getChildrenatAddress());

        selectResidentialStatus(aboutYou.getResidentialStatus());

        selectNumberOfCarInHousehold(aboutYou.getCarInHousehold());

        selectUseOfOtherVehicle(aboutYou.getAccessOfVehicle());

        selectLicenceType(aboutYou.getLicenceType());

        selectLicenceHeldTime(aboutYou.getLicenceHeldYear());

        selectNCDYear(aboutYou.getNcdYear());

        setRegistrationNumber(aboutYou.getRegistrationNo());

        setCarCoverStartDate(aboutYou.getCoverStartDate());

        selectAddressOfRegisterVehicle(aboutYou.getPostcode());

        selectCoverDeclarations();

        try {
            moveToNextPage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void selectOccupationWithRespetToEmploymentStatus(InsuranceData.AboutYou aboutYou) {
        if (aboutYou.getEmploymentStatus() == EmploymentStatus.INEDUCATION) {
            selectInEducationOccupation(Occupation.MATURESTUDENT);
            selectIndustry(aboutYou.getIndustry());
            setOtherOCcupationYesOrNo(aboutYou.isSecondOccupation());
        }
        else
        if(aboutYou.getEmploymentStatus() == EmploymentStatus.EMPLOYED || aboutYou.getEmploymentStatus() ==
            EmploymentStatus.SELFEMPLOYED || aboutYou.getEmploymentStatus() == EmploymentStatus.VOLUNTARY)
        {
            selectCustomerOccupation(aboutYou.getOccupation());
            selectIndustry(aboutYou.getIndustry());
            setOtherOCcupationYesOrNo(aboutYou.isSecondOccupation());
        }
    }

    private void selectInEducationOccupation(Occupation value) {
        Driver.waitForElementToLoad(occupationEducation);
        new Select((occupationEducation)).selectByVisibleText(value.getValue());
    }

    private void selectNCDYear(NCDYear ncdYearValue) {
        new Select((ncd)).selectByVisibleText(ncdYearValue.getValue());}

    private void selectLicenceHeldTime(LicenceHeldYear licenceHeldYearValue) {
        int year = getNumberOfYears(licenceHeldYearValue);
        if (year < 5) {
            new Select(licenceHeldYear).selectByVisibleText(licenceHeldYearValue.getValue());
            Driver.waitForElementToLoad(licenceHeldMonth);
            new Select(licenceHeldMonth).selectByIndex(3);
        }
        else {
            new Select(licenceHeldYear).selectByVisibleText(licenceHeldYearValue.getValue());
        }
    }

    private int getNumberOfYears(LicenceHeldYear licenceHeldYearValue) {
        String years = licenceHeldYearValue.getValue();
        String[] value = years.split(" ");
        if (licenceHeldYearValue.getValue().equals("Less than 1 year"))
        {
            return Integer.valueOf(value[2]);
        } else
            if (licenceHeldYearValue.getValue().equals("Over 15 Years"))
            {
            return Integer.valueOf(value[1]);
            }
            else
                {
                return Integer.valueOf(value[0]);
                }
    }

    private void selectLicenceType(LicenceType licenceTypeValue) {
        new Select(licenseType).selectByVisibleText(licenceTypeValue.getValue());}

    private void selectUseOfOtherVehicle(AccessToAnyVehicle accessOfVehicle) {
        new Select(useOtherVehicle).selectByVisibleText(accessOfVehicle.getValue());}

    private void selectNumberOfCarInHousehold(CarInHousehold carInHouseholdValue) {
        new Select(numberOfHouseholdCars).selectByVisibleText(carInHouseholdValue.getValue());}

    private void selectResidentialStatus(ResidentialStatus residentialStatusValue) {
        new Select(residentialStatus).selectByVisibleText(residentialStatusValue.getValue());}

    private void setNoOfChildrenAtAddress(NoOfChildrenAtAddress childrenatAddress) {
        new Select(motorNumberOfChildren).selectByVisibleText(childrenatAddress.getValue());}

    private void setMaritalStatusOfCustomer(MaritalStatus maritalStatusValue) {
        new Select(maritalStatus).selectByVisibleText(maritalStatusValue.getValue());}

    private void selectEmploymentStatus(EmploymentStatus employmentStatusValue) {
        new Select(employmentStatus).selectByVisibleText(employmentStatusValue.getValue());}

    private void setOtherOCcupationYesOrNo(boolean secondOccupation) {
        (secondOccupation ? occupationOtherYes : occupationOtherNo).click();}

    private void setCustomerIsUKResidentYesOrNo(boolean customerIsUKResidentFlag) {
        (customerIsUKResidentFlag ? residentUKYes : residentUKNo).click();}

    private void populateDateOfBirthOfCustomer(LocalDate dob) {
        dayDOB.sendKeys(String.valueOf(dob.getDayOfMonth()));
        monthDOB.sendKeys(String.valueOf(dob.getMonthValue()));
        yearDOB.sendKeys(String.valueOf(dob.getYear()));
    }

    private void setCarCoverStartDate(LocalDate coverStartDate) {
        coverStartDay.sendKeys(String.valueOf(coverStartDate.getDayOfMonth()));
        coverStartMonth.sendKeys(String.valueOf(coverStartDate.getMonthValue()));
        coverStartYear.sendKeys(String.valueOf(coverStartDate.getYear()));
    }

    private void selectIndustry(String industryValue) {industry.sendKeys(industryValue);}

    private void setRegistrationNumber(String registrationNo) {registrationNumber.sendKeys(registrationNo);}


    private void setCustomerGender(Gender gender) {
        if (gender.equals(Gender.MALE)) {genderMale.click();}
        else {genderFemale.click();}
    }

    private void selectCustomerOccupation(String occupationValue) {
        Driver.waitForElementToLoad(occupation);
        occupation.sendKeys(occupationValue);
    }

    private void selectCoverDeclarations() {
        coverDeclarationYes.click();
        additionalCoverDeclarationYes.click();
    }

    //TODO need to find a better workaround
    private void selectAddressOfRegisterVehicle(String postCodeValue) {
        enterCustomerPostCode(postCodeValue);
        try {
            findAddresFromList();
        }catch (TimeoutException e){
            enterCustomerPostCode(postCodeValue);
            findAddresFromList();
            e.printStackTrace();
        }catch (StaleElementReferenceException e){
            enterCustomerPostCode(postCodeValue);
            findAddresFromList();
            e.printStackTrace();
        }
    }

    private void enterCustomerPostCode(String postCodeValue) {
        javascriptExecutor.executeScript("document.getElementById('postCode').value='"+ postCodeValue+"'");
    }

    private void findAddresFromList() {
        findAddress.click();
        Driver.waitForElementToLoad(addressList);
        new Select(addressList).selectByIndex(3);
    }

    private void moveToNextPage() throws InterruptedException {
        nextPage.click();
        Thread.sleep(1000);
    }
}