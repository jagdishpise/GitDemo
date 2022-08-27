package TestNGScripts;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import bsh.ParseException;
import jdk.nashorn.internal.parser.JSONParser;

public class DataParam {
	
		WebDriver driver;
		@BeforeTest
		public void setup() {
		       System.setProperty("webdriver.chrome.driver", "D:\\selenium\\webdrivers\\chromedriver_win32\\chromedriver.exe");
		       driver = new ChromeDriver();
		       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		       driver.manage().window().maximize();
		
   }
		
		@Test(dataProvider="loginData")
		public void loginTest(String uname, String pwd) {
			driver.get("https://the-internet.herokuapp.com/login");
			driver.findElement(By.id("username")).sendKeys(uname);
			driver.findElement(By.id("password")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		}
		
		//@DataProvider(name="loginData")
	//	public Object [][] getData(){
		//	return new Object[][] {
			//	new Object[] {"admin","admin"},
				//new Object[] {"admin1","admin1"},
				//new Object[] {"tomsmith","SuperSecretPassword!"}
		//	};
			
		//}
//		@DataProvider(name="loginData")
//		public Object [][] getData() throws IOException { 
//			String path = System.getProperty("use.dir") + "//testData//loginData.csv";
//			System.out.println("File Path :" +path);
//			CSVReader reader = new CSVReader(new FileReader(path));
//			String[] col;
//			ArrayList<Object[]> datalist = new ArrayList<Object[]> ();
//			while((col=reader.readNext())!=null) {
//				Object[] record = {col[0], col[1]};
//				
//				datalist.add(record);
				
//			}
//			reader.close();
//			return datalist.toArray(new Object[datalist.size()][]);
//		}
		
		//using .json file
		@DataProvider(name="loginData")
		public String[][] getData() throws IOException, ParseException {
			JSONParser jsonParser = new JSONParser();
			FileReader file = new FileReader(System.getProperty("use.dir") + "//testData//loginData.csv");
			Object obj = jsonParser.parse();
			JsonObject userJsonObj = (JSONObject) obj;
			JsonArray userLoginsArray = (JSONArray)userJsonObj.get("userlogins");
			String arr [][] = new String[userLoginsArray.size()][];
			for(int i=0;i<userLoginsArray.size();i++) {
				JSONObject users = (JSONObject) userLoginsArray.get(i);
				
			}
			
		}
		@AfterTest
		public void tearDown() {
			//driver.close();
		}
}
