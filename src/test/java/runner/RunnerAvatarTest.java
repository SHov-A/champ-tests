package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports/avatar.html",
                "json:target/cucumber-reports/avatar.json"},
        tags = "@avatar",
        monochrome = true,
        dryRun = false)
public class RunnerAvatarTest {
}
