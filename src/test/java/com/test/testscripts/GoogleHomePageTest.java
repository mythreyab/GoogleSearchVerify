package com.test.testscripts;

import org.testng.annotations.Test;

import com.test.commonFunctions.TestFunctions;

public class GoogleHomePageTest extends TestFunctions {
	@Test
	  public void suggestionVerification() throws InterruptedException 
	  {
		
		
		homepage.openGoogleHomePage();
		
		homepage.enterSearchTerm("wedding");
		
		homepage.verifyWordInSuggestionList("wedding");
	  }



}
