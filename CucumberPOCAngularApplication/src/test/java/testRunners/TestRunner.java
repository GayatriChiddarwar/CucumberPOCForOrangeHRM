package testRunners;
import org.apache.logging.log4j.*;//LogManager;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/features"
		,glue={"stepdefinations","appHooks"},
		plugin={"pretty","html:reports/myReport.html","json:reports/myReport.json","rerun:target/rerun.txt"
				}
		//tags="@Sanity2"
		)

public class TestRunner {
	Logger log =LogManager.getLogger(this.getClass());
	
	public TestRunner() {
		
	}
}
