package com.test.commonFunctions.helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Waithelper {
	
	private WebDriver driver;
	
	public Waithelper(WebDriver driver) {
		this.driver = driver;
	}
	public void setImplicitWait(long timeout, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}

}
