package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features="src//test//resources//feature//Conduit.feature",
		glue= {"stepDefinition"},
		dryRun=false,
		monochrome=true,
		plugin= {"pretty",
				"html:target/reports/HTMLReport.html",
		}
		
		)

public class CaseStudyRunner extends AbstractTestNGCucumberTests {

}
