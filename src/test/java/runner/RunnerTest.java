package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/testChampions.feature",
		glue = "stepDefinitions",
		plugin = {"pretty", "html:target/testChampionsReport"},
		tags = {"@all"},
		strict = true,
		monochrome = true,
		dryRun = false)

public class RunnerTest {

}


