package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
    static AndroidDriver driver;

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
    public void addTest() throws InterruptedException {
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_add")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
        WebElement equalsBtn = driver.findElement(AppiumBy.id("com.android.calculator2:id/eq"));
        equalsBtn.click();
        Thread.sleep(2000);
        String result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();
        System.out.println("Result of 5 + 9 is: " + result);
        Assert.assertEquals(result, "14");
    }

    @Test
    public void subtractTest() throws InterruptedException {
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_sub")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
        WebElement equalsBtn = driver.findElement(AppiumBy.id("com.android.calculator2:id/eq"));
        equalsBtn.click();
        Thread.sleep(2000);
        String result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();
        System.out.println("Result of 10 - 5 is: " + result);
        Assert.assertEquals(result, "5");
    }

    @Test
    public void multiplicationTest() throws InterruptedException {
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_mul")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_0")).click();
        WebElement equalsBtn = driver.findElement(AppiumBy.id("com.android.calculator2:id/eq"));
        equalsBtn.click();
        Thread.sleep(2000);
        String result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();
        System.out.println("Result of 5 * 100 is: " + result);
        Assert.assertEquals(result, "500");
    }

    @Test
    public void divisionTest() throws InterruptedException {
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_div")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_2")).click();
        WebElement equalsBtn = driver.findElement(AppiumBy.id("com.android.calculator2:id/eq"));
        equalsBtn.click();
        Thread.sleep(2000);
        String result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();
        System.out.println("Result of 50 / 2 is: " + result);
        Assert.assertEquals(result, "25");
    }
}
