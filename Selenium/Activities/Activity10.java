package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity10 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of the web page is: " + driver.getTitle());
        WebElement toggle = driver.findElement(By.className("willDisappear"));
        toggle.isDisplayed();
        driver.findElement(By.id("toggleCheckbox")).click();
        System.out.println("Is checkbox toggle displayed?: "+toggle.isDisplayed());
        driver.quit();
    }
}
