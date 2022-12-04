package com.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utils.PropertyUtils;

import net.bytebuddy.agent.builder.AgentBuilder.Identified.Extendable;

public class BaseClass {
	
public static WebDriver driver =null;

public static ExtentReports report=null;
public static ExtentSparkReporter spark=null;
public static ExtentTest test =null;


public static Logger log= Logger.getLogger(BaseClass.class);
public static void initialization() throws Exception{
	System.out.println("reading propery file for browser name ");
	log.info("reading propery file for browser name ");
	String browsername=PropertyUtils.readProperty("browser");
	if(browsername.equals("chrome")){
		log.info("intialising chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	
	if(browsername.equals("firebox")){
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.get(PropertyUtils.readProperty("url"));
}

public void reportInit(){
	report=new ExtentReports();
	String path=System.getProperty("user.dir")+"/target/ExtentReport.html";
	spark=new ExtentSparkReporter(path);
	report.attachReporter(spark);
}
}
