package com.sheilaswheels.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.io.IOException;

import static java.lang.Runtime.getRuntime;

/**
 * Created by bhawana on 08/01/2017.
 */
public class Driver extends Thread {

    private static WebDriver webDriver = null;
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
}

