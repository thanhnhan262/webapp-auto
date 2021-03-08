package cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/cucumber",
        glue={"cucumber.stepDefinition", "cucumber.support"},
        plugin = {"pretty", "html:target/cucumber"}
)

public class TestRunner {
}
