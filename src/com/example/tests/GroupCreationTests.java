package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	  openMainPage();
      gotoGroupsPage();
      initGroupCreation();
      GroupData group = new GroupData("Family", "Address", "Family Address");
	  fillGroupForm(group);
      submitGroupCreation();
      returnToGroupsPage();
  }
  
 
  @Test
  public void testEmptyGroupCreation() throws Exception {
	  openMainPage();
      gotoGroupsPage();
      initGroupCreation();
      fillGroupForm(new GroupData("", "", ""));
      submitGroupCreation();
      returnToGroupsPage();
  }

  
}
