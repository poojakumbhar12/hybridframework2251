package com.jbk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass{

	
	@FindBy(id="email")
 WebElement email;
	
	@FindBy(xpath="//input[@id=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//button")
	public WebElement button;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String uname,String pass){
		email.sendKeys(uname);
		password.sendKeys(pass);
		button.click();
	}
	public DashBoardPage correctCrediatinal(){
		email.sendKeys("kiran@gmail.com");
		password.sendKeys("123456");
		button.click();
		return new DashBoardPage(driver);
	}
	
	
}