package com.sr2.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class SharedSteps extends CommonSteps{

	

	@After  
    public void clearDriver() {
        driver.close();
        driver=null;
    }
	
	
	@Before
	public void deleteCookies() { 
		try
		{
			driver.manage().deleteAllCookies();
		}
		catch(WebDriverException e)
		{
			System.out.println(e.getMessage());
		}
		
	}


}
