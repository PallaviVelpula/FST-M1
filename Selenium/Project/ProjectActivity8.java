package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ProjectActivity8 {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).click();
    }

    @Test
    public void applyLeave() {
        Actions builder = new Actions(driver);
        driver.findElement(By.xpath("//span[contains(text(),'Apply Leave')]")).click();
        WebElement leaveType = driver.findElement(By.id("applyleave_txtLeaveType"));
        Select selectValue = new Select(leaveType);
        selectValue.selectByValue("1");
        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        String fromDate = "2023-07-19";
        String toDate = "2023-07-20";
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys(fromDate);
        driver.findElement(By.id("applyleave_txtToDate")).clear();
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys(toDate);
        builder.sendKeys(Keys.ENTER).build().perform();
        driver.findElement(By.id("applyBtn")).click();
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td/a"));
        for (int i = 1; i <= rows.size(); i++) {
            if (driver.findElement(By.xpath("(//table[@id='resultTable']/tbody/tr/td/a)" + "[" + i + "]")).getText().equals(fromDate + " to " + toDate)) {
                Assert.assertTrue(driver.findElement(By.xpath("(//table[@id='resultTable']/tbody/tr/td/a)" + "[" + i + "]/parent::td/following::td[5]")).getText().contains("Pending Approval"));
                break;
            }
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

