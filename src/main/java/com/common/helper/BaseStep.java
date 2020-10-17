package com.common.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/*import org.openqa.selenium.firefox.FirefoxDriver;*/
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.common.utils.ConfigProvider;
import com.ui.reports.ExtentTestNGReportBuilder;


public class BaseStep extends ExtentTestNGReportBuilder{
	
	public WebDriver driver;
	
	public WebDriver initialize()
	{	
		
		driver = getWebDriver("chrome");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver getWebDriver(String browser)
	{
		if(browser.equalsIgnoreCase("IE")){
			
					System.setProperty("webdriver.ie.driver", ConfigProvider.get("IEDriverPath"));
				   driver = new InternetExplorerDriver();
		}
		
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", ConfigProvider.get("chromeDriverPath"));
			//ChromeOptions chromeOptions = new ChromeOptions();
			/*chromeOptions.addArguments("--disable-infobars");*/
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
						System.setProperty("webdriver.gecko.driver", ConfigProvider.get("FirefoxDriverPath"));
					   driver = new FirefoxDriver();
		}
		else
			{
			System.out.println("Invalid Browser Selection. Please choose from IE|chrome|firefox");
		 			
		}
		
		return driver;
				
	}
	
	public void launchApp(String URL)
	{
		driver.get(URL);
	}

}
