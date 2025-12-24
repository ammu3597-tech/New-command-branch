package com.pomRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='#Contact']")
    private WebElement contactsModule;

    @FindBy(xpath = "//span[text()='Create Contact']")
    private WebElement createContactBtn;

    @FindBy(xpath = "//input[@data-name='firstName']")
    private WebElement firstNameTxt;

    @FindBy(xpath = "//input[@data-name='lastName']")
    private WebElement lastNameTxt;

    @FindBy(xpath="//div[contains(@class,'selectize-input')]")
	private WebElement selectbtn;
    
	@FindBy(xpath="//div[text()='Ms.']")
	private WebElement msbtn;
    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveBtn;
    @FindBy(xpath = "//span[@class=\"fas fa-angle-up\"]")
    private WebElement accountLinkBtn;
    @FindBy(xpath = "//input[@data-name='textFilter']")
    private WebElement searchBtn;
    @FindBy(xpath = "//input[@class='select-all form-checkbox form-checkbox-small']")
    private WebElement searchlinkBtn;
    @FindBy(xpath = "//a[@class='link']")
    private WebElement selectaccount;
    @FindBy(xpath = "//i[@class='fas fa-plus icon']")
    private WebElement plusbtn;
    @FindBy(xpath = "//a[text()='Opportunity']")
    private WebElement Opportunitybtn;
    @FindBy(xpath = "//input[@autocomplete='espo-name']")
    private WebElement Opportunityname;
    @FindBy(xpath = "//input[@data-name='closeDate']")
    private WebElement closedate;
    @FindBy(xpath = "//td[@class='today day']")
    private WebElement todayBtn;
    @FindBy(xpath = "//input[@data-name='amount']")
    private WebElement amountBtn;
    @FindBy(xpath = "//a[@id='nav-more-tabs-dropdown']")
    private WebElement MoreLink;
    @FindBy(xpath = "//span[text()='Sales & Purchases']")
    private WebElement salesAndPurchasesLink;
    @FindBy(xpath = "//span[text()='Quotes']")
    private WebElement quotesLink;
    @FindBy(xpath = "//span[text()='Create Quote']")
    private WebElement createQuote;
    @FindBy(xpath = "(//i[@class=\"fas fa-angle-up\"])[2]")
    private WebElement Oppolink;
    @FindBy(xpath = "//input[@data-name='textFilter']")
    private WebElement searchbtn;
    @FindBy(xpath = "//a[@href='#Opportunity/view/6948f0bb050b5aefb']")
    private WebElement selectop;

    public void createContactWithAccount(String firstName, String lastName, String accountName) {
    	contactsModule.click();
        createContactBtn.click();
        selectbtn.click();
        msbtn.click();
        firstNameTxt.sendKeys(firstName);
        lastNameTxt.sendKeys(lastName);
        accountLinkBtn.click();
        searchBtn.sendKeys(accountName);
       searchlinkBtn.click();
       selectaccount.click();
       saveBtn.click();
    }
}

