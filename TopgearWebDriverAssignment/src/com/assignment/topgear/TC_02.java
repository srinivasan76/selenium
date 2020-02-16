package com.assignment.topgear;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_02 extends Base {

	@BeforeTest
	public void getInitialize() throws IOException {
		driver = initialization();
		driver.get("https://www.rediff.com/");

	}

	@Test
	public void getAllElements() {

		driver.findElement(By.id("srchword")).sendKeys("h");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("DefaultRowColor")));
		List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='DefaultRowColor']/p"));
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).getText());
		}
	}

	@AfterTest(enabled = false)
	public void getClose() {
		driver.close();
	}
}
