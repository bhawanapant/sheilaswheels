package com.esure.sheilas.wheels.steps.pageobjects;

import com.esure.sheilas.wheels.steps.pagefactory.HomePagePOF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by bhawana on 23/04/2017.
 */
public class Homepage {
    WebDriver aDriver;
    private HomePagePOF homePagePOF;

    public Homepage(WebDriver driver) {
        this.aDriver = driver;
        homePagePOF = PageFactory.initElements(driver,HomePagePOF.class);
    }

    public void clickOnMotorQuote() {
        new WebDriverWait(aDriver,10).until((ExpectedCondition<Boolean>)
                webDriver -> homePagePOF.motorLink.isDisplayed());
                homePagePOF.motorLink.click();
    }
}
