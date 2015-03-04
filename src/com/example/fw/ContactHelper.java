package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;
import com.example.tests.TestBase;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);

	}

	
	
	public void returnHomePage() {
		// return home page
	    manager.driver.findElement(By.linkText("home page")).click();
	}

	public void fillContactForm(ApplicationManager applicationManager, TestBase testBase, ContactData contact) {
		// fill the field
	   manager.driver.findElement(By.name("firstname")).clear();
	   manager.driver.findElement(By.name("firstname")).sendKeys(contact.name);
	   manager.driver.findElement(By.name("lastname")).clear();
	   manager.driver.findElement(By.name("lastname")).sendKeys(contact.lastname);
	   manager.driver.findElement(By.name("address")).clear();
	   manager.driver.findElement(By.name("address")).sendKeys(contact.address);
	   manager.driver.findElement(By.name("home")).clear();
	   manager.driver.findElement(By.name("home")).sendKeys(contact.home);
	   manager.driver.findElement(By.name("mobile")).clear();
	   manager.driver.findElement(By.name("mobile")).sendKeys(contact.mobile);
	   manager.driver.findElement(By.name("work")).clear();
	   manager.driver.findElement(By.name("work")).sendKeys(contact.work);
	   manager.driver.findElement(By.name("email")).clear();
	   manager.driver.findElement(By.name("email")).sendKeys(contact.email);
	    // this day and mounts
	    manager.driver.findElement(By.name("byear")).clear();
	    manager.driver.findElement(By.name("byear")).sendKeys(contact.byear);
	    // this choose group
	    manager.driver.findElement(By.name("address2")).clear();
	    manager.driver.findElement(By.name("address2")).sendKeys(contact.address2);
	    manager.driver.findElement(By.name("phone2")).clear();
	    manager.driver.findElement(By.name("phone2")).sendKeys(contact.phone2);
	}

	public void submitContactCreation() {
		// save contact
	    manager.driver.findElement(By.name("submit")).click();
	}


	public void initContactCreation() {
		// init add new
	    manager.driver.findElement(By.linkText("add new")).click();
	}

}
