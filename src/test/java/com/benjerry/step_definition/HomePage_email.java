package com.benjerry.step_definition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import benjerry.pages.HomePage;
import benjerry.utilities.BrowserUtilities;
import benjerry.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage_email {
	public WebDriver driver;
	
	@Given("I am on home page")
	public void i_am_on_home_page() throws InterruptedException {
		
		HomePage homepage = new HomePage();
		//homepage.emailIcon.click();
		//BrowserUtilities.selectByValue(homepage.titleDropDown, "Mr.");
		System.out.println(Driver.getDriver().getTitle());
		System.out.println("lskjdfldskjfsdlj");
		Thread.sleep(2000);
		homepage.fullNameField.sendKeys("tyu");
		
		
	    
	}

	@When("Click on Title drop down")
	public void click_on_Title_drop_down() {
		HomePage homepage = new HomePage();
		
		
		
		
		
		
		
		
	 
	}

	@When("Select Mr. Title")
	public void select_Mr_Title() {
		HomePage homepage = new HomePage();
		//homepage.titleDropDown.click();
		//WebDriver driver = new ChromeDriver();

		BrowserUtilities.selectByValue(homepage.titleDropDown, "Mr.");
	    
	}

	@When("Enter Full Name as {string} into Full Name field")
	public void enter_Full_Name_as_into_Full_Name_field(String string) {
		
		HomePage homepage = new HomePage();
		homepage.fullNameField.sendKeys(string);
	}

	@When("Enter Address as {string} into Address field")
	public void enter_Address_as_into_Address_field(String string) {
	    
	}

	@When("Enter Zip code as {string} into Zip field")
	public void enter_Zip_code_as_into_Zip_field(String string) {
	   
	}

	@When("Enter Phone number {string} into Phone field")
	public void enter_Phone_number_into_Phone_field(String string) {
	
	}

	@When("Enter email as {string} into email field")
	public void enter_email_as_into_email_field(String string) {
	  
	}

	@When("click on Send email button")
	public void click_on_Send_email_button() {
	    
	}

	@Then("Thw message should appear {string}")
	public void thw_message_should_appear(String string) {
	    
	}

}
