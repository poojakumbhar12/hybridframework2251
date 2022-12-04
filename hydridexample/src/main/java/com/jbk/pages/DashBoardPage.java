package com.jbk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	public WebDriver driver;
@FindBy(xpath="//h1")
public WebElement heading;
@FindBy(xpath="//span[text()='Users']")
WebElement userbt;


public DashBoardPage(WebDriver driver){
driver=this.driver;
	PageFactory.initElements(driver, this);
	
	
}
public Userpage clickuser(){
	userbt.click();
	
	return new Userpage(driver);
	
}
public boolean checkHeading(){
	String actHeading= heading.getText();
	System.out.println(actHeading);
           String expectedHead="Dashboard Courses Offered";
          

if(actHeading.equalsIgnoreCase(expectedHead)){
	System.out.println("heading match");
	return true;
}else{
	System.out.println("heading not match ");
}
return false;
}

}
