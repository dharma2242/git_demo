package com.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtility {
	//create a method that can be read the data from excel sheet
	// generic class should be created
	
	public static FileInputStream fileLocation;
	public static XSSFWorkbook wBook;
	public static XSSFSheet wSheet;
	public static XSSFRow row;
	public static XSSFCell Cell;
	
	// method is get the row count
	public static int getRowCount(String exFile , String exSheet) throws IOException 
	{
		
		fileLocation = new FileInputStream(exFile);
		wBook = new XSSFWorkbook(fileLocation);
		wSheet = wBook.getSheet(exSheet);
		int rowCount = wSheet.getLastRowNum();
		return rowCount;
		
	}
	
	
	public static int getCellCount(String exFile , String exSheet , int rowNum) throws IOException {
		fileLocation = new FileInputStream(exFile);
		wBook = new XSSFWorkbook(fileLocation);
		wSheet = wBook.getSheet(exSheet);
		row = wSheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		return cellCount;
		
	}
	
	
	
	public static String getCellData(String exFile , String exSheet , int rowNum , int colNum) throws IOException
	{
	fileLocation = new FileInputStream(exFile);
	wBook = new XSSFWorkbook(fileLocation);
	wSheet = wBook.getSheet(exSheet);
	row = wSheet.getRow(rowNum);
	Cell= row.getCell(colNum);
	
	DataFormatter formater = new DataFormatter();
	
	String cellData=formater.formatCellValue(Cell);
	
	fileLocation.close();
	wBook.close();
	return cellData;
	

	}
}
