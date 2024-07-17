package com.maveric.git.dataprovider;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	@DataProvider
	public Object[][] getInvalidUsernameOrPassword() {
		return new Object[][] { { "WrongUsername1", "Password1" }, { "Username", "InvalidPassword" } };
	}

	public Object[][] getvalidUsernamePassword() {
		return new Object[][] { { "Username", "Password1" } };

	}
}
