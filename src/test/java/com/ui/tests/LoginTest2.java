package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;


public class LoginTest2 {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver(); //Chromedriver is a class, 
		HomePage homepage = new HomePage(wd);	
		homepage.maximizeWindow();
		LoginPage loginpage =homepage.goToLoginPage();
		loginpage.doLoginWith("jitawo1159@mucate.com", "password");
		
	}

}
