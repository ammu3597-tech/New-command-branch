package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesPurchasesQuotesPage {

	    WebDriver driver;

	    public SalesPurchasesQuotesPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(xpath = "//a[@id='nav-more-tabs-dropdown']")
	    private WebElement MoreLink;
	    @FindBy(xpath = "//span[text()='Sales & Purchases']")
	    private WebElement salesAndPurchasesLink;
	    @FindBy(xpath = "//span[text()='Quotes']")
	    private WebElement quotesLink;
	    @FindBy(xpath = "//a[text()='Q-00041']")
	    private WebElement particularQT;
	     @FindBy(xpath = "//button[text()='Edit']")
	    private WebElement editButton;
	     @FindBy(xpath = "//span[text()='Sales Orders']")
		    private WebElement salesBtn;
	     @FindBy(xpath = "//span[text()='Create Sales Order']")
		    private WebElement createsalesBtn;
	     @FindBy(xpath = "//button[@data-action='selectLink']")
		    private WebElement quotationBtn;
	     @FindBy(xpath = "//a[text()='Q-00041']")
		    private WebElement quotation;
	     @FindBy(xpath = "//button[text()='Save']")
		    private WebElement savebtn;
	    
	    public void navigateToQuotes() {
	    	Actions action=new Actions(driver);
	    	action.scrollToElement(MoreLink).perform();
	    	MoreLink.click();
	        salesAndPurchasesLink.click();
	        action.moveToElement(quotesLink).perform();
	        quotesLink.click();
	        particularQT.click();
	        editButton.click();
	    }
	    public void salesToQuote() {
	    	Actions action=new Actions(driver);
	    	action.scrollToElement(MoreLink).perform();
	    	MoreLink.click();
	        salesAndPurchasesLink.click();
	        salesBtn.click();
	        createsalesBtn.click();;
	        quotationBtn.click();
	        quotation.click();
	        savebtn.click();
	    	
	    }
		
}
