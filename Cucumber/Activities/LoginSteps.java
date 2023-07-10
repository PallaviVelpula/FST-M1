package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps extends BaseClass{
    @Given("User is on Login page")
    public void openLoginPage() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        driver.get("https://www.training-support.net/selenium/login-form");
        Assertions.assertEquals("Login Form", driver.getTitle());
    }

    @When("User enters {string} and {string}")
    public void enterCredentials(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("Read the page title and confirmation message")
    public void pageTitleAndMessage() {
        System.out.println("Title of the page is: " + driver.getTitle() + " and login Message is: " + driver.findElement(By.id("action-confirmation")).getText());
        Assertions.assertTrue((driver.findElement(By.id("action-confirmation")).getText()).contains("Welcome Back, "));
    }

}
