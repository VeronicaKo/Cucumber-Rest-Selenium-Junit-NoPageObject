package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver = Hooks.driver;

    @Given("^I am on the login page \"([^\"]*)\"$")
    public void iAmOnTheLoginPage(String site) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(site);
    }

    @When("^I enter in the login \"([^\"]*)\"$")
    public void iFillInWith(String login) {
        WebElement loginInput = driver.findElement(By.id("UserLogin_username"));
        loginInput.sendKeys(login);
    }

    @And("^I enter in the password \"([^\"]*)\"$")
    public void iFillInPasswordWith(String password) {
        WebElement passwordInput = driver.findElement(By.id("UserLogin_password"));
        passwordInput.sendKeys(password);
    }

    @And("^I press Login button")
    public void iPress() {
        WebElement loginButton = driver.findElement(By.name("yt0"));
        loginButton.click();
    }

    @Then("^I should see admin panel$")
    public void iShouldSeeAdminPanel() {
        WebElement adminPanel = driver.findElement(By.id("nav"));
        adminPanel.isDisplayed();
    }

}
