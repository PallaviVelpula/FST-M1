package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    static WebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.android.calculator2");
        caps.setAppActivity(".Calculator");
        caps.noReset();

        //Appium Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Initialize Android Driver
        driver = new AndroidDriver(serverURL, caps);
    }

    @Test
    public void multiplicationTest() throws IOException, InterruptedException {
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_mul")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_3")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();
        Thread.sleep(2000);
        takeScreenshot(driver);
        Assert.assertEquals(driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText(), "15");
    }

    public static void takeScreenshot(WebDriver driver) throws IOException {
        File tempImg = ((TakesScreenshot) Activity1.driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("src/test/resources/screenshot.jpg");
        FileUtils.copyFile(tempImg, screenshot);
        String imagePath = "../" + screenshot;
        String imageHTML = "<img src=" + imagePath + " />";
        Reporter.log(imageHTML);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
