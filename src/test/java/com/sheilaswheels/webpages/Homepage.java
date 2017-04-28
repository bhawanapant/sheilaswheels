package com.sheilaswheels.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by bhawana on 23/04/2017.
 */
public class Homepage {
    WebDriver aDriver;

    @FindBy(how = How.CSS , using = "a[href='https://www.sheilaswheels.com/new/motor']")
    private WebElement motorLink;

    public Homepage(WebDriver driver) {
        this.aDriver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnMotorQuote() {
        new WebDriverWait(aDriver,10).until((ExpectedCondition<Boolean>)
                webDriver -> motorLink.isDisplayed());
                motorLink.click();
    }
}
