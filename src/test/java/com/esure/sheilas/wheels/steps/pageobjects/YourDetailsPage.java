package com.esure.sheilas.wheels.steps.pageobjects;

import com.esure.sheilas.wheels.domain.YourDetails;
import com.esure.sheilas.wheels.domain.YourDetails.AdditionalPartner;
import com.esure.sheilas.wheels.domain.YourDetails.CustomerDetails;
import com.esure.sheilas.wheels.domain.YourDetails.MotorClaims;
import com.esure.sheilas.wheels.steps.pagefactory.YourDetailsPOF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by bhawana on 23/04/2017.
 */
public class YourDetailsPage {

    private final WebDriver aDriver;
    private YourDetailsPOF yourDetailsPOF;
    private Select titleSelect;
    private Select sourceCode;
    private WebElement motorClaimForAccidentOrLosses;
    private WebElement motorConvictionOrPenalty;
    private WebElement addtionalDriverFlag;

    public YourDetailsPage(WebDriver driver) {
        this.aDriver = driver;
        yourDetailsPOF = PageFactory.initElements(driver,YourDetailsPOF.class);
    }

    public void yourDetailsWithTitle(YourDetails yourDetails) throws InterruptedException {
        waitForYourDetailsPageToLoad();
        populateYourDetailsPage(yourDetails);
    }

    private void waitForYourDetailsPageToLoad() {
        new WebDriverWait(aDriver, 30).until(
            (ExpectedCondition<Boolean>) webdriver -> yourDetailsPOF.yourDetailHeading.isDisplayed());
    }

    private void populateYourDetailsPage(YourDetails yourDetails) throws InterruptedException {
        CustomerDetails customerDetails = yourDetails.getCustomerDetails();

        MotorClaims motorClaims = yourDetails.getMotorClaims();

        AdditionalPartner additionalPartner = yourDetails.getAdditionalPartners();


        populateCustomerDetails(customerDetails);

        populateMotorClaims(motorClaims);

        populateAdditionalPartner(additionalPartner);

        populateVisitReason();

        moveToNextPage();
    }

    private void moveToNextPage() {
        yourDetailsPOF.nextPage.click();
    }

    private void populateVisitReason() {
        sourceCode = new Select(yourDetailsPOF.sourceOfYourVisit);
        sourceCode.selectByIndex(3);
    }

    private void populateAdditionalPartner(AdditionalPartner additionalPartner) {
        addtionalDriverFlag = additionalPartner.isAddPartner()
                        ? yourDetailsPOF.additionalDriverYes : yourDetailsPOF.additionalDriverNo;
        addtionalDriverFlag.click();
        if (additionalPartner.isAddPartner()) {
            //populate the partner details
        }
    }

    private void populateMotorClaims(MotorClaims motorClaims) {
        motorClaimForAccidentOrLosses = motorClaims.isMotorClaims()
                        ? yourDetailsPOF.moterClaimYes : yourDetailsPOF.moterClaimNo;
        motorClaimForAccidentOrLosses.click();

        motorConvictionOrPenalty = motorClaims.isMotorConviction()
                        ? yourDetailsPOF.motorConvictionYes : yourDetailsPOF.motorConvictionNo;
        motorConvictionOrPenalty.click();
    }

    private void populateCustomerDetails(CustomerDetails customerDetails) {
        titleSelect = new Select(yourDetailsPOF.customerTitle);
        titleSelect.selectByVisibleText(customerDetails.getTitle().getValue());

        yourDetailsPOF.firstName.sendKeys(customerDetails.getFirstName());
        yourDetailsPOF.lastName.sendKeys(customerDetails.getLastName());
        yourDetailsPOF.email.sendKeys(customerDetails.getEmailAddress());
        yourDetailsPOF.confirmEmail.sendKeys(customerDetails.getEmailAddress());
        yourDetailsPOF.phoneNumber.sendKeys(customerDetails.getPhoneNumber());
        yourDetailsPOF.additionalPhoneNumber.sendKeys(customerDetails.getPhoneNumber());
    }
}
