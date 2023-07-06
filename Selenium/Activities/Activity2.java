package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/login-form");
        System.out.println("Title of the Login page is: " + driver.getTitle());
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.name("Password")).sendKeys("password");
        driver.findElement(By.xpath("//button[(@type='submit' and text()='Log in')]")).click();
        driver.quit();
    }
}
