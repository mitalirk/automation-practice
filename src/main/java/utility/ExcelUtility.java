package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
     public Workbook workbook;
     public void excelConnect(String file) {
    	 try {
    		 FileInputStream inputfile = new FileInputStream(file);
    		 if(file.endsWith(".xlsx"))
    			 workbook = new XSSFWorkbook(inputfile);
    		 else if(file.endsWith(".xls"))
    		     workbook = new HSSFWorkbook(inputfile);
    		  else 
    		    	 System.out.println("You have passed wrong file extn...");
    	 }
    	 catch (Exception e) {
			System.out.println(e);
		}
     }
     public int lastRowNum(String sheet) {
    	 return workbook.getSheet(sheet).getLastRowNum();
    }
     public String getCellData(String sheetName, int row, int cell) {
		return workbook.getSheet(sheetName).getRow(row).createCell(cell).toString();
     }
     public void setCellData(String SheetName, int row, int cell, String data) {
    	 workbook.getSheet(SheetName).getRow(row).createCell(cell).setCellValue(data);
     }
     public void writeExcel(String file) {
    	 try {
    		 FileOutputStream output =new FileOutputStream(file);
    		 workbook.write(output);
    	 }
    	 catch(Exception e) {
    	 }
     }
}
