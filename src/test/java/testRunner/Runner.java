package testRunner;

import org.junit.runner.RunWith; 
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
       
@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"src/test/resources/features"},
		glue={"stepDefinitions"},
		tags= {"@SampleFeature_wpmobile"},
		monochrome=true,
		format  = {"pretty", "html:target/Destination","json:target/Destination/Cucumber.json","junit:target/Destination/Cucumber.xml"},
		plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:output/ExtentReport.html"}
		) 

public class Runner{

}