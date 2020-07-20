package Fremeworks;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

//import org.testng.annotations.Test;

public class HomePage extends base {
	
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void intialize() throws IOException
	{
				
	}
	
	
	@Test(dataProvider="getdata")
	public void HOmePageNavigation(String username, String password, String user ) throws IOException, InterruptedException {
		
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("navigated to home page");
		//driver.findElement(By.xpath("[//a[@class='theme-btn register-btn']")).click();
		LandingPage ln=new LandingPage(driver);
		Thread.sleep(3000L);
		ln.getlogin().click();
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(3000L);
		lp.emailid().sendKeys(username);
		lp.password().sendKeys(password);
		System.out.println(user);
		lp.login().click();
				
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data=new Object[2][3];
		data[0][0]="harshita.jain.sweetz@gmail.com";
		data[0][1]="harshita@9";
		data[0][2]="non-restricted user";
		
		data[1][0]="abc@gmail.com";
		data[1][1]="12345";
		data[1][2]="restricted user";
		
		return data;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
