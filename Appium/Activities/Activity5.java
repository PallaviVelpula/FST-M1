package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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
import java.util.List;

public class Activity5 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.google.android.apps.messaging");
        caps.setAppActivity(".ui.ConversationListActivity");
        caps.noReset();

        //Appium Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Initialize Android Driver
        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }

    @Test
    public void sendSMSTest() {
        driver.findElement(AppiumBy.accessibilityId("Start new conversation")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.messaging:id/recipient_text_view")));
        driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/recipient_text_view")).sendKeys("7093626235");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/compose_message_text")).sendKeys("Hello from Appium");
        driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.messaging:id/message_text']")));
        List<WebElement> sentMsgs = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.messaging:id/message_text']"));
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.google.android.apps.messaging:id/message_text'])[" + sentMsgs.size() + "]")).getText(), "Hello from Appium");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
