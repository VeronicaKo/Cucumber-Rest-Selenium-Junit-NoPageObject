package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;


public class TabPlayersSteps {
    WebDriver driver = Hooks.driver;

    @And("^I select the menu administration item by number \"([^\"]*)\"$")
    public void iSelectTheMenuAdministrationItemByNumber(int itemNumber) {
        List<WebElement> buttonUsers = driver.findElements(By.cssSelector("a[data-toggle='collapse']"));
        buttonUsers.get(itemNumber).click();
    }

    @And("^I click on the button players$")
    public void iClickOnTheButtonPlayers() {
        WebElement buttonPlayers = driver.findElement(By.cssSelector("ul#s-menu-users>li"));
        buttonPlayers.click();
    }

    @Then("^I should see table of players with \"([^\"]*)\" item$")
    public void iShouldSeeTableOfPlayersWithItem(int countPlayers) throws InterruptedException {
        sleep(1000);
        List<WebElement> itemsPlayers = driver.findElements(By.cssSelector("td.centered.hide-mobile"));
        assertEquals(countPlayers, itemsPlayers.size());
    }

}
