package com.maveric.git.test;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.maveric.git.dataprovider.TestDataProvider;
import com.maveric.git.dataprovider.TestDataProviderExcel;
import com.maveric.git.pagebean.LoginPageBean;
import com.maveric.git.utils.DriverFactory;

import junit.framework.Assert;

import org.apache.tools.ant.types.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class LoginTest {
	private WebDriver driver;
	private LoginPageBean LoginPageBean;

	@BeforeMethod
	public void setUpTestEnv() {
		driver = DriverFactory.getDriver();
		driver.get("https://github.com/login");
		LoginPageBean = PageFactory.initElements(driver, LoginPageBean.class);

	}

	@Test(testName = "Test github sign with invalid ctredentials", dataProviderClass = TestDataProviderExcel.class, dataProvider = "getInvalidUserNameOrInvalidPassword")
	public void test1(String Username, String password) {

		LoginPageBean.setUsername(Username);
		LoginPageBean.setPassword(password);
		LoginPageBean.ClickSubmit();
		String exceptedErrorMsg = "Incorrect username or password.";

		String actualerrormsg = LoginPageBean.getErrorMeassage();
		Assert.assertEquals(exceptedErrorMsg, actualerrormsg);
		System.out.println(actualerrormsg);

	}

	@Test(testName = "Test github sign with valid ctredentials", dataProviderClass = TestDataProviderExcel.class, dataProvider = "getUserNamePassword")
	public void test2(String Username, String password) throws InterruptedException {
		LoginPageBean.setUsername(Username);
		LoginPageBean.setPassword(password);
		LoginPageBean.ClickSubmit();
		Thread.sleep(2000);

//		String exceptedgetDashborad = "Dashborad";
//		String actualgetDashborad = LoginPageBean.getDashborad();
//		Assert.assertEquals(exceptedgetDashborad, actualgetDashborad);
//		System.out.println(actualgetDashborad);

	}

	@AfterMethod
	public void tearDownTestEnv() {
		driver.quit();
	}

}
