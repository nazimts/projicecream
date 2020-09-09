package com.benjerry.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith (Cucumber.class)
@CucumberOptions (
		
	
		plugin = {"pretty"	
		
		},
					
		tags = "@homePage",
				features = "src/test/resources/com.benjerry/features",
				glue = "com/benjerry/step_definition"

//		,dryRun = true
		,monochrome =true

		)
public class CukeRunner {

}
