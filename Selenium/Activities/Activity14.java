package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/tables");
        System.out.println("Title of the Tables page is: " + driver.getTitle());
        WebElement sortedTable = driver.findElement(By.xpath("//table[@id='sortableTable']"));
        System.out.println("Number of rows are: " + driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr")).size());
        System.out.println("Number of columns are: " + (driver.findElements(By.xpath("//table[@id='sortableTable']/thead/following::tbody/tr[1]/td"))).size());
        System.out.println("Value on Second row second column is: " + (driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"))).getText());
        (driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]"))).click();
        System.out.println("Value on Second row second column after sorting is: " + (driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"))).getText());
        List<WebElement> footer = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        for (int i = 1; i <= footer.size(); i++)
            System.out.println("Footer value of column " + i + " is: " + driver.findElement(By.xpath("//table[@id='sortableTable']/tfoot/tr/th[" + i + "]")).getText());
        driver.quit();
    }
}
