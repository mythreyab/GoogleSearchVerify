package com.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.test.commonFunctions.PageFunctions;


public class GoogleHomePage extends PageFunctions {

	public GoogleHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//input[@name='q']")
	private WebElement GoogleSearchField;
	

	@FindBy(xpath = "//ul[@role='listbox']/li")
	private List<WebElement> GoogleSearchSuggestions;


	public void openGoogleHomePage(){
		driver.get("https://www.google.com");
	}
	
	public void enterSearchTerm(String searchTerm){
		GoogleSearchField.sendKeys(searchTerm);
	}
	
	public void verifyWordInSuggestionList(String searchTerm){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		List allOptions = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		
		for (int i = 0; i < allOptions.size(); i++) {
			String option = ((WebElement) allOptions.get(i)).getText();
			System.out.println(option);
			Assert.assertTrue(option.contains(searchTerm), "Option doesn't contain searched key");
		}
	}

}
