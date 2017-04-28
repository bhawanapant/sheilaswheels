package com.esure.sheilas.wheels.utility;

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
    private static WebDriver adriver = null;
    public enum BrowserName {FIREFOX, GOOGLECHROME}
    private static BrowserName browser = BrowserName.FIREFOX;

    public static WebDriver getBrowser() throws IOException {
        final String currentDir = System.getProperty("user.dir");
        if(adriver == null){
            switch (browser){
                case FIREFOX:
                    String geckoDriverLocation = currentDir + "/tools/geckodriver";
                    System.setProperty("webdriver.gecko.driver", geckoDriverLocation);
                    ProfilesIni profile = new ProfilesIni();
                    FirefoxProfile firebugProfile = profile.getProfile("selenium");
                    adriver = new FirefoxDriver(firebugProfile);
                    break;

                case GOOGLECHROME:
                    String chromeDriverLocation = currentDir + "/tools/chromedriver";
                    System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
                    adriver = new ChromeDriver();
                    break;
            }

            quitBrowserOnceTestIsComplete();
        }
        return adriver;
    }

    private static void quitBrowserOnceTestIsComplete() {
        getRuntime().addShutdownHook(new Thread(() -> adriver.quit()));
    }

    public static void open(String aURL) {
        adriver.navigate().to(aURL);
    }
}

