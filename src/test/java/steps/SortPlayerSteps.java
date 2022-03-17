package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SortPlayerSteps {
    WebDriver driver = Hooks.driver;

    @And("^I click heading Username of Players table$")
    public void iClickHeadingOfPlayersTable() {
        WebElement usernameHeader = driver.findElement(By.cssSelector("a.sort-link"));
        usernameHeader.click();
    }

    @Then("^I check sorting of Username$")
    public void iCheckSortingOfUsername() {
        List<WebElement> usersNames = driver.findElements(By.cssSelector("td:nth-child(2) > a "));
        String currentUserName = "";

        for (WebElement user : usersNames) {
            int comparedResult = currentUserName.compareTo(user.getText());
        }
    }
}
