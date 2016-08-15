package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import repository.Config;

public class Xcel {
	
	public String xlPath=Config.excelPath+Config.excelName;	
	public String TestNumber,fieldNumber,cellvalue,value="";
	int lastRowNum,lastColNum,value1,rowNum,colNum;
	
	public Workbook fileIp() throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream	fs = new FileInputStream(xlPath);
		Workbook w = WorkbookFactory.create(fs);
		return w;
	}	
	//getLastRow(String,String)
	public int getLastRow(String xlPath,String TestSheetName) throws EncryptedDocumentException, InvalidFormatException, IOException {
		try {
		    Sheet s1=fileIp().getSheet(TestSheetName);
		    value1 = s1.getLastRowNum();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value1;
	}		
	//getCellData(String,String,int,int)
	public String getCellData(String xlPath,String TestsheetName, int row, int cell) throws EncryptedDocumentException, InvalidFormatException, IOException {
		try {				
			Sheet s=fileIp().getSheet(TestsheetName);
			value = s.getRow(row).getCell(cell).toString();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return value;
	}
	//getcellData(String,String)
	public String getCellData(String TestNum,String ColName) throws EncryptedDocumentException, InvalidFormatException, IOException {
		//lastRowNumber, lastColumnNumber
		lastRowNum=fileIp().getSheet("TestCases").getLastRowNum();		
		lastColNum=fileIp().getSheet("TestCases").getRow(0).getLastCellNum();		
		//return cell value 
		for (int j=1;j<=lastRowNum;j++) {
			TestNumber=fileIp().getSheet("TestCases").getRow(j).getCell(0).toString();			
			if(TestNumber.equalsIgnoreCase(TestNum)) {
				rowNum=j;					
				break; 
			}
		}	
		for (int k=1;k<=lastColNum;k++) {
			fieldNumber=fileIp().getSheet("TestCases").getRow(0).getCell(k).toString();			
			if(fieldNumber.equalsIgnoreCase(ColName)) {
				colNum=k;				
				break;
			}
		}		
		cellvalue = fileIp().getSheet("TestCases").getRow(rowNum).getCell(colNum).toString();		
		return cellvalue;
	}
	//getCellData(String,String,String)
	public String getCellData(String TestSheet,String TestNum,String ColName) throws EncryptedDocumentException, InvalidFormatException, IOException {
		//lastRowNumber, lastColumnNumber
		lastRowNum=fileIp().getSheet(TestSheet).getLastRowNum();		
		lastColNum=fileIp().getSheet(TestSheet).getRow(0).getLastCellNum();		
		//return cell value 
		for (int j=1;j<=lastRowNum;j++) {
			TestNumber=fileIp().getSheet(TestSheet).getRow(j).getCell(0).toString();			
			if(TestNumber.equalsIgnoreCase(TestNum)) {
				rowNum=j;					
				break; 
			}
		}	
		for (int k=1;k<=lastColNum;k++) {
			fieldNumber=fileIp().getSheet(TestSheet).getRow(0).getCell(k).toString();			
			if(fieldNumber.equalsIgnoreCase(ColName)) {
				colNum=k;				
				break;
			}
		}		
		cellvalue = fileIp().getSheet(TestSheet).getRow(rowNum).getCell(colNum).toString();		
		return cellvalue;
	}
}
