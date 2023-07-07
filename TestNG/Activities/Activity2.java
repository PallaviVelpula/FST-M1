package TestNGActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void test1() {
        Assert.assertEquals(driver.getTitle(), "Target Practice");
    }

    @Test
    public void test2() {
        WebElement blachBtn = driver.findElement(By.xpath("//button[@class='ui black button']"));
        Assert.assertEquals(blachBtn.getText(), "Violet");
    }

    @Test(enabled = false)
    public void test3() {
        System.out.println("Test case3 to be skipped");
    }

    @Test
    public void test4() {
        throw new SkipException("Throwing skip exception");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
