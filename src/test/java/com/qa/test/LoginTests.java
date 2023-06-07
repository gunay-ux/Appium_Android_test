package com.qa.test;

import java.lang.reflect.Method;

//import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

//import io.appium.java_client.AppiumBy;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductPage;

public class LoginTests extends BaseTest{
	
	LoginPage loginPage;
	ProductPage productPage;
	
  
  
  @BeforeClass
  public void beforeClass() {
	  closeApp();
	  launchApp();
	  
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeMethod
  public void beforeMethod(Method m) {
	  loginPage = new LoginPage();
	  System.out.println("\n"+ "***** starting test:" + m.getName() + "*****" + "\n");
	  
  }

  @AfterMethod
  public void afterMethod() {
	 
  }
  
  
  @Test
  public void invalidUserName() {
	
	  
	  loginPage.enterUserName("invalidusername");
	  loginPage.enterPassword("secret_sauce");
	  loginPage.pressLoginBtn();
      String actError = loginPage.getErrTxt();
	  String expError="Username and password do not match any user in this service.";
	  Assert.assertEquals(actError, expError);
	
	  
  }
  
   @Test
  public void invalidPassword(){
	  
	  loginPage.enterUserName("standard_user");
	  loginPage.enterPassword("invalidPassword");
	  loginPage.pressLoginBtn();
	  String actError = loginPage.getErrTxt();
	  String expError="Username and password do not match any user in this service.";
	  Assert.assertEquals(actError, expError);

;  }
  

  @Test
  public void successfullyLogin() {
	  
	  
      loginPage.enterUserName("standard_user");
	  loginPage.enterPassword("secret_sauce");
	  productPage =loginPage.pressLoginBtn();
	  String actTitle = productPage.getTitle();
	  String expTitle="PRODUCTS";
	  Assert.assertEquals(actTitle, expTitle);
	     
     
	 }
 

 
}
