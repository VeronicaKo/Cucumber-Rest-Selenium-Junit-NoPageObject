package Steps;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Hooks {
    public WebDriver driver;

    @Before
    public void beforeTest() {
        System.setProperty(
                "webdriver.chrome.driver",
                new File("src\\main\\resources\\driver\\chromedriver.exe").getAbsolutePath());
    }
}
