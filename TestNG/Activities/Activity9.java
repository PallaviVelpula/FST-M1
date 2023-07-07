package TestNGActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.switchTo().defaultContent();
    }

    @Test
    public void simpleAlertTestCase() {
        driver.findElement(By.id("simple")).click();
        Alert simpleAlert = driver.switchTo().alert();
        Reporter.log("Simple alert text is: "+simpleAlert.getText());
        Assert.assertEquals("This is a JavaScript Alert!", simpleAlert.getText());
        simpleAlert.accept();
    }

    @Test
    public void confirmAlertTestCase() {
        driver.findElement(By.id("confirm")).click();
        Alert confirmAlert = driver.switchTo().alert();
        Reporter.log("Confirmation alert text is: "+confirmAlert.getText());
        Assert.assertEquals("This is a JavaScript Confirmation!", confirmAlert.getText());
        confirmAlert.dismiss();
    }

    @Test
    public void promptAlertTestCase() {
        driver.findElement(By.id("prompt")).click();
        Alert promptalert = driver.switchTo().alert();
        Reporter.log("Prompt alert text is: "+promptalert.getText());
        promptalert.sendKeys("Hello Pallavi!");
        Assert.assertEquals("This is a JavaScript Prompt!", promptalert.getText());
        promptalert.accept();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
