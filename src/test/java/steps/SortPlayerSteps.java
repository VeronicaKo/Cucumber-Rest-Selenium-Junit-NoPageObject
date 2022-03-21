package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;


public class SortPlayerSteps {
    WebDriver driver = Hooks.driver;

    @And("^I click heading Username of Players table$")
    public void iClickHeadingOfPlayersTable() {
        WebElement usernameHeader = driver.findElement(By.cssSelector("a.sort-link"));
        usernameHeader.click();
    }

    @Then("^I check sorting of Username$")
    public void iCheckSortingOfUsername() throws InterruptedException {
        // ставлю sleep т.к. неявные и явные ожидания не помогают, ибо элемент уже есть на странице и исчезает всего
        // на пару мгновений для обновления таблицы сортировки, чего хватает драйверу, чтобы этот локатор "потерять"
        // буду рада комментарию как с таким бороться
        sleep(1000);
        List<WebElement> usersNames = driver.findElements(By.cssSelector("td:nth-child(2) > a"));
        List<String> actualNames = new ArrayList<>();
        List<String> exceptedNames = new ArrayList<>();

        for (WebElement user : usersNames) {
            actualNames.add(user.getText());
            exceptedNames.add(user.getText());
        }
        Collections.sort(exceptedNames);
        assertEquals(actualNames, exceptedNames);
    }
}
