package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import utility.BaseClass;

public class LoginPage extends BaseClass{
// By usernameField= By.xpath("//input[@id='authUser']");
// By passwordField= By.xpath("//input[@id='clearPass']");
 //By langDropDown= By.xpath("//select[@class='form-control']");
// By loginButton= By.xpath("//button[@id='login-button']");

 By usernameField= By.xpath("//label[text()='Username']/following-sibling::div/input");
 By passwordField= By.xpath("//form[@id='login_form']/descendant::input[@type='password']");
 By langDropDown= By.xpath("//form[@id='login_form']/descendant::select");
 By loginButton= By.xpath("//form[@id='login_form']/descendant::button");

 public void verifyLoginTitle() {
	 Assert.assertEquals(verifyTitle("OpenEMR Login"), true);
 }
 public void loginOpenEMR(String un, String pw, String lang) {
	 type(usernameField, un);
	 type(passwordField, pw);
	 type(langDropDown, lang);
	 click(loginButton);
 }
}