package com.glen.demo;

import java.io.File;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class ContactManager
{
	 private  AndroidDriver  driver;
	 
	    @BeforeMethod(alwaysRun=true)
	    public void setUp() throws Exception {
	        // set up appium
	        File classpathRoot = new File(System.getProperty("user.dir"));
	        File appDir = new File(classpathRoot, "apps");
	        File app = new File(appDir, "ContactManager.apk");
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	        capabilities.setCapability("platformName", "Android");
	        capabilities.setCapability("deviceName","192.168.56.101:5555");
	        capabilities.setCapability("platformVersion", "4.4.4");
	        capabilities.setCapability("app", app.getAbsolutePath());
	        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
	        capabilities.setCapability("appActivity", ".ContactManager");
	        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    }
	 
	   
	 
	    @Test(groups={"addContact"})
	    public void addContact(){
	        WebElement el = driver.findElement(By.name("Add Contact"));
	        el.click();
	        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
	        textFieldsList.get(0).sendKeys("Some Name");
	        textFieldsList.get(1).sendKeys("10086");
	        textFieldsList.get(2).sendKeys("Some@example.com");
	        driver.swipe(100, 500, 100, 100, 2);
	        driver.findElementByName("Save").click();
	    }
	    @AfterMethod(alwaysRun=true)
	    public void tearDown() throws Exception {
	        driver.quit();
	    }
}
