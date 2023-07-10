package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class JavascriptAlerts extends BaseClass {
    Alert alert;

    @Given("User is on the page")
    public void openAlertsPage() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }

    @When("User clicks the Simple Alert button")
    public void clickSimpleAlert() {
        driver.findElement(By.id("simple")).click();
    }

    @When("User clicks the Confirm Alert button")
    public void clickConfirmAlert() {
        driver.findElement(By.id("confirm")).click();
    }

    @When("User clicks the Prompt Alert button")
    public void clickPromptAlert() {
        driver.findElement(By.id("prompt")).click();
    }

    @Then("Alert opens")
    public void openAlert() {
        alert = driver.switchTo().alert();
    }

    @And("Read the text from it and print it")
    public void getAlertText() {
        System.out.println("Text on the alert is: " + alert.getText());
    }

    @And("Write a custom message in it")
    public void enterMessage() {
        alert.sendKeys("Shinzo wo Sasageyo!");
    }

    @And("Close the alert")
    public void acceptAlert() {
        alert.accept();
    }

    @And("Close the alert with Cancel")
    public void dismissAlert() {
        alert.dismiss();
    }

    @And("Read the result text")
    public void readResult() {
        List<WebElement> result = driver.findElements(By.xpath("//p[@id='result']"));
        if (result.size() == 1) {
            System.out.println("Result text is: " + driver.findElement(By.xpath("//p[@id='result']")).getText());
        }
    }

    @And("Close Browser")
    public void closeBrowser() {
        driver.quit();
    }


}
