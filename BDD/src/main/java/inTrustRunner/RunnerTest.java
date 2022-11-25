package inTrustRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/java/features/" }, glue = {
		"inTrustStepDefination" }, monochrome = true, tags = "@InTrustDeploymentManager01", plugin = { "pretty",
				"json:target/cucumber-report/cucumber.json", "html:target/cucumber-htmlreports",
				"inTrustReporting.StepDetails",
				}, strict = true)

public class RunnerTest extends AbstractTestNGCucumberTests {

}
