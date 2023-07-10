package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ProjectActivity5 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
    }
    @Test
    public void editUserInfo() {
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).click();
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.xpath("//input[@value='Edit']")).click();
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Manjiro");
        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Sano");
        driver.findElement(By.id("personal_DOB")).click();
        WebElement dropDownYear = driver.findElement(By.className("ui-datepicker-year"));
        Select selectValue = new Select(dropDownYear);
        selectValue.selectByValue("1998");
        WebElement dropDownMonth = driver.findElement(By.className("ui-datepicker-month"));
        Select selectValue2 = new Select(dropDownMonth);
        selectValue2.selectByVisibleText("May");
        driver.findElement(By.xpath("//a[contains(@class,'ui-state-default') and contains(text(),'15')]")).click();
        driver.findElement(By.xpath("//input[@value='Save']")).click();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
