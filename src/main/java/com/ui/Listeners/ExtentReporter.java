package com.ui.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReporter {

	private static ExtentReporter extentReporter;
	ExtentReports extent=null;
	ExtentTest reporter=null;
	private ExtentReporter()
	{		
	}
	
	public static ExtentReporter getExtentReporter()
	{
		synchronized(ExtentReporter.class){
			if(extentReporter==null)
		
		{
			extentReporter = new ExtentReporter();
		}
			
		}
		return extentReporter;
	}

	
}
