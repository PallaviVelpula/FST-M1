package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/tables");
        System.out.println("Title of the web page is: " + driver.getTitle());
        int rows = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr")).size();
        int columns = driver.findElements(By.xpath("(//table[@class='ui celled striped table']/tbody/tr)[1]/td")).size();
        System.out.println("Number of rows is: "+ rows+" and number of columns is: "+columns);
        for (int i=1; i<=columns; i++){
            System.out.println("Value of cell - "+i+" is: "+ driver.findElement(By.xpath("((//table[@class='ui celled striped table']/tbody/tr)[1]/td)["+i+"]")).getText());
        }
        System.out.println("Value of 2nd column in second row is: "+driver.findElement(By.xpath("((//table[@class='ui celled striped table']/tbody/tr)[2]/td)[2]")).getText());
        driver.quit();
    }
}
