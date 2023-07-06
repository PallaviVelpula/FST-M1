package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/javascript-alerts");
        System.out.println("Title of the web page is: " + driver.getTitle());
        driver.findElement(By.id("prompt")).click();
        Alert promptalert = driver.switchTo().alert();
        System.out.println(promptalert.getText());
        promptalert.sendKeys("Awesome!");
        promptalert.accept();
        driver.quit();
    }
}
