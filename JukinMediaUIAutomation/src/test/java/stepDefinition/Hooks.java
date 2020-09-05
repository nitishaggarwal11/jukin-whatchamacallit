package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverFactory;

public class Hooks {
	
	@Before
    public void beforeScenarioStart(){
		/* 
		 *  All the code whic you want to execute before running a scenario will go here 
		 *  
		 *  */
    }

	@After
    public void afterScenarioFinish(Scenario scenario){
		/* Take Screenshot */
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				//This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
				
				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				File destinationPath = new File(System.getProperty("user.dir") + "/target/html/screenshots/" + screenshotName + ".png");
				
				//Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);   

				//This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
				Reporter.addStepLog("Exception in capturing the screenshot of failed scenario " + e.getMessage());
			} 
		}
    }
	
}
