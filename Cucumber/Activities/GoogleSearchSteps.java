package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchSteps extends BaseClass{
    @Given("^User is on Google Home Page$")
    public void openGoogleHomePage() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));driver.get("https://www.google.com");
    }

    @When("^User types in Cheese and hits ENTER$")
    public void enterAndSearch() {
        driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Cheese", Keys.ENTER);
    }

    @Then("^Show how many search results were shown$")
    public void checkResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
        WebElement results = driver.findElement(By.id("result-stats"));
        System.out.println("Results are: "+ results.getText());
    }

    @And("^Close the browser$")
    public void closeTheBrowser(){
        driver.quit();
    }
}
