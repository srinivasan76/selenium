package com.assignment.topgear;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TC_05 extends Base{

	@BeforeTest
	public void getInitialize() throws IOException {
		driver = initialization();
		driver.get("https://www.spicejet.com/");
	}
	@AfterTest
	public void getClose() {
		driver.close();
	}
}
