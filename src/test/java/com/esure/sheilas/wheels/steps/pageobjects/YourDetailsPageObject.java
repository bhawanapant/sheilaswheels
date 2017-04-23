package com.esure.sheilas.wheels.steps.pageobjects;

import com.esure.sheilas.wheels.domain.CustomerDetails;
import com.esure.sheilas.wheels.domain.enumType.Title;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by bhawana on 23/04/2017.
 */
public class YourDetailsPageObject {

    private final WebDriver aDriver;
    private WebElement selectTitle;
    private WebElement firstName;

    public YourDetailsPageObject(WebDriver driver) {
        this.aDriver = driver;
    }

    public void enterDeatilsOnYourDetailsPageWithDifferentTitle(String title) {
        //Select Title
        selectTitle = aDriver.findElement(By.cssSelector("select[id='title']"));
        Select titleSelect = new Select(selectTitle);
        titleSelect.selectByValue(title);

        CustomerDetails.CustomerDetailsBuilder customerDetailsBuilder = new CustomerDetails.CustomerDetailsBuilder();
        customerDetailsBuilder.title(Enum.valueOf(Title.class,title);
        CustomerDetails customerDetails = customerDetailsBuilder.build();

        //Enter Firstname
        firstName = aDriver.findElement(By.id("firstName"));
        firstName.sendKeys();

    }
}
