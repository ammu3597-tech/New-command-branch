package com.CRM.GenerlicUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String readTheDataFromExcelUtility(String sheetName,int row,int cel) throws Throwable, Throwable {
		FileInputStream fis=new FileInputStream("./Config Data/ESPOTestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(row).getCell(cel).toString();
		return data;
	}

}
