package com.assignment.topgear;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_01_SpiceJet extends Base {

	@BeforeTest
	public void getInitialize() throws IOException {
		driver = initialization();
		driver.get("https://www.spicejet.com/");
	}

	@Test
	public void selectDate() {

		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		String month_year_first = driver
				.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/div/div/span[1]"))
				.getText()
				+ " "
				+ driver.findElement(
						By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/div/div/span[2]"))
						.getText();

		String month_year_last = driver
				.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']/div/div/span[1]"))
				.getText()
				+ " "
				+ driver.findElement(
						By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']/div/div/span[2]"))
						.getText();

		while (!month_year_first.equalsIgnoreCase("May 2020") && !(month_year_last.equalsIgnoreCase("May 2020"))) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			month_year_first = driver
					.findElement(
							By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/div/div/span[1]"))
					.getText()
					+ " "
					+ driver.findElement(
							By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/div/div/span[2]"))
							.getText();
			month_year_last = driver
					.findElement(
							By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']/div/div/span[1]"))
					.getText()
					+ " "
					+ driver.findElement(
							By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']/div/div/span[2]"))
							.getText();
		}
		List<WebElement> date_first = driver.findElements(
				By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td/a"));
		List<WebElement> date_last = driver.findElements(
				By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']/table/tbody/tr/td/a"));

		if (month_year_first.equalsIgnoreCase("May 2020")) {

			for (int i = 0; i < date_first.size(); i++) {
				if (date_first.get(i).getText().equals("25")) {
					date_first.get(i).click();
					break;
				}
			}

		} else {
			for (int i = 0; i < date_last.size(); i++) {
				if (date_last.get(i).getText().equals("25")) {
					date_last.get(i).click();
					break;
				}
			}

		}

	}

	@AfterTest(enabled = false)
	public void getClose() {
		driver.close();
	}

}
