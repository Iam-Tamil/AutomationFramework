package com.Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static XSSFWorkbook Wbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static XSSFWorkbook openExcellFile(String filename) {
		try {
			Wbook = new XSSFWorkbook("./src/main/Excel File/"+filename+".xlsx");
		} catch (IOException e) {
			e.printStackTrace();
		}return Wbook;
	}

	public static XSSFSheet createNewSheet() {
		XSSFSheet createSheet = Wbook.createSheet();
		return createSheet;
	}

	public static XSSFSheet loadSheet(int index) {
		XSSFSheet sheetAt = Wbook.getSheetAt(index);
		return sheetAt;
	}

	public static XSSFSheet loadSheet(String name) {
		XSSFSheet sheet = Wbook.getSheet(name);
		return sheet;
	}
	
	public static XSSFRow setRow(int index) {
		XSSFRow row = sheet.getRow(index);
		return row;
	}
	
	public static XSSFCell setCell(int index) {
		XSSFCell cell = row.getCell(index);
		return cell;
	}

	public static int rowCount() {
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		return physicalNumberOfRows;
	}

	public static short columnCount(int index) {
		short lastCellNum = sheet.getRow(index).getLastCellNum();
		return lastCellNum;
	}

	public static String[][] readExcelData(int lastRow, short lastCell) {

		String[][] data = new String[lastRow][lastCell];

		for (int i = 1; i <= lastRow; i++) {
			row = setRow(i);
			for (int j = 0; j < lastCell; j++) {
				cell = setCell(j);
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
