package TestNGScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import CommonUtils.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DemoPageTest {
	
	ExtentTest extentTest;
	ExtentReports reports;
	ExtentHtmlReporter htmlReport;
	WebDriver driver;
	
  @BeforeTest
  public void setupExtent() {
	  reports = new ExtentReports();
	  htmlReport = new ExtentHtmlReporter("D:\\screenshots\\ExtReport.html");
	  reports.attachReporter(htmlReport);
	  htmlReport.setAppendExisting(true);
  }
  @BeforeMethod
  public void setup () {
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\webdrivers\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
  }
  
  @Test
  public void searchPhone() {
	  extentTest = reports.createTest("Testing Search Phone");
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\webdrivers\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
	  driver.get("http://demo.opencart.com/");
      driver.findElement(By.name("search")).sendKeys("Phone");
      WebElement btn = driver.findElement(By.className("input-group-btn"));
      btn.click();
      Assert.assertEquals(driver.getTitle(), "Search - Phone");
  }
  
  @Test
  public void searchDesktop() {
	  extentTest = reports.createTest("Testing Search Desktop");
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\webdrivers\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
     // driver.manage().deleteAllCookies();
      driver.get("http://demo.opencart.com/");
      driver.findElement(By.name("search")).sendKeys("Desktop");
      WebElement btn = driver.findElement(By.className("input-group-btn"));
      btn.click();
      Assert.assertEquals(driver.getTitle(), "Search - Deskto");
      
      
	  
  }
  @AfterMethod
  public void teardown(ITestResult result) throws IOException {
	  if(ITestResult.FAILURE == result.getStatus()) {
		  extentTest.fail(result.getName());
		 // String screenshotPath = Utility.getScreenshot(driver);
		  //extentTest.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		  
	  }
	  driver.close();
	  
  }
  @AfterTest
  public void finishTest() {
	  reports.flush();
  }
}
