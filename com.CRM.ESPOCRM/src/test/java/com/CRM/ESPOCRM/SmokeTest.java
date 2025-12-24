package com.CRM.ESPOCRM;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.CRM.GenerlicUtility.ExcelUtility;
import com.CRM.WebDiverGenericUtility.JavaUtility;
import com.CRM.WebDiverGenericUtility.WebDriverUtility;
import com.aventstack.extentreports.Status;
import com.pomRepository.AccountPageSearchBar;
import com.pomRepository.LeadsPage;
import com.pomRepository.SalesPurchasesQuotesPage;
@Listeners(Listener.class)
public class SmokeTest extends BaseClass{
	ExcelUtility ex=new ExcelUtility();
	JavaUtility jv=new JavaUtility();

	
@Test
public void createLeadTest() throws Throwable {
	System.out.println("Test executed");
	int random=jv.getRandomNum();
	String firstname=ex.readTheDataFromExcelUtility("Leads", 1, 1);
	String lastname=ex.readTheDataFromExcelUtility("Leads", 1, 2)+random;
	LeadsPage lp=new LeadsPage(driver);
	lp.createLead(firstname, lastname);
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement ele=driver.findElement(By.xpath("//span[contains(text(),'"+lastname+"')]"));
    WebElement leadName = wait.until(ExpectedConditions.visibilityOf(ele));
	String data=leadName.getText();
	boolean status = data.contains(lastname);
	Assert.assertTrue(status);
	UtilityClassObject.getTest().log(Status.INFO,"createLeadTest Executed");
	
}
@Test
public void createAccountAndSearchTest() throws Throwable {
	int random=jv.getRandomNum();
	String accountName=ex.readTheDataFromExcelUtility("Account", 1, 1)+random;
AccountPageSearchBar ap = new AccountPageSearchBar(driver);
    ap.createAccountAndSearch(accountName);
  String actualAccountName = driver.findElement(By.xpath("//a[contains(text(),'" + accountName + "')]")).getText();
 Assert.assertTrue(actualAccountName.contains(accountName));
 UtilityClassObject.getTest().log(Status.INFO,"createAccountAndSearchTest Executed");
}
@Test
public void quotesEditTest() {
	SalesPurchasesQuotesPage quote=new SalesPurchasesQuotesPage(driver);
	quote.navigateToQuotes();
	UtilityClassObject.getTest().log(Status.INFO,"quotesEditTest Executed");
	Assert.assertTrue(driver.getCurrentUrl().contains("Quote"));
}
}
