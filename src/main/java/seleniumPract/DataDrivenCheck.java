package seleniumPract;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenCheck {

	public static void main(String[] args) throws Exception {
	   FileInputStream file = new FileInputStream("C:\\Users\\prashant thakare\\Desktop\\ExcelPract\\program.xlsx");
       XSSFWorkbook workbook = new XSSFWorkbook(file); 
       XSSFSheet sheet = workbook.getSheet("Sheet1");
       XSSFCell un,pw;
       for(int i=1; i<=sheet.getLastRowNum(); i++) {
    	   un = sheet.getRow(i).getCell(0);
    	   pw = sheet.getRow(i).getCell(1);
    	   System.out.println("Username = "+un);
    	   System.out.println("Password = "+pw);
       }
	}

}
