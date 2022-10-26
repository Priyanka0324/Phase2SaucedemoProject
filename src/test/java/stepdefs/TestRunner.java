package stepdefs;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome= true,  // if we dont add this, we will get garbage value
		plugin = {"pretty","html:target/html-cucumber","json:target/cucumber.json"},
		features = "src/test/java/features",
		glue = "stepdefs",		
		tags = {"@sanity or @regression"} // this is how we can give multiple tags For Ex: @Sanity or @Regression
		
		)



public class TestRunner {

}
