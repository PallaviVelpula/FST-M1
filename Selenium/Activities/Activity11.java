package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of the web page is: " + driver.getTitle());
        WebElement checkbox = driver.findElement(By.className("willDisappear"));
        System.out.println("Is checkbox selected?: "+checkbox.isSelected());
        checkbox.click();
        System.out.println("Is checkbox checkbox selected after clicking on the toggle?: "+checkbox.isSelected());
        driver.quit();
    }
}
