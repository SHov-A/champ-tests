package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/testChampions.feature",
		glue = "stepDefinitions",
		plugin = {"pretty", "html:target/cucumber-reports/all.html",
				"json:target/cucumber-reports/all.json"},
		tags = "@all",
		monochrome = true,
		dryRun = false)

public class RunnerTest {

}


