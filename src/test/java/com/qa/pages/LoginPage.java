package com.qa.pages;

import org.openqa.selenium.WebElement;

import com.qa.BaseTest;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BaseTest {
	
	  @AndroidFindBy(accessibility="test-Username") private WebElement userNameTxt;
	  @AndroidFindBy(accessibility="test-Password") private WebElement passwordTxt;
	  @AndroidFindBy(accessibility="test-LOGIN") private WebElement loginBtn;
	  @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView") 
	  private WebElement errTxt;
	  
	
public LoginPage enterUserName(String username) {
	sendKeys(userNameTxt, username);
	return this;
}

public LoginPage enterPassword(String password) {
	sendKeys(passwordTxt, password);
	return this;
}
	
public ProductPage pressLoginBtn() {
	click(loginBtn);
	return new ProductPage();
}

public String getErrTxt() {
	
	return getAttribute(errTxt, "text");
	
}public ProductPage Login(String user, String password) {
	    enterUserName(user);
	    enterPassword(password);
	    return pressLoginBtn();
	   
	
}

}
