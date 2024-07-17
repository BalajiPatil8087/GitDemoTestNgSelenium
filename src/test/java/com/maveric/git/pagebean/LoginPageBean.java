package com.maveric.git.pagebean;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

public class LoginPageBean {
	@FindBy(how = How.ID, id = "login_field")
	private WebElement Username;

	@FindBy(how = How.NAME, name = "password")
	private WebElement password;

	@FindBy(how = How.NAME, name = "commit")
	private WebElement commit;

	@FindBy(how = How.XPATH, xpath = "//div[contains(text(),'Incorrect username or password')]")
	private WebElement errorMeassage;

	@FindBy(how = How.XPATH, xpath = "(//span[normalize-space()='Dashboard'])[2]")
	private WebElement getDashborad;

	public String getUsername() {
		return Username.getText();
	}

	public void setUsername(String Username) {
		this.Username.sendKeys(Username);
	}

	public String getPassword() {
		return password.getText();
	}

	public void setPassword(String Password) {
		this.password.sendKeys(Password);
	}

	public String getErrorMeassage() {
		return errorMeassage.getText();
	}

	public String getDashborad() {
		return getDashborad.getText();
	}

	public void ClickSubmit() {
		commit.click();
	}

}
