package benjerry.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import benjerry.utilities.Driver;



public class HomePage {

	
	public HomePage () {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath="//select[@id='input-title']")
	public WebElement titleDropDown;
	
	@FindBy (id = "input-name")
	public WebElement fullNameField;
	
	@FindBy (id = "emailActionIcon")
	public WebElement emailIcon;
	
	@FindBy (id = "input-address1")
	WebElement addressField;
	
	@FindBy (id="input-zip5")
	WebElement zipCodeField;
	
	@FindBy(id = "input-phone")
	WebElement phoneField;
	
	@FindBy (id="input-email")
	WebElement emailField;
}
