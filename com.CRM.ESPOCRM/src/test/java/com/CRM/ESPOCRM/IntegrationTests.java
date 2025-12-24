package com.CRM.ESPOCRM;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import com.pomRepository.LeadsPage;
import com.pomRepository.SalesPurchasesQuotesPage;

@Listeners(Listener.class)
public class IntegrationTests extends BaseClass {
	ExcelUtility ex=new ExcelUtility();
	JavaUtility jv=new JavaUtility();
	@Test
	public void AccountToLeadTest() throws Throwable {
		int random=jv.getRandomNum();
		String accountName=ex.readTheDataFromExcelUtility("Account", 2, 1)+random;
		String firstName=ex.readTheDataFromExcelUtility("Contacts", 1, 1);
		String lasName=ex.readTheDataFromExcelUtility("Contacts", 1, 2)+random;
		AccountPageSearchBar account=new AccountPageSearchBar(driver);
		account.createAccount(accountName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele=driver.findElement(By.xpath("//span[contains(text(),'"+accountName+"')]"));
	    WebElement name = wait.until(ExpectedConditions.visibilityOf(ele));
		String data=name.getText();
		ContactPage cp=new ContactPage(driver);
		cp.createContactWithAccount(firstName, lasName, data);
		boolean status = data.contains(accountName);
		Assert.assertTrue(status);
		UtilityClassObject.getTest().log(Status.INFO,"AccountToLeadTest Executed");
	}
	@Test
	public void leadToOpportunityTest() throws Throwable {
		int random=jv.getRandomNum();
		String firstname=ex.readTheDataFromExcelUtility("Leads", 1, 1);
		String lastname=ex.readTheDataFromExcelUtility("Leads", 1, 2)+random;
		String Opponame=ex.readTheDataFromExcelUtility("Opportinity", 1, 1);
		LeadsPage lp=new LeadsPage(driver);
		lp.createLeadConvert(firstname, lastname, Opponame);
		System.out.println("Test Pass");
		WebElement ele=driver.findElement(By.xpath("//span[@data-panel='history']"));
		Actions action=new Actions(driver);
		action.moveToElement(ele).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele1=driver.findElement(By.xpath("//a[contains(text(),'"+Opponame+"')]"));
	    WebElement name = wait.until(ExpectedConditions.visibilityOf(ele1));
		String data=name.getText();
		System.out.println(data);
		lp.verifyOpportunity(data);
		Assert.assertTrue(data.contains(Opponame));
		UtilityClassObject.getTest().log(Status.INFO,"leadToOpportunityTest Executed");
	}
	
@Test
public void salesToQuotationTest() {
	SalesPurchasesQuotesPage sp=new SalesPurchasesQuotesPage(driver);
	sp.salesToQuote();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement ele=driver.findElement(By.xpath("//a[text()='Q-00041']"));
    WebElement name = wait.until(ExpectedConditions.visibilityOf(ele));
	String data=name.getText();
	System.out.println(data);
	Assert.assertTrue(data.startsWith("Q-"));
    UtilityClassObject.getTest().log(Status.INFO,"salesToQuotationTest Executed");
	
}
}
