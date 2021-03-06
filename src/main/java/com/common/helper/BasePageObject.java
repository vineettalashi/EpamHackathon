package com.common.helper;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.common.utils.ConfigProvider;

public class BasePageObject{
		
		public WebDriver driver;
		public BasePageObject(WebDriver webdriver) {
			this.driver = webdriver;
		}
		
		protected void clickElement(By loc)
		{
			WebElement ele = getElement(loc);
			ele.click();
		}
		
		public WebElement getElement(By Locator)
		{	
			WebElement element = null;
			final By ElementLocator = Locator;
			
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
										.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5));
			element = wait.until(new Function<WebDriver, WebElement>() 
			{
				public WebElement apply(WebDriver seldriver) { 
					WebElement ret = null;
					try
					{
						ret = PageObjectUtils.getDesiredElement(seldriver,ElementLocator);
						
					}
					catch(StaleElementReferenceException e)
					{
						e.printStackTrace();
					}
					catch(NoSuchElementException e)
					{
						e.printStackTrace();
					}
			         
					return ret;
					}
			 
			});
			
			if(element.isDisplayed() && element.isEnabled())		
				return element;
			else
				return null;
			
			
		}
		
		public List<WebElement> getListOfElement(By Locator)
		{	
			List<WebElement> elements = new ArrayList<WebElement>();
			final By ElementLocator = Locator;
			
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5));
			elements = wait.until(new Function<WebDriver, List<WebElement>>() 
			{
				public  List<WebElement> apply(WebDriver seldriver) { 
					List<WebElement> listOfElements = new ArrayList<WebElement>();
					try
					{
						listOfElements = PageObjectUtils.getDesiredListOfElements(seldriver,ElementLocator);
						
					}
					catch(StaleElementReferenceException e)
					{
						e.printStackTrace();
					}
					catch(NoSuchElementException e)
					{
						e.printStackTrace();
					}
			         
					return listOfElements;
					}
			 
			});
			
			return elements;
			
			
		}
		
		public JavascriptExecutor executeJSExecutor(String script,WebElement element) {
			System.out.println("driver"+driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(script,element);
			return js;
		}

	}

