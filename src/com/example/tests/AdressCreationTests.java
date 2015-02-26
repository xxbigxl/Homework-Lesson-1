package com.example.tests;

import org.testng.annotations.Test;

public class AdressCreationTests extends TestBase  {
	
  @Test
  public void testAddNew() throws Exception {
	openMainPage();
    initAddNew();
    AddressData parameterObject = new AddressData();
    parameterObject.name = "Роман";
    parameterObject.address = "Рижская 5";
	fillTheField(parameterObject);
    chooseGroup();
    saveContact();
    returnHomePage();
  }
  
  @Test
  public void testAddNewNull() throws Exception {
	openMainPage();
    initAddNew();
    AddressData parameterObject = new AddressData();
    fillTheField(parameterObject);
    chouseDayAndMounts();
    chooseGroup();
    saveContact();
    returnHomePage();
  }
}
