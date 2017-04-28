package com.esure.sheilas.wheels.steps.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by bhawana on 27/04/2017.
 */
public class HomePagePOF {
    WebDriver driver;

    @FindBy(how = How.CSS , using = "a[href='https://www.sheilaswheels.com/new/motor']")
    public WebElement motorLink;
}
