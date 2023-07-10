package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ProjectActivity9 {

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
    public void retrieveEmgContacts() {
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Emergency Contacts')]")).click();
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr"));
        WebElement columns;
        WebElement mobileNos;
        for (int i = 1; i <= rows.size(); i++) {
            columns = driver.findElement(By.xpath("//table[@id='emgcontact_list']/tbody/tr[" + i + "]/td[4]"));
            if (!(columns.getText().isEmpty()))
                System.out.println("Home Telephones are: " + columns.getText());
            mobileNos = driver.findElement(By.xpath("//table[@id='emgcontact_list']/tbody/tr[" + i + "]/td[5]"));
            if (!(mobileNos.getText().isEmpty()))
                System.out.println("Mobile Numbers are: " + mobileNos.getText());
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
