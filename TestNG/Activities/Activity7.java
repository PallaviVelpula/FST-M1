package TestNGActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity7 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    @DataProvider(name = "Authentication")
    public Object[][] credentials(){
        return  new Object[][]{{"admin", "password"}};
    }

    @Test(dataProvider = "Authentication")
    public void activity7(String enterUsername, String enterPassword) {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.name("Password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[(@type='submit' and text()='Log in')]"));
        username.sendKeys(enterUsername);
        password.sendKeys(enterPassword);
        loginBtn.click();
        String actualMsg = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(actualMsg, "Welcome Back, admin");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
