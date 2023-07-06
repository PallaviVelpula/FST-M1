package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity16 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/dynamic-attributes");
        System.out.println("Title of the web page is: " + driver.getTitle());
        driver.findElement(By.cssSelector("input[class$='-username']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[class$='-password']")).sendKeys("password");
        driver.findElement(By.xpath("//label[contains(text(),'Confirm Password')]/following-sibling::input")).sendKeys("password");
        driver.findElement(By.xpath("//input[starts-with(@name,'email')]")).sendKeys("pallavi.example@gmail.com");
        driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Sign Up')]")).click();
        System.out.println(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='action-confirmation']")))).getText());
        driver.quit();
    }
}
