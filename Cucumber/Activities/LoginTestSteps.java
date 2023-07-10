package StepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class LoginTestSteps extends BaseClass{
    @When("User enters username and password")
    public void enterUserCredentials() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
