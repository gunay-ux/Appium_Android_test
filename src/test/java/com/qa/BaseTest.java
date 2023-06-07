package com.qa;


import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;

import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class BaseTest {
	protected static AppiumDriver driver;
	protected static Properties props;
	InputStream inputStream;
	
 
  public BaseTest(){
	  
	  PageFactory.initElements(new AppiumFieldDecorator(driver), this );
  }
  
  @BeforeTest
 
  public void beforeTest() throws Exception {
	  try {
		props = new Properties();  
		String proFileName ="config.properties";
	    inputStream = getClass().getClassLoader().getResourceAsStream(proFileName);
	    props.load(inputStream);
	    
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Any device name" );
        caps.setCapability("automationName", props.getProperty("androidAutomationName"));
        caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
        caps.setCapability("appActivity", props.getProperty("androidAppActivity") );
        URL appUrl = getClass().getClassLoader().getResource(props.getProperty("androidAppLocation"));
        caps.setCapability("app", appUrl);
        //caps.setCapability("Avd", "pixel_5");
        //caps.setCapability("newCommandTimeout", 300);
        URL url = new URL(props.getProperty("appiumURL"));
        driver = new AndroidDriver(url, caps);
        System.out.println("sessionID:"+driver.getSessionId());
        //Thread.sleep(3000);
	     
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
  }
  public void waitForVisibility(WebElement e) {
	 
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT) );
	  wait.until(ExpectedConditions.visibilityOf(e));
}
  public void click(WebElement e) {
	  waitForVisibility(e);
	  e.click();
  }
  
  public void sendKeys(WebElement e, String txt) {
	  waitForVisibility(e);
	  e.sendKeys(txt);
  }
  
  public String getAttribute(WebElement e, String attribute) {
	  waitForVisibility(e);
	 return e.getAttribute(attribute);
	 
  }
 
  public void closeApp() {
	  
	  ((InteractsWithApps) driver).terminateApp(props.getProperty("androidAppPackage"));
	 
  }
  
public void launchApp() {
	  
	  ((InteractsWithApps) driver).activateApp(props.getProperty("androidAppPackage"));
	 
  }
  

@AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
