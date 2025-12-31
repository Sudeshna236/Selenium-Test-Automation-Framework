package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase {
	
	
	@Test(description="verifies with valid user is able to login into the application", groups= {"e2e","Sanity"},
			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataProvider")
	public void loginTest(User user) {
		 		
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Sudeshna Sharma");
		
	}
	
//	@Test(description="verifies with valid user is able to login into the application", groups= {"e2e","Sanity"},
//			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestCSVDataProvider")
//	public void loginCSVTest(User user) {
//		 		
//		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Sudeshna Sharma");
//		
//	}
//	
//	@Test(description="verifies with valid user is able to login into the application", groups= {"e2e","Sanity"},
//			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestExcelDataProvider",
//			retryAnalyzer=com.ui.listeners.MyRetryAnalyzer.class)
//	public void loginExcelTest(User user) {
//		
//		
//		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Sudeshna Sharma");
//		
//		
//	}

}
