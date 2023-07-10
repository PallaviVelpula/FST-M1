package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProjectActivity4 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
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
    public void addEmp() throws InterruptedException {
        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewPimModule")));
        driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).click();
        driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
        driver.findElement(By.id("btnAdd")).click();
        String firstname = "iuiiu";
        String lastName = "gfhf";
        driver.findElement(By.id("firstName")).sendKeys(firstname);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("btnSave")).click();

        driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
        WebElement searchEmp = driver.findElement(By.id("empsearch_employee_name_empName"));
        searchEmp.click();
        searchEmp.clear();
        searchEmp.sendKeys(firstname + " " + lastName);
        searchEmp.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.id("searchBtn")).click();
        Assert.assertEquals(firstname, driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[3]/a")).getText());
        Assert.assertEquals(lastName, driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[4]/a")).getText());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
