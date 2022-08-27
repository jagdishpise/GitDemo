package junitTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;


public class LoginSteps {
	
	WebDriver driver;
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\webdrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/casestudyselenium/Casestudy_HotelBooking/login.html");
		driver.manage().window().maximize();
	}
	
	@When("^heading of page is hotel booking application$")
	public void heading_of_page_is_hotel_booking_application() {
		String heading=driver.findElement(By.xpath("//h1[contains(text(),'Hotel Booking Application')]")).getText();
		Assert.assertEquals("Hotel Booking Application", heading);
		
	}
	
	@When("^user enter username$")
	public void user_enter_username() {
		driver.findElement(By.name("userName")).sendKeys("admin");
		
		
	}

	@Then("^user enter password$")
	public void user_enter_password() {
		driver.findElement(By.name("userPwd")).sendKeys("admin");
		
	}

	@Then("^click on login button$")
	public void click_on_login_button()  {
		driver.findElement(By.className("btn")).click();
	//	driver.close();
	}
	
	@Then("^title of page is hotel booking$")
	public void title_of_page_is_hotel_booking() {
		String actualTitle= driver.getTitle();
		String expectedTitle= "Hotel Booking";
		Assert.assertEquals(expectedTitle, actualTitle);
		
	}
	
	@Given("^user is on hotel booking form$")
	public void user_is_on_hotel_booking_form() {
		
	}

	
	@Then("^fill the form$")
	public void fill_the_form() {
		driver.findElement(By.id("txtFirstName")).sendKeys("Jagdish");
		driver.findElement(By.id("txtLastName")).sendKeys("Pise");
		driver.findElement(By.id("txtEmail")).sendKeys("jagdishpise007@gmail.com");
		driver.findElement(By.id("txtPhone")).sendKeys("9130329229");
		
		WebElement element= driver.findElement(By.name("city"));
		Select sel = new Select(element);
		sel.selectByVisibleText("Pune");
		
		WebElement el= driver.findElement(By.name("state"));
		Select st = new Select(el);
		st.selectByVisibleText("Maharashtra");
		
		driver.findElement(By.name("persons")).sendKeys("2");
		
		driver.findElement(By.id("txtCardholderName")).sendKeys("Jagdish Pise");
		driver.findElement(By.id("txtDebit")).sendKeys("4591150393388939");
		driver.findElement(By.name("cvv")).sendKeys("082");
		driver.findElement(By.name("month")).sendKeys("July");
		driver.findElement(By.name("year")).sendKeys("2022");
		
		
	}

	@Then("^click on confirm booking button$")
	public void click_on_confirm_booking_button() {
		driver.findElement(By.className("btn")).click();
	//	driver.close();
	}
	
	@Then("^user see the booking completed message$")
	public void user_see_the_booking_completed_message() {
		String actualTitle= driver.getTitle();
		String expectedTitle= "Payment Details";
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();
	}
	

}
