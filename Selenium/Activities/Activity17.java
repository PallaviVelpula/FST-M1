package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Activity17 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/selects");
        System.out.println("Title of the web page is: " + driver.getTitle());
        WebElement singleSelectDropdown = driver.findElement(By.id("single-select"));
        Select select = new Select(singleSelectDropdown);
        select.selectByVisibleText("Option 2");
        select.selectByIndex(3);
        select.selectByValue("4");
        List<WebElement> allOptions = select.getOptions();
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }
        driver.quit();
    }
}
