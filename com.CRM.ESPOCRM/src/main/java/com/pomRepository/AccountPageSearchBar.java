package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.WebDiverGenericUtility.WebDriverUtility;

public class AccountPageSearchBar {
	WebDriver driver;
	WebDriverUtility wu=new WebDriverUtility();
    public AccountPageSearchBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   

    @FindBy(xpath = "//span[text()='Accounts']")
    private WebElement accountsBtn;

    @FindBy(xpath = "//span[text()='Create Account']")
    private WebElement createAccountBtn;

    @FindBy(xpath = "//input[@data-name='name']")
    private WebElement accountNameTxt;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveBtn;
    
    @FindBy(xpath = "//input[@data-name='textFilter']")
    private WebElement searchfieldTxt;

    @FindBy(xpath = "//button[@data-action='search']")
    private WebElement searchTxt;

    public void createAccountAndSearch(String accountName) throws InterruptedException {
    	 accountsBtn.click();
        createAccountBtn.click(); 
        accountNameTxt.sendKeys(accountName);
        wu.Explicitwait(driver, 10, saveBtn);
        saveBtn.click();
     wu.Explicitwait(driver, 10, accountsBtn);
      
        accountsBtn.click();
        wu.Explicitwait(driver, 10, searchfieldTxt);
    	 searchfieldTxt.sendKeys(accountName);
    	 searchTxt.click();
    }
    public void createAccount(String accountName) throws InterruptedException {
   	 accountsBtn.click();
       createAccountBtn.click();
       accountNameTxt.sendKeys(accountName);
       saveBtn.click();
   }
}
