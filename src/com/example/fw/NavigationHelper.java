package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public void gotoGroupsPage() {
	    manager.driver.findElement(By.linkText("groups")).click();
	}

	public void openMainPage() {
		// open main page
	    manager.driver.get(manager.baseUrl + "/addressbookv4.1.4/group.php");
	}

	

	
}