package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase  {
	
  @Test
  public void testAddNew() throws Exception {
	app.openMainPage();
    app.initAddNew();
    ContactData parameterObject = new ContactData();
    parameterObject.name = "Роман";
    parameterObject.address = "Рижская 5";
	app.fillTheField(this, parameterObject);
    app.chooseGroup();
    app.saveContact();
    app.returnHomePage();
  }
  
  @Test
  public void testAddNewNull() throws Exception {
	app.openMainPage();
    app.initAddNew();
    ContactData parameterObject = new ContactData();
    app.fillTheField(this, parameterObject);
    app.chouseDayAndMounts();
    app.chooseGroup();
    app.saveContact();
    app.returnHomePage();
  }
}
