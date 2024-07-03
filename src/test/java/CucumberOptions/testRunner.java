package CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		   features="src/test/java/FeatureFiles",
		   glue="StepDefinitions",
		   tags = "@scenario1"
		)


public class testRunner {

}
