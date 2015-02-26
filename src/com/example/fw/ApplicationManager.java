package com.example.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class ApplicationManager {

	public void returnToGroupsPage() {
	    TestBase.driver.findElement(By.linkText("group page")).click();
	}

	public void submitGroupCreation() {
	    TestBase.driver.findElement(By.name("submit")).click();
	}

	public void initGroupCreation() {
	    TestBase.driver.findElement(By.name("new")).click();
	}

	public void gotoGroupsPage() {
	    TestBase.driver.findElement(By.linkText("groups")).click();
	}

	public void fillGroupForm(TestBase testBase, GroupData group) {
		TestBase.driver.findElement(By.name("group_name")).clear();
	    TestBase.driver.findElement(By.name("group_name")).sendKeys(group.name);
	    TestBase.driver.findElement(By.name("group_header")).clear();
	    TestBase.driver.findElement(By.name("group_header")).sendKeys(group.header);
	    TestBase.driver.findElement(By.name("group_footer")).clear();
	    TestBase.driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	public void chouseDayAndMounts() {
		// choose day  and mounts 
	    new Select(TestBase.driver.findElement(By.name("bday"))).selectByVisibleText("12");
	    new Select(TestBase.driver.findElement(By.name("bmonth"))).selectByVisibleText("December");
	}

	public void returnHomePage() {
		// return home page
	    TestBase.driver.findElement(By.linkText("home page")).click();
	}

	public void chooseGroup() {
		// choose group
	    new Select(TestBase.driver.findElement(By.name("new_group"))).selectByVisibleText("Family");
	}

	public void saveContact() {
		// save contact
	    TestBase.driver.findElement(By.name("submit")).click();
	}

	public void fillTheField(TestBase testBase, ContactData parameterObject) {
		// fill the field
	    TestBase.driver.findElement(By.name("firstname")).clear();
	    TestBase.driver.findElement(By.name("firstname")).sendKeys(parameterObject.name);
	    TestBase.driver.findElement(By.name("lastname")).clear();
	    TestBase.driver.findElement(By.name("lastname")).sendKeys(parameterObject.lastname);
	    TestBase.driver.findElement(By.name("address")).clear();
	    TestBase.driver.findElement(By.name("address")).sendKeys(parameterObject.address);
	    TestBase.driver.findElement(By.name("home")).clear();
	    TestBase.driver.findElement(By.name("home")).sendKeys(parameterObject.home);
	    TestBase.driver.findElement(By.name("mobile")).clear();
	    TestBase.driver.findElement(By.name("mobile")).sendKeys(parameterObject.mobile);
	    TestBase.driver.findElement(By.name("work")).clear();
	    TestBase.driver.findElement(By.name("work")).sendKeys(parameterObject.work);
	    TestBase.driver.findElement(By.name("email")).clear();
	    TestBase.driver.findElement(By.name("email")).sendKeys(parameterObject.email);
	    // this day and mounts
	    TestBase.driver.findElement(By.name("byear")).clear();
	    TestBase.driver.findElement(By.name("byear")).sendKeys(parameterObject.byear);
	    // this choose group
	    TestBase.driver.findElement(By.name("address2")).clear();
	    TestBase.driver.findElement(By.name("address2")).sendKeys(parameterObject.address2);
	    TestBase.driver.findElement(By.name("phone2")).clear();
	    TestBase.driver.findElement(By.name("phone2")).sendKeys(parameterObject.phone2);
	}

	public void initAddNew() {
		// init add new
	    TestBase.driver.findElement(By.linkText("add new")).click();
	}

	public void openMainPage() {
		// open main page
	    TestBase.driver.get(TestBase.baseUrl + "/addressbookv4.1.4/group.php");
	}

	public boolean isElementPresent(By by) {
	    try {
	      TestBase.driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public boolean isAlertPresent() {
	    try {
	      TestBase.driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = TestBase.driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (TestBase.acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      TestBase.acceptNextAlert = true;
	    }
	  }

}
