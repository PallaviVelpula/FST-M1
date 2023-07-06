package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity22 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions builder = new Actions(driver);
        driver.get("https://www.training-support.net/selenium/popups");
        System.out.println("Title of the page is: " + driver.getTitle());
        WebElement signInBtn = driver.findElement(By.xpath("//button[@data-tooltip='Click to sign in']"));
        System.out.println("Tooltip message is: "+signInBtn.getAttribute("data-tooltip"));
        builder.moveToElement(signInBtn).build().perform();
        signInBtn.click();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        System.out.println("Success message is displayed as: "+driver.findElement(By.id("action-confirmation")).getText());
        driver.quit();
    }
}
