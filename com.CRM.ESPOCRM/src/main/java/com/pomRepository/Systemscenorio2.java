package com.pomRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CRM.WebDiverGenericUtility.WebDriverUtility;

public class Systemscenorio2 {
	public WebDriver driver;
	WebDriverUtility wu=new WebDriverUtility();
	    public Systemscenorio2(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(xpath="//span[text()='Opportunities']")
		private WebElement OpportunitiesBtn;
	    @FindBy(xpath="//span[text()='Create Opportunity']")
		private WebElement createOppoBtn;
	    @FindBy(xpath="//input[@data-name='name']")
		private WebElement nameBtn;
	    @FindBy(xpath="//input[@data-name='amount']")
		private WebElement amountBtn;
	    @FindBy(xpath="//input[@data-name='closeDate']")
		private WebElement closeBtn;
	    @FindBy(xpath="//td[@class='today day']")
		private WebElement todayBtn;
	   
	    @FindBy(xpath="//div[text()='Closed Lost']")
	 		private WebElement closedlostBtn;
	    
	    @FindBy(xpath="//button[text()='Save']")
		private WebElement saveBtn;
	    @FindBy(xpath="//span[text()='Closed Lost']")
		private WebElement verifyBtn;
		
	    public void OpportunityLost(String oppName) {
	    	OpportunitiesBtn.click();
	    	createOppoBtn.click();
	    	nameBtn.sendKeys(oppName,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);
	    	closedlostBtn.click();
	    	wu.Explicitwait(driver, 0, amountBtn);
	    	amountBtn.sendKeys("0");
	    	
	    	closeBtn.click();
	    	todayBtn.click();
	    	
	    	saveBtn.click();
	    	verifyBtn.getText();
	 
	        
	    }
	       

}
