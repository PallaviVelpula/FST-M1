package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/target-practice");
        System.out.println("Title of the Target practice page is: " + driver.getTitle());
        System.out.println("Text of third header is: "+driver.findElement(By.xpath("//h3[@class='ui yellow header']")).getText());
        System.out.println("Colour of fifth header is: "+driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color"));
        System.out.println("Class of violet button is: "+driver.findElement(By.className("ui violet button")).getAttribute("class"));
        System.out.println("Text of grey button is: "+driver.findElement(By.cssSelector(".ui.green.button")).getText());
        driver.quit();
    }
}
