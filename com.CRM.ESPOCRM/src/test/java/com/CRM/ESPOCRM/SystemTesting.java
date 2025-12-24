package com.CRM.ESPOCRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.CRM.GenerlicUtility.ExcelUtility;
import com.CRM.WebDiverGenericUtility.JavaUtility;
import com.aventstack.extentreports.Status;
import com.pomRepository.AccountPageSearchBar;
import com.pomRepository.ContactPage;
import com.pomRepository.Systemscenorio1;
import com.pomRepository.Systemscenorio2;
import com.pomRepository.UserCreation;


@Listeners(Listener.class)
public class SystemTesting extends BaseClass{
	
 ExcelUtility ex=new ExcelUtility();
	JavaUtility jv=new JavaUtility();
	@Test
public void oranizationWorkFlowTest() throws Throwable {
	int random=jv.getRandomNum();
	String firstname=ex.readTheDataFromExcelUtility("Leads", 1, 1);
	String lastname=ex.readTheDataFromExcelUtility("Leads", 1, 2)+random;
	String username=ex.readTheDataFromExcelUtility("username", 1, 1)+random;
	
	UserCreation uc=new UserCreation(driver);
	uc.goToUsers(username, firstname, lastname);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement ele=driver.findElement(By.xpath("//span[contains(text(),'"+username+"')]"));
    WebElement name = wait.until(ExpectedConditions.visibilityOf(ele));
    String data=name.getText();
   boolean status = data.contains(username);
	Assert.assertTrue(status);
	UtilityClassObject.getTest().log(Status.INFO,"oranizationWorkFlowTest Executed");
}
	@Test
	public void leadToOpporunityworkFlowTest() throws Throwable {
		int random=jv.getRandomNum();
		String firstname=ex.readTheDataFromExcelUtility("Leads", 1, 1);
		String lastname=ex.readTheDataFromExcelUtility("Leads", 1, 2)+random;
		String accountName=ex.readTheDataFromExcelUtility("Account", 2, 1)+random;
		String Opponame=ex.readTheDataFromExcelUtility("Opportinity", 1, 1)+random;
		Systemscenorio1 sc=new Systemscenorio1(driver);
		sc.leadtoDealerClosert(firstname, lastname, accountName, Opponame);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele=driver.findElement(By.xpath("//a[contains(text(),'"+accountName+"')]"));
	    WebElement name = wait.until(ExpectedConditions.visibilityOf(ele));
		String data=name.getText();
		System.out.println(data);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele1=driver.findElement(By.xpath("//a[contains(text(),'"+Opponame+"')]"));
	    WebElement name1 = wait1.until(ExpectedConditions.visibilityOf(ele1));
		String data1=name1.getText();
		System.out.println(data1);
		Assert.assertTrue(data1.contains(Opponame));
		UtilityClassObject.getTest().log(Status.INFO,"leadTodealOpporunity Executed");
		
	}
	@Test
	public void AccountToLostcloserTest() throws Throwable {
		int random=jv.getRandomNum();
		String Opponame=ex.readTheDataFromExcelUtility("Opportinity", 1, 1)+random;
		Systemscenorio2 sc=new Systemscenorio2(driver);
		sc.OpportunityLost(Opponame);	
		Assert.assertTrue(driver.getPageSource().contains("Lost"));
    UtilityClassObject.getTest().log(Status.INFO,"AccountTodealclose Executed");
	}
	
}
