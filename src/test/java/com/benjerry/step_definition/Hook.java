package com.benjerry.step_definition;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import benjerry.utilities.Driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Hook {
public WebDriver driver;
	
	@Before
	public void setUp() {
		
	//	Driver.getDriver().manage().timeouts().implicitlyWait(
	//			(Long.parseLong(ConfigReader.getConfiguration("implicitTimeout"))), TimeUnit.SECONDS);
	//	Driver.getDriver().manage().window().maximize();

		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://action.benjerry.com/lh92ba9");

	}
	
	

	
	@After
	public void tearDown() {
		
		Driver.closeDriver();
	}

	
	

	

	



}
