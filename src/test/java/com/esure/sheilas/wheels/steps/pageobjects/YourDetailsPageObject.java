package com.esure.sheilas.wheels.steps.pageobjects;

import com.esure.sheilas.wheels.domain.YourDetails;
import com.esure.sheilas.wheels.domain.YourDetails.AdditionalPartner;
import com.esure.sheilas.wheels.domain.YourDetails.CustomerDetails;
import com.esure.sheilas.wheels.domain.YourDetails.MotorClaims;
import com.esure.sheilas.wheels.domain.enumType.Title;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by bhawana on 23/04/2017.
 */
public class YourDetailsPageObject {

    private final WebDriver aDriver;
    private YourDetails yourDetails;

    public YourDetailsPageObject(WebDriver driver) {
        this.aDriver = driver;
    }

    public void yourDetailsWithTitle(String title) {
        new WebDriverWait(aDriver, 10).until(
            (ExpectedCondition<Boolean>) webdriver -> webdriver.findElement(
                By.xpath("//div[@id='content-area-main']//h1")).isDisplayed());

        yourDetails = YourDetails.builder()
            .customerDetails(CustomerDetails.builder()
                .title(Title.get(title)).build())
            .build();

        populateYourDetailsPage(yourDetails);
    }

    private void populateYourDetailsPage(YourDetails yourDetails) {
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
        aDriver.findElement(By.xpath("//input[@id='next']")).click();
    }

    private void populateVisitReason() {
        Select sourceCode = new Select(aDriver.findElement(By.cssSelector(("select[id='sourceCode']"))));
        sourceCode.selectByIndex(3);
    }

    private void populateAdditionalPartner(AdditionalPartner additionalPartner) {
        String addtionalDriverFlag = additionalPartner.isAddPartner() ?
            "noOfAdditionalDrivers_0" : "noOfAdditionalDrivers_1";
        aDriver.findElement(By.id(addtionalDriverFlag)).click();
        if (additionalPartner.isAddPartner()) {
            //populate the partner details
        }
    }

    private void populateMotorClaims(MotorClaims motorClaims) {
        String motorClaimForAccidentOrLosses = motorClaims.isMotorClaims() ? "claimsFlag_0" : "claimsFlag_1";
        aDriver.findElement(By.id(motorClaimForAccidentOrLosses)).click();

        String motorConvictionOrPenalty = motorClaims.isMotorConviction() ? "convictionsFlag_0" : "convictionsFlag_1";
        aDriver.findElement(By.id(motorConvictionOrPenalty)).click();
    }

    private void populateCustomerDetails(CustomerDetails customerDetails) {
        Select titleSelect = new Select(aDriver.findElement(By.cssSelector("select[id='title']")));
        titleSelect.selectByVisibleText(customerDetails.getTitle().getValue());

        aDriver.findElement(By.id("firstName")).sendKeys(customerDetails.getFirstName());
        aDriver.findElement(By.id("lastName")).sendKeys(customerDetails.getLastName());
        aDriver.findElement(By.id("email")).sendKeys(customerDetails.getEmailAddress());
        aDriver.findElement(By.id("confirmEmail")).sendKeys(customerDetails.getEmailAddress());
        aDriver.findElement(By.id("phoneNight")).sendKeys(customerDetails.getPhoneNumber());
        aDriver.findElement(By.id("phoneDay")).sendKeys(customerDetails.getPhoneNumber());
    }
}
