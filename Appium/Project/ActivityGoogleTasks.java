package Project;

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

public class ActivityGoogleTasks {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.google.android.apps.tasks");
        caps.setAppActivity(".ui.TaskListsActivity");
        caps.noReset();

        //Appium Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Initialize Android Driver
        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void googleTasks() throws InterruptedException {
        for (int i = 0; i <= 2; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Create new task")));
            WebElement addTask = driver.findElement(AppiumBy.accessibilityId("Create new task"));
            addTask.click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
            WebElement task = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
            if (i == 0) task.sendKeys("Complete Activity with Google Tasks");
            else if (i == 1) task.sendKeys("Complete Activity with Google Keep");
            else task.sendKeys("Complete the second Activity Google Keep");
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")));
            WebElement doneBtn = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"));
            doneBtn.click();
        }
        Thread.sleep(2000);
        int numOfTasks = driver.findElements(AppiumBy.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.google.android.apps.tasks:id/tasks_list']/android.widget.FrameLayout")).size();
        Assert.assertEquals(numOfTasks, 3);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
