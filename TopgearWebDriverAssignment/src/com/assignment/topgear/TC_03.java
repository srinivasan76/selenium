package com.assignment.topgear;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class TC_03 {

	@Test
	public void getData() throws IOException, InvalidFormatException {

		FileInputStream fis = new FileInputStream("D:\\WebDriverAssignment.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		
		while(rowIterator.hasNext()) {
			Row row=rowIterator.next();
			Iterator<Cell> cells = row.cellIterator();
			while(cells.hasNext()) {
				System.out.print(cells.next().getStringCellValue()+"    ");
			}
			System.out.println();
		}
		
		
		
	}
}
