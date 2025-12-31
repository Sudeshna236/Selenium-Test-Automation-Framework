package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTestOld{

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver(); //Chromedriver is a class, 
		//wd is a reference variable of parent entity web driver -for loose coupling
		// a browser session will be launched when executed this
		
		BrowserUtility browserUtility = new BrowserUtility(wd);
		browserUtility.goToWebsite("http://www.automationpractice.pl/index.php");
		browserUtility.maximizeWindow();
		
		browserUtility.clickOn(signInLinkLocator);
		
				
		
		browserUtility.enterText(emailTextBoxLocator, "jitawo1159@mucate.com");
		
		
		
		browserUtility.enterText(passwordTextBoxLocator, "password");
		
	
		browserUtility.clickOn(submitLoginLocator);
		
		
	}

}
