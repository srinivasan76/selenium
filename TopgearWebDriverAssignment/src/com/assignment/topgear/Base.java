package com.assignment.topgear;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {

	public static WebDriver driver;

	public static WebDriver initialization() throws IOException {

		FileInputStream fis = new FileInputStream(
				"D:\\Eclipse_selenium_udemy\\TopgearWebDriverAssignment\\src\\com\\assignment\\topgear\\data.properties");
		Properties properties = new Properties();
		properties.load(fis);

		String browserName = properties.getProperty("browser");
		System.out.println(browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			return driver;
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
			driver = new FirefoxDriver();
			return driver;
		} else if (browserName.equalsIgnoreCase("safari")) {
			System.setProperty("webdriver.chrome.driver", "D:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			return driver;
		} else {
			System.setProperty("webdriver.chrome.driver", "D:\\safariDriver.exe");
			driver = new SafariDriver();
			return driver;
		}

	}
}
