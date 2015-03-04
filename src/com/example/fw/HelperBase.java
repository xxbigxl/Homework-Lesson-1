package com.example.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public abstract class HelperBase {

	protected ApplicationManager manager;

	public HelperBase(ApplicationManager manager){
		this.manager = manager;
	}
	
	public boolean isElementPresent(By by) {
	    try {
	    	manager.driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	
	public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = manager.driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (manager.acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	    	manager.acceptNextAlert = true;
	    }
	}
}
