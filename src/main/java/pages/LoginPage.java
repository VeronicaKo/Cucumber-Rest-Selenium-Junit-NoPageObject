package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage {
  private final WebDriver driver = new ChromeDriver();


//  WebElement logoText = driver.findElement(By.cssSelector("#supportLogoCell"));

  private List<WebElement> inputs = driver.findElements(By.cssSelector(".base-edit-input"));

  private List<WebElement> greenButton = driver.findElements(By.cssSelector("span.t-btn-style-green"));


  public void openPage() {
//    driver = new ChromeDriver();
//    driver.get("https://bpm-test.bank.srv/");
    driver.get("http://test-app.d6.dev.devcaz.com/admin/login");
  }

  public void fillLogin(String login) {
    inputs.get(0).sendKeys(login);
  }

  public void fillPassword(String password) {
    inputs.get(1).sendKeys(password);
  }

  public void clickLoginButton() {
    greenButton.get(0).click();
    driver.quit();
  }
}
