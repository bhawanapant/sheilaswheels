package com.esure.motorinsurance.webpages;

import com.esure.motorinsurance.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by bhawana on 23/04/2017.
 */
public class Homepage {
    WebDriver aDriver;

    @FindBy(how = How.CSS , using = "a[href='https://www.esure.com/new/motor']" )
    private WebElement esureMotorLink;

    @FindBy(how = How.CSS , using = "a[href='https://www.sheilaswheels.com/new/motor']" )
    private WebElement sheilasMotorLink;

    @FindBy(how = How.CSS , using = "a[href='https://www.firstalternative.com/new/motor']" )
    private WebElement firstAlternativeLink;

    public Homepage(WebDriver driver) {
        this.aDriver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnMotorQuote(String url) {
        if (url.contains("esure")){
            Driver.waitForElementToLoad(esureMotorLink);
            esureMotorLink.click();
        } else
            if (url.contains("sheilaswheels")) {
                Driver.waitForElementToLoad(sheilasMotorLink);
                sheilasMotorLink.click();
            } else
                if (url.contains("firstalternative")){
                    Driver.waitForElementToLoad(firstAlternativeLink);
                    firstAlternativeLink.click();
                }
    }

}
