package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.WebDiverGenericUtility.WebDriverUtility;

public class LeadsPage {
	WebDriver driver;
	WebDriverUtility wu=new WebDriverUtility();
	public LeadsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Leads']")
	private WebElement leadsbtn;
	@FindBy(xpath="//span[text()='Create Lead']")
	private WebElement createleadsbtn;
	@FindBy(xpath="//div[contains(@class,'selectize-input')]")
	private WebElement selectbtn;
	@FindBy(xpath="//div[text()='Ms.']")
	private WebElement msbtn;
	@FindBy(xpath="//input[@data-name='firstName']")
	private WebElement firstbtn;
	@FindBy(xpath="//input[@data-name='lastName']")
	private WebElement lastbtn;
	@FindBy(xpath="//button[text()='Save']")
	private WebElement savebtn;
	@FindBy(xpath="//span[text()='Convert']")
	private WebElement covertbtn;
	@FindBy(xpath="//span[text()='Opportunity']")
	private WebElement opportunitybtn;
	@FindBy(xpath="(//input[@data-name='name'])[2]")
	private WebElement opportunitytxn;
	@FindBy(xpath="//input[@data-name='amount']")
	private WebElement amounttxn;
	@FindBy(xpath="//button[text()='Convert']")
	private WebElement covert;
	@FindBy(xpath="//input[@data-name='textFilter']")
	private WebElement searchtx;
	@FindBy(xpath="//button[@data-action='search']")
	private WebElement searchbtn;
	@FindBy(xpath="//button[@class='btn btn-default btn-icon date-picker-btn']")
	private WebElement date;
	@FindBy(xpath="//td[@class='today day']")
	private WebElement today;
	@FindBy(xpath="//span[text()='Opportunities']")
	private WebElement Opportunities;
	
	public void createLead(String fristName,String lastName) {
		leadsbtn.click();
		createleadsbtn.click();
		selectbtn.click();
		msbtn.click();
		firstbtn.sendKeys(fristName);
		lastbtn.sendKeys(lastName);
		savebtn.click();
	}
	public void createLeadConvert(String fristName,String lastName,String OppoName) throws Throwable   {
		leadsbtn.click();
		createleadsbtn.click();
		selectbtn.click();
		msbtn.click();
		firstbtn.sendKeys(fristName);
		lastbtn.sendKeys(lastName);
		savebtn.click();
		covertbtn.click();
		wu.Explicitwait(driver, 10, opportunitybtn);
		opportunitybtn.click();
		wu.Explicitwait(driver, 10, opportunitytxn);
    	opportunitytxn.sendKeys(OppoName);
    	wu.Explicitwait(driver, 10, amounttxn);
    	amounttxn.sendKeys("0");
    	wu.Explicitwait(driver, 10, date);
		date.click();
		wu.Explicitwait(driver, 10, today);
		today.click();
		Actions action=new Actions(driver);
		action.scrollByAmount(0, 200);
		wu.Explicitwait(driver, 10, covert);
		covert.click();
		
		
	}
	public void verifyOpportunity(String opponame) {
	wu.Explicitwait(driver, 10, opportunitybtn);
	Opportunities.click();
	wu.Explicitwait(driver, 10, searchtx);
	searchtx.sendKeys(opponame);
	searchbtn.click();
}
}
