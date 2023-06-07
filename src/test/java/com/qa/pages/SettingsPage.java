package com.qa.pages;
import org.openqa.selenium.WebElement;
import com.qa.BaseTest;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SettingsPage extends BaseTest{
	  @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\'test-LOGOUT\']")
	  private WebElement logoutBtn;
	  
public LoginPage PressLogoutBtn() {
		logoutBtn.click();
		return new LoginPage();
	
}
}