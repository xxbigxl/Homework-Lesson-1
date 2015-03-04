package com.example.fw;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ApplicationManager {
	
	
	public WebDriver driver;
	public String baseUrl;
	public boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	public NavigationHelper navigationHelper;
	public GroupHelper groupHelper;
	public ContactHelper contactHelper;
	
	public ApplicationManager(){
		driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	public void stop() {	
		driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	}
	
	public void chouseDayAndMounts() {
		// choose day  and mounts 
	    new Select(driver.findElement(By.name("bday"))).selectByVisibleText("12");
	    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("December");
	}

	public void chooseGroup() {
		// choose group
	    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("Family");
	}

	public boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }
	

}
