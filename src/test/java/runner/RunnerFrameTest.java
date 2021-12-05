package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports/frame.html",
                "json:target/cucumber-reports/frame.json"},
        tags = "@frame",
        monochrome = true,
        publish = true,
        dryRun = false)
public class RunnerFrameTest {
}
