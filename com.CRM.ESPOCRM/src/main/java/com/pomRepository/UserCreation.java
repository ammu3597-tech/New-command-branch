package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserCreation {
   public WebDriver driver;

    public UserCreation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='nav-more-tabs-dropdown']")
    private WebElement MoreLink;
    
    @FindBy(xpath = "//span[text()='Organization']")
    private WebElement organizationMenu;

    @FindBy(xpath = "//span[text()='Users']")
    private WebElement usersLink;
    @FindBy(xpath = "//span[text()='Create User']")
    private WebElement CreateUserBtn;
    @FindBy(xpath = "//input[@data-name='userName']")
    private WebElement UserNameBtn;
    @FindBy(xpath="//div[contains(@class,'selectize-input')]")
	private WebElement selectbtn;
	@FindBy(xpath="//div[text()='Ms.']")
	private WebElement msbtn;
	@FindBy(xpath="//input[@data-name='firstName']")
	private WebElement firstbtn;
	@FindBy(xpath="//input[@data-name='lastName']")
	private WebElement lastbtn;
	@FindBy(xpath="/input[@data-name='isActive']")
	private WebElement activebtn;
	@FindBy(xpath="//button[text()='Save']")
	private WebElement savebtn;
	@FindBy(xpath="//div[@class='panels-show-more-delimiter']")
	private WebElement panels;
	@FindBy(xpath="(//button[@class='btn btn-default btn-sm dropdown-toggle'])[2]")
	private WebElement dropdown;
	@FindBy(xpath="//a[text()='Schedule Meeting']")
	private WebElement ScheduleMeeting;
	@FindBy(xpath="//input[@data-name='name']")
	private WebElement meetingName;
	@FindBy(xpath="(//button[text()='Save'])[2]")
	private WebElement save2btn;
	 

    public void goToUsers(String username,String firstname,String lastname ) {
    	Actions action=new Actions(driver);
    	action.scrollToElement(MoreLink).perform();
    	MoreLink.click();
        organizationMenu.click();
        usersLink.click();
        CreateUserBtn.click();
        UserNameBtn.sendKeys(username);
        selectbtn.click();
        msbtn.click();
        firstbtn.sendKeys(firstname);
        lastbtn.sendKeys(lastname);
        savebtn.click();
        panels.click();
        dropdown.click();
        ScheduleMeeting.click();
        meetingName.sendKeys("Your Meeting is scheduled");
        save2btn.click();
        
}
    }
