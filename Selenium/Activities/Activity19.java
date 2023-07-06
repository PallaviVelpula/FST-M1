package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        System.out.println("Title of the web page is: " + driver.getTitle());
        WebElement confirmationAlert = driver.findElement(By.id("confirm"));
        confirmationAlert.click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Text on the alert box is: "+alert.getText());
        alert.accept();
        confirmationAlert.click();
        driver.switchTo().alert().dismiss();
        driver.quit();
    }
}
