package com.test.commonFunctions;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import com.test.commonFunctions.helpers.Waithelper;
import com.test.pages.GoogleHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFunctions {
	
	static WebDriver driver;
	
	protected GoogleHomePage homepage;
	

	@BeforeTest
	public void browserSetUp() throws Exception {
		
	            WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();             
		
	    
		//driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
                Waithelper wait = new Waithelper(driver);                
               wait.setImplicitWait(80,TimeUnit.SECONDS);
		Thread.sleep(4000);
		//define page object classes
		homepage = PageFactory.initElements(getWebDriver(), GoogleHomePage.class);
		
	}
	

	@AfterSuite
	public void closeAllBrowser() {
		driver.quit();
	}
	

	public WebDriver getWebDriver() {
		return driver;
	}


}
