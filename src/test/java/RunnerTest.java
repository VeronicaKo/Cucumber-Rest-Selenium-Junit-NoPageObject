import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/features",
    tags = "@sortplayerstable",
    snippets = SnippetType.UNDERSCORE
)
public class RunnerTest {

}