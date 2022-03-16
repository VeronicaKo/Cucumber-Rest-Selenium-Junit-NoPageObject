import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TabPlayersStepdefs {

    private final WebDriver driver = new ChromeDriver();

    @Given("^I am in the admin page$")
    public void iAmInTheAdminPage() {
    }

    @When("^I click on the button user$")
    public void iClickOnTheButtonUser() {
    }

    @And("^I click on the button players$")
    public void iClickOnTheButtonPlayers() {
    }

    @Then("^I should see table of players$")
    public void iShouldSeeTableOfPlayers() {
    }
}
