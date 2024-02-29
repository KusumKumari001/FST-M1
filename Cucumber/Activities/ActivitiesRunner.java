package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/Features",
        glue = {"src/test/StepDefinitions", "src/test/TestRunner"},
        tags = "@activity5"
)

public class ActivitiesRunner {
    //empty
}