package Steps;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepdefs {
    private final WebDriver driver = new ChromeDriver();

    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() {
        driver.get("http://test-app.d6.dev.devcaz.com/admin/login");
    }

    @When("^I enter in the login \"([^\"]*)\"$")
    public void iFillInWith(String login) throws Throwable {
        WebElement loginInput = driver.findElement(By.id("UserLogin_username"));
        loginInput.sendKeys(login);
    }

    @And("^I enter in the password \"([^\"]*)\"$")
    public void iFillInPasswordWith(String password) throws Throwable {
        WebElement passwordInput = driver.findElement(By.id("UserLogin_password"));
        passwordInput.sendKeys(password);
    }

    @And("^I press Login button")
    public void iPress() throws Throwable {
        WebElement loginButton = driver.findElement(By.name("yt0"));
        loginButton.click();
    }

    @Then("^I should be on the admin page$")
    public void iShouldBeOnTheUsersHomePage() {
        WebElement adminPanel = driver.findElement(By.id("nav"));
        adminPanel.isDisplayed();
    }

    @After
    public void afterTest() {
        driver.quit();
    }

}
