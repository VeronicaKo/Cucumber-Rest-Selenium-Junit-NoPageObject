package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void beforeTest() {
        System.setProperty(
                "webdriver.chrome.driver",
                new File("src\\main\\resources\\driver\\chromedriver.exe").getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
