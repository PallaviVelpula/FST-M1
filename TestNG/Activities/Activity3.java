package TestNGActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test
    public void activity3() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.name("Password")).sendKeys("password");
        driver.findElement(By.xpath("//button[(@type='submit' and text()='Log in')]")).click();
        String actualMsg = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(actualMsg, "Welcome Back, admin");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
