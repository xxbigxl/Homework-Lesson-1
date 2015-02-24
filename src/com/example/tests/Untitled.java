package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Untitled {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void addNew() throws Exception {
	openMainPage();
    initAddNew();
    FillTheFieldParameter parameterObject = new FillTheFieldParameter();
    parameterObject.name = "Роман";
	fillTheField(parameterObject);
    chooseGroup();
    saveContact();
    returnHomePage();
  }
  
  @Test
  public void addNewNull() throws Exception {
	openMainPage();
    initAddNew();
    fillTheField(new FillTheFieldParameter("", "", "", "", "", "", "", "", "", ""));
    chouseDayAndMounts();
    chooseGroup();
    saveContact();
    returnHomePage();
  }

private void chouseDayAndMounts() {
	// choose day  and mounts 
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText("12");
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("December");
}
  

private void returnHomePage() {
	// return home page
    driver.findElement(By.linkText("home page")).click();
}

private void chooseGroup() {
	// choose group
    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("Family");
}

private void saveContact() {
	// save contact
    driver.findElement(By.name("submit")).click();
}

private void fillTheField(FillTheFieldParameter parameterObject) {
	// fill the field
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys(parameterObject.name);
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys(parameterObject.lastname);
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys(parameterObject.address);
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys(parameterObject.home);
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys(parameterObject.mobile);
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys(parameterObject.work);
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(parameterObject.email);
    // this day and mounts
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys(parameterObject.byear);
    // this choose group
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys(parameterObject.address2);
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys(parameterObject.phone2);
}

private void initAddNew() {
	// init add new
    driver.findElement(By.linkText("add new")).click();
}

private void openMainPage() {
	// open main page
    driver.get(baseUrl + "/addressbookv4.1.4/group.php");
}

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
