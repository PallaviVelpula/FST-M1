package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity6 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.android.chrome");
        caps.setAppActivity("com.google.android.apps.chrome.Main");
        caps.noReset();

        //Appium Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Initialize Android Driver
        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://www.training-support.net/selenium/lazy-loading");
    }

    @Test
    public void googleChromeTest() {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text='Lazy Loading']")));
        List<WebElement> images = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("Number of images in the view are: " + images.size());
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"helen\")"));
        System.out.println("Number of images after scrolling are: " + driver.findElements(AppiumBy.className("android.widget.Image")).size());

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
