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

public class Activity5 {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test(groups = {"HeaderTests", "ButtonTests"})
    public void pageTitle() {
        Assert.assertEquals(driver.getTitle(), "Target Practice");

    }
    @Test(dependsOnMethods = {"pageTitle"}, groups = {"HeaderTests"})
    public void headerTest1() {
        WebElement thirdHeader = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(thirdHeader.getText(), "Third header");
    }
    @Test(dependsOnMethods = {"pageTitle"}, groups = {"HeaderTests"})
    public void headerTest2() {
        WebElement header5 = driver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(header5.getCssValue("color"), "rgb(251, 189, 8)");
    }
    @Test(dependsOnMethods = {"pageTitle"}, groups = {"ButtonTests"})
    public void buttonTest1() {
        WebElement button1 = driver.findElement(By.cssSelector("button.olive"));
        Assert.assertEquals(button1.getText(), "Olive");
    }
    @Test(dependsOnMethods = {"pageTitle"}, groups = {"ButtonTests"})
    public void buttonTest2() {
        WebElement button2 = driver.findElement(By.cssSelector("button.brown"));
        Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
