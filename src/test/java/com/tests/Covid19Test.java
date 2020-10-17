package com.tests;


import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.common.helper.BaseStep;
import com.ui.pages.Covid19page;

public class Covid19Test extends BaseStep {
	@BeforeMethod
	void initialize(Method method) {
		beforeMethod(method);
		System.out.println("Driver Initialization Started 1...");		
	}
	
	@Test
	public void caseFatalityRatio(){
		WebDriver driver = super.initialize();
		driver.get("https://www.covid19india.org/");
		
		Covid19page po = new Covid19page(driver);
		po.showAllTableColumns();
		
		int columnNumber=1;
		for(WebElement column : po.getAllColumns()) {
			if(column.findElement(By.tagName("div")).getText().equalsIgnoreCase("Case Fatality Ratio")){
				column.findElement(By.tagName("div")).click();
				break;
			}
			columnNumber++;
		}
		
		Reporter().log(Reporter().getStatus(), "Extract Top 3 states with high fatality ratio");
		int fatalityRatioColumnNumber = columnNumber;
		String FirstStateLocator = "//div[@class='table-container']//div[@class='row'][1]/div["+fatalityRatioColumnNumber+"]";
		String SecondStateLocator = "//div[@class='table-container']//div[@class='row'][2]/div["+fatalityRatioColumnNumber+"]";
		String ThirdStateLocator = "//div[@class='table-container']//div[@class='row'][3]/div["+fatalityRatioColumnNumber+"]";
		
		String FirstStateFatalityRatio = po.getElement(By.xpath(FirstStateLocator)).getText();
		String SecondStateFatalityRatio = po.getElement(By.xpath(SecondStateLocator)).getText();
		String ThirdStateFatalityRatio = po.getElement(By.xpath(ThirdStateLocator)).getText();
		
		Map<String,String> map = new LinkedHashMap<>();
		map.put(po.getElement(By.xpath("//div[@class='table-container']//div[@class='row'][1]/div[1]")).getText(), FirstStateFatalityRatio);
		map.put(po.getElement(By.xpath("//div[@class='table-container']//div[@class='row'][2]/div[1]")).getText(), SecondStateFatalityRatio);
		map.put(po.getElement(By.xpath("//div[@class='table-container']//div[@class='row'][3]/div[1]")).getText(), ThirdStateFatalityRatio);
		
		System.out.println(map);
		Reporter().log(Reporter().getStatus(), "Final Map"+map);	
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
	    
		generateReport(result,driver);
		System.out.println("Tearing Down..");
		driver.quit();
	}
}