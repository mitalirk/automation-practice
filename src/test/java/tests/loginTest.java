package tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testBase.TestSetup;
import utility.BaseClass;
import utility.ExcelUtility;

public class loginTest extends TestSetup{
	BaseClass base = new BaseClass();
	ExcelUtility excel =new ExcelUtility();
	LoginPage lp = new LoginPage();
	HomePage hp = new HomePage();
  @Test
  public void login() {
	  
	 /* LoginPage lp = new LoginPage();
	  HomePage hp= new HomePage();*/
	  try
	  {
		  for(int i=1; i<=excel.lastRowNum("Sheet1"); i++)
		  {
			 lp.verifyLoginTitle();
			 //lp.loginOpenEMR("admin", "pass", "English (Indian)");
			 lp.loginOpenEMR(excel.getCellData("Sheet1",i, 0), excel.getCellData("Sheet1, i, 1), "English(Indian)");
			 base.sleep();
			 	//hp.verifyHomePageTitle();
			 //	hp.logoutOpenEMR();
			 //	base.sleep();
			 	//lp.verifyLoginTitle();
			 try {
				 hp.logoutOpenEMR();
				 excel.setCellData("Sheet1", i, 2, "Correct Data");
				 base.sleep();
				 lp.verifyLoginTitle();
			 }catch(Exception e) {
				 excel.setCellData("Sheet1", i, 2, "Wrong Data");
			 }
		  }
	  }      catch(Exception e) {
			 	CaptureScreenshot("C:\\Users\\prashant thakare\\Desktop\\ExcelPract\\program.xlsx");
	  }
  }
	//  @BeforeClass
	 // public void beforeClass() {
	//	  openBrowser("chrome");
	//	  openUrl("https://demo.openemr.io/b/openemr/interface/login/login.php?site=default");
	//  }
	 // @AfterClass
	 // public void afterClass() {
	//	  closeBrowser();
	 // }
  public void LoginCheck(String un, String pw)
  {
	  System.out.println(un+""+pw);
  }
  }

