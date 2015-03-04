package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase  {
	
  @Test
  public void testAddNew() throws Exception {
	app.navigationHelper.openMainPage();
    app.contactHelper.initContactCreation();
    ContactData parameterObject = new ContactData();
    parameterObject.name = "Роман";
    parameterObject.address = "Рижская 5";
	app.contactHelper.fillContactForm(app, this, parameterObject);
    app.chooseGroup();
    app.contactHelper.submitContactCreation();
    app.contactHelper.returnHomePage();
  }
  
  @Test
  public void testAddNewNull() throws Exception {
	app.navigationHelper.openMainPage();
    app.contactHelper.submitContactCreation();
    ContactData parameterObject = new ContactData();
    app.contactHelper.fillContactForm(app, this, parameterObject);
    app.chouseDayAndMounts();
    app.chooseGroup();
    app.contactHelper.submitContactCreation();
    app.contactHelper.returnHomePage();
  }
}
