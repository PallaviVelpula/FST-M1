package TestNGActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
    }

    @Test
    public void activity1() {
        Assert.assertEquals(driver.getTitle(), "Training Support");
        WebElement aboutUs = driver.findElement(By.id("about-link"));
        aboutUs.click();
        System.out.println("Title of the new page is: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "About Training Support");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
