package runners;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = "stepdefinitions", // Path to your step definitions and hooks
        plugin = {"pretty", "html:target/cucumber-reports.html"} // Reporting options
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
