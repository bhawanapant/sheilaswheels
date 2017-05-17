package com.sheilaswheels.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by bhawana on 16/05/2017.
 */
public class QuoteDetailPage {
    WebDriver driver;

    @FindBy(how = How.CSS , using = "div.section-titles>h1")
    private WebElement quoteDetailsHeading;

    public QuoteDetailPage(WebDriver driver) {
        this.driver = driver;
    }
}
