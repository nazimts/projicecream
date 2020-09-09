package benjerry.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import org.openqa.selenium.opera.OperaDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
private Driver() {};
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver == null) {
			String browser = ConfigReader.getConfiguration("browser");
			switch(browser) {
			case "chrome": 
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "opera": 
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
				break;
			case "firefox": 
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge": 
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			
			}
			
		}
		return driver;
	}
	
		
	
	
	
	public static void closeDriver() {
		if(driver != null) {
			driver.quit();
			driver = null; 
		}
	}
	
}
