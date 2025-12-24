package com.CRM.ESPOCRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.CRM.GenerlicUtility.PropretiesGenericUtility;
import com.CRM.WebDiverGenericUtility.WebDriverUtility;
import com.aventstack.extentreports.Status;
import com.pomRepository.Login;

public class BaseClass {
	public  WebDriver driver;
	public static WebDriver sdriver;
	public PropretiesGenericUtility ps=new PropretiesGenericUtility();
	public WebDriverUtility wb=new WebDriverUtility();

	@BeforeClass
	public void configBC() throws Throwable {
		System.out.println("Executed Before Class");
	String Browser=	ps.getTheDataFromProperties("browser");
	if(Browser.equals("chrome")) {
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 
		driver=new ChromeDriver(options);
	}else {
		driver=new FirefoxDriver();
	}
	wb.implicitwait(driver, 50);
 sdriver=driver;
	}
	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("Executed Before class");
		String userName=ps.getTheDataFromProperties("Username");
		String passWord=ps.getTheDataFromProperties("Password");
		String url=ps.getTheDataFromProperties("URL");
		driver.get(url);
		driver.manage().window().maximize();
		Login lg=new Login(driver);
		lg.login(userName, passWord);
	}
	@AfterMethod
	public void configAM() {
		System.out.println("Executed After method");
	Login lg=new Login(driver);
		lg.logout();
	}
  @AfterClass
  public void configAC() {
	  System.out.println("Executed After class");
	  driver.close();
  }
}
