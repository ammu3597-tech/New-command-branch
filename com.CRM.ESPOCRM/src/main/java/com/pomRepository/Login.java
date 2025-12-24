package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.GenerlicUtility.PropretiesGenericUtility;


public class Login {
	WebDriver driver;
	public PropretiesGenericUtility ps=new PropretiesGenericUtility();
	   public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//input[@name='username']")
	private WebElement usernametx;
	@FindBy(xpath ="//input[@name='password']")
	private WebElement passwordtx;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginbtn;
	@FindBy(xpath ="//a[@title='Menu']")
	private WebElement menubtn;
	@FindBy(xpath ="//a[text()='Log Out']")
	private WebElement logoutbtn;
	
	public void login(String userName,String password) throws Throwable {
	
		usernametx.sendKeys(userName);
		passwordtx.sendKeys(password);
     	loginbtn.click();
	}
	public void logout() {
		menubtn.click();
		Actions action=new Actions(driver);
		action.moveToElement(logoutbtn).click().perform();
		
	}
}