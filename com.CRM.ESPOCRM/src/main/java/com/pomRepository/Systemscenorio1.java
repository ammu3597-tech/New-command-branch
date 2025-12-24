package com.pomRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CRM.WebDiverGenericUtility.WebDriverUtility;

public class Systemscenorio1 {
	public WebDriver driver;
WebDriverUtility wu=new WebDriverUtility();
    public Systemscenorio1(WebDriver driver) {
        this.driver = driver;
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
	@FindBy(xpath="//div[text()='Converted']")
	private WebElement convertedbtn;
	@FindBy(xpath="(//i[@class='fas fa-angle-up'])[3]")
	private WebElement acountbtn;
	@FindBy(xpath="//span[text()='Create']")
	private WebElement createbtn;
	@FindBy(xpath="//input[@data-name='name']")
	private WebElement accountNamebtn;
	
	
	@FindBy(xpath="(//i[@class='fas fa-angle-up'])[5]")
	private WebElement opportunitybtn;
	@FindBy(xpath="//input[@data-name='name']")
	private WebElement opponamebtn;
	@FindBy(xpath="//input[@data-name='closeDate']")
	private WebElement closebtn;
	@FindBy(xpath="//td[@class='today day']")
	private WebElement today;
	@FindBy(xpath="//input[@data-name='amount']")
	private WebElement amount;
	@FindBy(xpath="//button[text()='Save']")
	private WebElement savebtn;
	@FindBy(xpath="(//button[text()='Save'])[2]")
	private WebElement savebtn1;
	 @FindBy(xpath = "//button[@data-action='search']")
    private WebElement searchTxt;
	@FindBy(xpath="//span[text()='Create']")
	private WebElement create2btn;
	
    
	public void leadtoDealerClosert(String firstName,String lastName,String accountName,String oppoName) {
    leadsbtn.click();
	createleadsbtn.click();
	selectbtn.click();
	msbtn.click();
	firstbtn.sendKeys(firstName);
	lastbtn.sendKeys(lastName);
	Actions action=new Actions(driver);
	action.scrollByAmount(0, 300).perform();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	WebElement StatusBtn = wait.until(
	    ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[contains(@class,'selectize-input')])[3]")));

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView({block:'center'});", StatusBtn);
	js.executeScript("arguments[0].click();", StatusBtn);

	convertedbtn.click();
	
	    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
	    WebElement acountbtn = wait2.until(
	    	    ExpectedConditions.presenceOfElementLocated(
	    	        By.xpath("(//i[@class='fas fa-angle-up'])[3]")));
	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView({block:'center'});", acountbtn);
		js1.executeScript("arguments[0].click();", acountbtn);
	createbtn.click();
	accountNamebtn.sendKeys(accountName);
	wu.Explicitwait(driver, 0, savebtn1);
	savebtn1.click();
	
	 WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(15));
	    WebElement oppbtn = wait3.until(
	    	    ExpectedConditions.presenceOfElementLocated(
	    	        By.xpath("(//i[@class='fas fa-angle-up'])[5]")));
	    JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView({block:'center'});", oppbtn);
		js2.executeScript("arguments[0].click();", oppbtn);
	
	wu.Explicitwait(driver, 0, create2btn);
	create2btn.click();
	wu.Explicitwait(driver, 0, opponamebtn);
	opponamebtn.sendKeys(oppoName);
	closebtn.click();
	today.click();
	amount.sendKeys("0");
	savebtn1.click();
	savebtn.click();
	}
	
	
}