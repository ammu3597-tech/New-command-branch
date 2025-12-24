package com.CRM.WebDiverGenericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public WebDriver driver;
	public void implicitwait(WebDriver driver,int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));	
	}
	public void Explicitwait(WebDriver driver,int time,WebElement ele) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));	
	wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void alert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
}
