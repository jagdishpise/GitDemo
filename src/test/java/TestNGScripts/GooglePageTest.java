package TestNGScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class GooglePageTest 
//{
 // @Test
 // public void SearchTest() {
	//  System.setProperty("webdriver.chrome.driver","D:\\selenium\\webdrivers\\chromedriver_win32\\chromedriver.exe");
	//	WebDriver driver = new ChromeDriver();
	//	driver.get("http://www.google.com");
	//	System.out.println("Page Title : " + driver.getTitle());
	//	System.out.println("Current URL : " + driver.getCurrentUrl());
 //}
//}
{
WebDriver driver;
@BeforeTest
public void setup() {
       System.setProperty("webdriver.chrome.driver", "D:\\selenium\\webdrivers\\chromedriver_win32\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       driver.manage().window().maximize();
}
       
@Test
      public void seleniumTest() {
       
              driver.get("https://www.google.com");
              WebElement searchBox= driver.findElement(By.name("q"));
              searchBox.sendKeys("selenium");
              searchBox.submit();
              Assert.assertEquals("selenium - Google Search",driver.getTitle());
}

 @Test
      public void cypressTest() {
             driver.get("https://www.google.com");
             WebElement searchBox= driver.findElement(By.name("q"));
              searchBox.sendKeys("cypress");
              searchBox.submit();
              Assert.assertEquals("cypress - Google Search", driver.getTitle());
}
@Test
      public void javaTest() {
       driver.get("https://www.google.com");
             WebElement searchBox= driver.findElement(By.name("q"));
              searchBox.sendKeys("java");
              searchBox.submit();
              Assert.assertEquals("java - Google Search", driver.getTitle());
              
       }

      
}
