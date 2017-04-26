package com.esure.sheilas.wheels.steps.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by bhawana on 23/04/2017.
 */
public class HomepageObject {
    WebDriver aDriver;

    public HomepageObject(WebDriver driver) {
        this.aDriver = driver;
    }

    public void clickOnMotorQuote() {
        new WebDriverWait(aDriver,10).until(
                ExpectedConditions.presenceOfElementLocated(By.
                        cssSelector("a[href='https://www.sheilaswheels.com/new/motor']"))).click();
    }
}
