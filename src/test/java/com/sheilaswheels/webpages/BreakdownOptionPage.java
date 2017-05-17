package com.sheilaswheels.webpages;

import com.sheilaswheels.domain.InsuranceData;
import com.sheilaswheels.domain.enumType.BreakDown;
import com.sheilaswheels.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by bhawana on 11/05/2017.
 */
public class BreakdownOptionPage {
    WebDriver aDriver;

    @FindBy(how = How.CSS , using = "span.active")
    private WebElement breakDownHeading;

    @FindBy(how = How.CSS , using = "#label_breakdownCover_0>h2")
    private WebElement roadsideAssistOption;

    @FindBy(how = How.CSS , using = "#label_breakdownCover_1>h2")
    private WebElement roadsideAssistHomeRescueOption;

    @FindBy(how = How.CSS , using = "#label_breakdownCover_2>h2")
    private WebElement RAHRAndRecoveryOption;

    @FindBy(how = How.CSS , using = "#label_breakdownCover_3>h2")
    private WebElement noBreakdownCoverOption;

    @FindBy(how = How.CSS, using = "input#breakdownCover_0")
    private WebElement roadsideAssist;

    @FindBy(how = How.CSS, using = "input#breakdownCover_1")
    private WebElement roadsideAssistHomeRescue;

    @FindBy(how = How.CSS, using = "input#breakdownCover_2")
    private WebElement RAHRAndRecovery;

    @FindBy(how = How.CSS, using = "input#breakdownCover_3")
    private WebElement noBreakdownCover;

    @FindBy(how = How.CSS, using = "input#mobRecalculate")
    private WebElement reCalculate;

    @FindBy(how = How.CSS , using = "div#recalcDialog p")
    private WebElement recalculateDialog;


    @FindBy(how = How.CSS, using = "input#next")
    private WebElement next;

    public BreakdownOptionPage(WebDriver aDriver) {
        this.aDriver = aDriver;
        PageFactory.initElements(aDriver,this);
    }

    public void selectBreakdownOptionsAndRecalculateQuote(InsuranceData insuranceData) {
        InsuranceData.BoostInsuranceCover boostInsuranceCover = insuranceData.getBoostInsuranceCover();
        Driver.waitForPageElementToLoad(breakDownHeading);
        selectBreakdownOptionForYourQuote(boostInsuranceCover.getBreakDown());
        clickOnRecalculate();
        waitForInsuranceToBeRecalculated();
        moveToNextPage();
    }

    private void moveToNextPage() {
        next.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clickOnRecalculate() {
        Driver.waitForPageElementToLoad(reCalculate);
        reCalculate.click();
    }

    private void selectBreakdownOptionForYourQuote(BreakDown breakDown) {
        if(roadsideAssistOption.getText().equals(breakDown.getValue()))
        {
            roadsideAssist.click();
        }
        else
            if (roadsideAssistHomeRescueOption.getText().equals(breakDown.getValue()))
            {
                roadsideAssistHomeRescue.click();
            }
            else
                if (RAHRAndRecoveryOption.getText().equals(breakDown.getValue()))
                {
                    RAHRAndRecovery.click();
                }
                else
                    if (noBreakdownCoverOption.getText().equals(breakDown.getValue()))
                    {
                        noBreakdownCover.click();
                    }
    }
    private void waitForInsuranceToBeRecalculated() {
        new WebDriverWait(aDriver,30).until(ExpectedConditions.invisibilityOf(recalculateDialog));
    }
}
