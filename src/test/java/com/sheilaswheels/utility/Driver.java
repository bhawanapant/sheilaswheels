package com.sheilaswheels.utility;

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
public class Driver extends Thread {

    private static WebDriver webDriver = null;
    private static WebDriverWait wait;

    public enum BrowserName {FIREFOX, GOOGLECHROME}
    private static BrowserName browser = BrowserName.FIREFOX;

    public static WebDriver getBrowser() throws IOException {
        if(webDriver == null){
            switch (browser){
                case FIREFOX:
                    String geckoDriverLocation = Driver.class.getResource("/tools/geckodriver").getPath();
                    System.setProperty("webdriver.gecko.driver", geckoDriverLocation);
                    ProfilesIni profile = new ProfilesIni();
                    FirefoxProfile firebugProfile = profile.getProfile("selenium");
                    webDriver = new FirefoxDriver(firebugProfile);
                    break;

                case GOOGLECHROME:
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

    public static void waitForPageElementToLoad(WebElement checkingElement) {
        wait = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.visibilityOf(checkingElement));}
//
//    public static void waitAndClickOnTheElementUntilSucced(WebElement checkingElement){
//        boolean flag = new FluentWait<WebElement>(checkingElement).
//                           withTimeout(10, TimeUnit.SECONDS).
//                           pollingEvery(100,TimeUnit.MILLISECONDS).
//                           ignoring(StaleElementReferenceException.class).
//                           until(new Function<WebElement, Boolean>(){
//                             @Override
//                             public Boolean apply(WebElement checkingElement) {
//                                 try {
//                                     webDriver.navigate().refresh();
//                                     return checkingElement.isDisplayed();
//                                 }catch(Exception e){
//                                     try {
//                                         LogFile.getTheErrorMessageInDetail(e.getMessage());
//                                     } catch (JsonProcessingException e1) {
//                                         e1.printStackTrace();
//                                     }
//                                     return false;
//                                 }
//                             }
//                           });
}



