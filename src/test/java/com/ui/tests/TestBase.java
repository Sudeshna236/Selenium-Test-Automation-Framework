package com.ui.tests;

import static com.constants.Browser.EDGE;
import static com.constants.Browser.CHROME;
import static com.constants.Browser.FIREFOX;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homepage;
	Logger logger =LoggerUtility.getLogger(this.getClass());

	private boolean isLambdaTest;
	
	@Parameters({"browser","isLambdaTest","isHeadless"})
	@BeforeMethod(description = "Load home page of the website")
	public void setup(
		@Optional("firefox") String browser,
		@Optional("false") boolean isLambdaTest,
		@Optional("true") boolean isHeadless,
		ITestResult result) {
		this.isLambdaTest =isLambdaTest;
		WebDriver lambdaDriver;
		if(isLambdaTest) {
			
			lambdaDriver=LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homepage =new HomePage(lambdaDriver);

		}
		else {
			
			//running the test in local machine
			logger.info("Load the home page of the website");

			homepage = new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
		}
		//homepage.maximizeWindow();
	}

	public BrowserUtility getInstance() {
		return homepage;
	}

	@AfterMethod(description="Tear down the browser")
	public void tearDown() {
		if(isLambdaTest) {
			LambdaTestUtility.quitSession();//.quitSession();
		}
		else {
			
			homepage.quit();
		}
		
	}
}
