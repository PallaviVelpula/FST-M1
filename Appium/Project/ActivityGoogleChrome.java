package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
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

public class ActivityGoogleChrome {
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

        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void webAppTest() throws InterruptedException {
        Dimension dims = driver.manage().window().getSize();
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingToEnd(2)"));
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.view.View[@text = 'To-Do List \uF0AE Elements get added at run time ']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")));
        WebElement taskInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));
        WebElement addTask = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));
        for (int i = 0; i <= 2; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(taskInput));
            Thread.sleep(1000);
            if (i == 0)
                taskInput.sendKeys("Add tasks to list");
            else if (i == 1)
                taskInput.sendKeys("Get number of tasks");
            else
                taskInput.sendKeys("Clear the list");
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")));
            addTask.click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View")));
        Thread.sleep(1000);
        int tasks = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View")).size();
        Assert.assertEquals(tasks, 4);
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@text='Add tasks to list']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@text='Get number of tasks']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@text='Clear the list']"))).click();
        driver.findElement(AppiumBy.xpath("//android.view.View[@text=' Clear List']")).click();
        tasks = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View")).size();
        Assert.assertEquals(tasks, 0);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
