package com.maveric.git.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestDataProviderExcel {

	private static Workbook workbook;
	static {
		try {
			workbook = WorkbookFactory.create(new FileInputStream(new File(".\\TestData\\GitTestData.xlsx")));
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getInvalidUserNameOrInvalidPassword() {

		Object[][] testData;
		Sheet workSheet = workbook.getSheet("SignIn-Test1");
		int rows = workSheet.getLastRowNum();
		int columns = workSheet.getRow(workSheet.getLastRowNum()).getLastCellNum();
		testData = new Object[rows][columns];
		for (int i = 0; i < testData.length; i++) // rows
			for (int j = 0; j < workSheet.getRow(i).getLastCellNum(); j++) // columns
				testData[i][j] = workSheet.getRow(i).getCell(j).toString();

		return testData;
	}

	@DataProvider
	public Object[][] getUserNamePassword() {
		Object[][] testData;
		Sheet workSheet = workbook.getSheet("SignIn-Test2");
		int rows = workSheet.getLastRowNum() + 1;
		int columns = workSheet.getRow(workSheet.getLastRowNum()).getLastCellNum();
		testData = new Object[rows][columns];

		for (int i = 0; i < testData.length; i++) // rows
			for (int j = 0; j < workSheet.getRow(i).getLastCellNum(); j++) // columns
				testData[i][j] = workSheet.getRow(i).getCell(j).toString();

		return testData;
	}

}