package Fremeworks;

import java.io.IOException;

//import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

//import org.testng.annotations.Test;

public class validateTitle extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void intialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialised");
		driver.get(prop.getProperty("url"));
		log.info("navigated to home page");
		
	}
	
	@Test
	public void validatetitleapp( ) throws IOException {
		//driver=initializeDriver();
		//driver.get(prop.getProperty("url"));
		//driver.findElement(By.xpath("[//a[@class='theme-btn register-btn']")).click();
		LandingPage ln=new LandingPage(driver);
		
		Assert.assertEquals(ln.gettitle().getText(), "Featured Courses123");
		log.info("successfully validated text message");
				
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	

}
