package com.esure.motorinsurance.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static java.lang.Runtime.getRuntime;

/**
 * Created by bhawana on 08/01/2017.
 */
public class Driver {

    private static WebDriver webDriver = null;
    private static WebDriverWait wait;

    public static WebDriver getBrowser(String browser) throws IOException {
        if (webDriver == null) {
            switch (browser) {
                case "firefox":
                    String geckoDriverLocation = Driver.class.getResource("/tools/geckodriver").getPath();
                    System.setProperty("webdriver.gecko.driver", geckoDriverLocation);
                    ProfilesIni profile = new ProfilesIni();
                    FirefoxProfile firebugProfile = profile.getProfile("selenium");
                    webDriver = new FirefoxDriver(firebugProfile);
                    break;

                case "chrome":
                    String chromeDriverLocation = Driver.class.getResource("/tools/chromedriver").getPath();
                    System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
                    webDriver = new ChromeDriver();
                    break;
            }
             quitBrowserOnceTestIsComplete();
        }
        return webDriver;
    }


    private static void quitBrowserOnceTestIsComplete() {
        getRuntime().addShutdownHook(new Thread(() -> webDriver.quit()));
    }

    public static void open(String aURL) {
        webDriver.navigate().to(aURL);
    }


    public static void waitForElementToLoad(WebElement checkingElement) {
        wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.visibilityOf(checkingElement));
    }

    public static void waitForInsuranceToBeRecalculated(WebElement processingWindow) {
        wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.invisibilityOf(processingWindow));

    }
}



