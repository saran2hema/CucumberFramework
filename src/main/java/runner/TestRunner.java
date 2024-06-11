package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/feature/", glue = "stepDefinitions",
plugin={"pretty","html:target/reports3.html"}, monochrome=false, dryRun=false)
public class TestRunner {

}
