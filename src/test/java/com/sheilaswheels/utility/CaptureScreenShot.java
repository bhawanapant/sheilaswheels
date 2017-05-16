package com.sheilaswheels.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by bhawana on 12/05/2017.
 */
public class CaptureScreenShot {
    public  byte[]  getScreenShotOfErrorPage(WebDriver browser) throws IOException {
        final byte[] screenshot = ((TakesScreenshot) browser)
            .getScreenshotAs(OutputType.BYTES);
        return screenshot;
//        TakesScreenshot snapper = (TakesScreenshot) browser;
//        byte[] tempImageFileAsBytes = snapper.getScreenshotAs(OutputType.BYTES);
//        File testTempDir = createATempDirectoryForScreenshots();
//        String newImageFileName = "imageOutputTypeBytes" +
//            new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +
//            ".png";
//        File testTempImage = new File(testTempDir, newImageFileName);
//        FileOutputStream fileOutputStream = new FileOutputStream(testTempImage);
//        try {
//            fileOutputStream.write(tempImageFileAsBytes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        fileOutputStream.flush();
    }

//    private static File createATempDirectoryForScreenshots() {
//        String s = File.separator;
//        String ourTestTempPathName = System.getProperty("user.dir") +
//            String.format("%ssrc%stest%sresources%stemp%sscreenshots",s,s,s,s,s);
//
//        File testTempDir = new File(ourTestTempPathName);
//        if(testTempDir.exists()){
//            if(!testTempDir.isDirectory()){
//            }
//        }else{
//            testTempDir.mkdirs();
//        }
//        return testTempDir;
//    }
}

