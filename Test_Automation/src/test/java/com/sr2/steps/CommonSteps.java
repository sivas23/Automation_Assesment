package com.sr2.steps;

import com.sr2.test.driver.manager.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class CommonSteps {

	public static RemoteWebDriver driver;

	public CommonSteps() {
		if (driver == null) {
			try {
				driver = WebDriverManager.getDriverDynamic();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}

}