package cucumberOption;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", monochrome = true, dryRun = false, plugin = {
		"pretty", "html:target/site/cucumber-report-default",
		"json:target/cucumber.json" }, snippets = SnippetType.CAMELCASE, tags = { "@account" }
// dryrun=true implement all step thì mới run
// dryRun=true
)
public class CucumberTestRunner {
//update comment to run auto in Jenkin

}
