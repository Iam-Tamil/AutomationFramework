package com.Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static XSSFWorkbook Wbook = null;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFRow cell;

	public static void setExcellFile(String filename) {
		Wbook = null;
		try {
			Wbook = new XSSFWorkbook("./Excel File/"+filename+".xlsx");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static XSSFSheet createSheet() {
		return Wbook.createSheet();
	}

	public static XSSFSheet setSheet(int index) {
		return Wbook.getSheetAt(index);
	}

	public static XSSFSheet setSheet(String name) {
		return Wbook.getSheet(name);
	}

	public static int setLastRowNum() {
		return sheet.getLastRowNum();
	}

	public static int setPhysicalNumberOfRows() {
		return sheet.getPhysicalNumberOfRows();
	}

	public static short setLastCellNum() {
		return sheet.getRow(0).getLastCellNum();
	}

	public static String[][] readExcelData(int lastRow, short lastCell) {

		String[][] data = new String[lastRow][lastCell];

		for (int i = 1; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastCell; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft = new DataFormatter();
				String Value = dft.formatCellValue(cell);
				data[i-1][j] = Value;      
			}
		}
		return data;
	}

	public static void closeExcelFile() {
		try {
			Wbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
