package com.qa;

import org.openqa.selenium.WebElement;


import com.qa.pages.SettingsPage;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuPage extends BaseTest{
	  @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
	  private WebElement settingsBtn;
	    
	public SettingsPage PressSettingsBtn() {
		settingsBtn.click();
		return new SettingsPage();
  
	}



}
