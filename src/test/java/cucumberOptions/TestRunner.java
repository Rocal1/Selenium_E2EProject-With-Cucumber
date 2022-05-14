package cucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;


//With Junit
@RunWith(Cucumber.class) //WITH THIS LINE RUNS WITH JUNIT
@io.cucumber.junit.CucumberOptions(features = "src/test/java/features/Login.feature", //TO RUN ALL FEATRUES USE: "src/test/java/features"
glue = "stepDefinition")

//With TestNG
@io.cucumber.testng.CucumberOptions(features = "src/test/java/features/Login.feature",
					glue = "stepDefinition")

public class TestRunner extends AbstractTestNGCucumberTests { // THIS EXTENDS IS NEEDED TO RUN WITH TESTNG

}
