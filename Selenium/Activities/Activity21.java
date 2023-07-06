package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity21 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/tab-opener");
        System.out.println("Title of the page is: " + driver.getTitle());
        driver.findElement(By.id("launcher")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("Handles opened are: " + driver.getWindowHandles());
        for (String handles : driver.getWindowHandles())
            driver.switchTo().window(handles);
        System.out.println("Title of the page is: " + driver.getTitle());
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
        driver.findElement(By.id("actionButton")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        System.out.println("Handles opened are: " + driver.getWindowHandles());
        for (String handles : driver.getWindowHandles())
            driver.switchTo().window(handles);
        System.out.println("Title of the page is: " + driver.getTitle());
        driver.quit();
    }
}
