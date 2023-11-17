package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ExcelDemo {

	public static void main(String[] args) throws Exception {
		ExcelUtility excelUtility = new ExcelUtility();
		excelUtility.excelConnect("C:\\Users\\prashant thakare\\Desktop");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.openemr.io/b/openemr/interface/login/login.php?site=default");
        for(int i=1;i<= excelUtility.lastRowNum("Sheet1");i++)
        {
          driver.findElement(By.xpath("//label[text()='Username']/following-sibling::div/input")).sendKeys("admin");
   		  driver.findElement(By.xpath("//label[text()='Password']/following-sibling::div/input")).sendKeys("pass");
   		  new Select(driver.findElement(By.xpath("//form[@id='login_form']/descendant::select "))).selectByVisibleText("English (Indian)");
   		  driver.findElement(By.xpath("//form[@id='login_form']/descendant::button")).click();
   		  try {
   			 Actions action = new Actions(driver);
   			 action.moveToElement(driver.findElement(By.xpath("div[@title='Current user']"))).build().perform();
   			 action.moveToElement(driver.findElement(By.xpath("div[@title='Current user']/descendang::li[contains(text().'Logout')]"))).build().perform();
   			 excelUtility.setCellData("Sheet1", i, 2, "Pass");   		  
   		  }
   		  catch(Exception e) {
   			excelUtility.setCellData("Sheet1", i, 2, "Fail");
   		  }
   		  Thread.sleep(3000);
   		  }
        excelUtility.writeExcel("C:\\Users\\prashant thakare\\Desktop\\ExcelPract\\program.xlsx");
        driver.quit();
        }
}


