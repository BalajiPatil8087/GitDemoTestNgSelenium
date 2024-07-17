package com.maveric.git.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static WebDriver WebDriverExplicitConfig() {
		// Explicit way to Configure Selenium Driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\patilbs\\Documents\\chromedriver-win64\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.setBinary("C:\\Users\\patilbs\\Documents\\chrome-win64\\chrome.exe");
		return new ChromeDriver(options);

	}

	// Implicit way to Configure Selenium Driver

	private static WebDriver WebDriverImplicitConfig() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		return new ChromeDriver(options);
	}

	public static WebDriver getDriver() {
		WebDriver driver = WebDriverExplicitConfig();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		return driver;

	}
}
