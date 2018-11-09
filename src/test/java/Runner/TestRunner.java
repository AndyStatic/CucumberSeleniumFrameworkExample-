package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/java/Features"}, format = {"json:target/cucumber.json"}, glue = "Steps")
public class TestRunner extends AbstractTestNGCucumberTests {
}
