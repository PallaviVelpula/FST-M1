package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity4 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.android.contacts");
        caps.setAppActivity(".activities.PeopleActivity");
        caps.noReset();

        //Appium Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Initialize Android Driver
        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }

    @Test
    public void addContactsTest() {
        driver.findElement(AppiumBy.accessibilityId("Create new contact")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@text='First name']")));
        WebElement firstName = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']"));
        firstName.clear();
        firstName.sendKeys("Aaditya");
        WebElement lastName = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']"));
        lastName.clear();
        lastName.sendKeys("Varma");
        WebElement phoneNumber = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']"));
        phoneNumber.clear();
        phoneNumber.sendKeys("999148292");
        driver.findElement(AppiumBy.id("com.android.contacts:id/editor_menu_save_button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.android.contacts:id/large_title")));
        Assert.assertEquals(driver.findElement(AppiumBy.id("com.android.contacts:id/large_title")).getText(), "Aaditya Varma");
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.android.contacts:id/header'])[1]")).getText(), "(999) 148-292");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
