package com.qa.pages;

import org.openqa.selenium.WebElement;

import com.qa.MenuPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductDetailPage extends MenuPage {
	
	 @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
     private WebElement SLBTitlet;
     @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]")
     private WebElement SLBTxt;
     @AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"test-Price\"]")
     private WebElement SLBPrice;
     @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]")
     private WebElement SLBAddToCard;
     @AndroidFindBy(accessibility="test-BACK TO PRODUCTS")
     private WebElement BackToPrdoucts;
     
public String getSLBTitle() {
	return getAttribute(SLBTitlet, "text");
	}
 	
public String getSLBTxt() {
	return getAttribute(SLBTxt, "text");
	}
 	
public String getSLBprice() {
	return getAttribute(SLBPrice, "text");
	}   


public ProductPage PressBackToPrdoucts() {
	BackToPrdoucts.click();
	return new ProductPage();
	}   

public WebElement scrollToElement() {
	return driver.findElement(AppiumBy.androidUIAutomator(
			"new UiScrollable("
					+ "new UiSelector().description(\"test-Inventory item page\")).scrollIntoView("                      
					+ "new UiSelector().description(\"test-Price\"));"));
	} 
}








