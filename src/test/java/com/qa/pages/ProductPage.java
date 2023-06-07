package com.qa.pages;

import org.openqa.selenium.WebElement;

import com.qa.MenuPage;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductPage extends MenuPage {
	
      @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
      private WebElement productTxt;
      @AndroidFindBy(xpath="(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]")
      private WebElement SLBtitle;
      @AndroidFindBy(xpath="(//android.widget.TextView[@content-desc=\"test-Price\"])[1]")
      private WebElement SLBprice;
      
public String getTitle() {
	return getAttribute(productTxt, "text");
	
}
public String getSLBTitle() {
	return getAttribute(SLBtitle, "text");
	
}
public String getSLBPrice() {
	return getAttribute(SLBprice, "text");
	
}

public ProductDetailPage PressSLBTitle(){
	SLBtitle.click();
	return new ProductDetailPage();
	
}

}
