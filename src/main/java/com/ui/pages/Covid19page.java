package com.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.common.helper.BasePageObject;

public class Covid19page extends BasePageObject{
		
	public Covid19page(WebDriver driver) {		
		super(driver);
	}
	
	public enum ELEMENT 
	{
		table_expand(By.xpath("//div[@class='expand-table-toggle']")),
		all_columns(By.xpath("//div[@class='table-container']//div[@class='cell heading']"))
		;
		
		
		private By findBy;
		
		public By getLocator()
		{
			return findBy;
			
		}
		private ELEMENT(By locator) {
			this.findBy=locator;
		}
	}
	
	public void showAllTableColumns() {
		//clickElement(ELEMENT.table_expand.getLocator());
		executeJSExecutor("arguments[0].click();",getElement(ELEMENT.table_expand.getLocator()));
	}
	
	public int getCountOfAllColumns() {
		return getListOfElement(ELEMENT.all_columns.getLocator()).size();
	}
	
	public List<WebElement> getAllColumns() {
		return getListOfElement(ELEMENT.all_columns.getLocator());
	}
	
}
