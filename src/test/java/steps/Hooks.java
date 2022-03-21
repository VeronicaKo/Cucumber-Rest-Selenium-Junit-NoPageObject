package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void beforeTest() {
        System.setProperty(
                "webdriver.chrome.driver",
                new File("src\\main\\resources\\driver\\chromedriver.exe").getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
