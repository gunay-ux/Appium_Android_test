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
import com.qa.pages.ProductDetailPage;
import com.qa.pages.ProductPage;
import com.qa.pages.SettingsPage;

import io.appium.java_client.InteractsWithApps;

public class ProductsTest extends BaseTest{
	
	LoginPage loginPage;
	ProductPage productPage;
	ProductDetailPage productDetailPage;
    SettingsPage settingsPage;
  
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
      System.out.println("\n"+ "***** starting productPage test:" + m.getName() + "*****" + "\n");
	  
  }

  @AfterMethod
  public void afterMethod() {
	 
  }
  
 
  @Test(priority=1)
  public void validateProductsonProductPage(Method m) throws InterruptedException {
	  
	 
	  productPage = loginPage.Login("standard_user", "secret_sauce");
	  String actSLBTitle = productPage.getSLBTitle();
	  System.out.println("validateProductsonProductPage" + actSLBTitle);
	  String expSLBTitle = "Sauce Labs Backpack";
	  Assert.assertEquals(actSLBTitle, expSLBTitle);
	  
	  String actSLBPrice = productPage.getSLBPrice();
	  System.out.println("validateProductsonProductPage" + actSLBPrice);
	  String expSLBPrice = "$29.99";
	  Assert.assertEquals(actSLBPrice, expSLBPrice);
	  
	  settingsPage = productPage.PressSettingsBtn();
	  Thread.sleep(3000);
	  loginPage = settingsPage.PressLogoutBtn();
	  Thread.sleep(5000);
	       
	 }
@Test(priority=2)  
public void validateProductsDetailonProductPage(Method m) throws InterruptedException {
	
	  productPage=loginPage.Login("standard_user", "secret_sauce");
	  Thread.sleep(3000);
	  productDetailPage = productPage.PressSLBTitle();
	  String actSLBTitle = productDetailPage.getSLBTitle();
	  System.out.println("validateProductsonProductPage" + actSLBTitle);
	  String expSLBTitle = "Sauce Labs Backpack";
	  Thread.sleep(3000);
	  Assert.assertEquals(actSLBTitle, expSLBTitle);
	  Thread.sleep(3000);
	  String actSLBTxt = productDetailPage.getSLBTxt();
	  String expSLBTxt = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
	  System.out.println("validateProductsonProductPage" + actSLBTxt);
	  Assert.assertEquals(actSLBTxt, expSLBTxt);
	  Thread.sleep(3000);
	  productDetailPage.scrollToElement();
	  Thread.sleep(3000);
	  String actSLBprice = productDetailPage.getSLBprice();
	  Thread.sleep(3000);
	  System.out.println("validateProductsonProductPage" + actSLBprice);
	  String expSLBPrice = "$29.99";
	  Assert.assertEquals(actSLBprice, expSLBPrice);
	  Thread.sleep(3000);
	  productPage = productDetailPage.PressBackToPrdoucts(); 
	  Thread.sleep(3000);
	  settingsPage = productPage.PressSettingsBtn();
	  Thread.sleep(2000);
	  loginPage = settingsPage.PressLogoutBtn();
	     
	 }
 

 
}
