package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver)
	{
	 this.driver=driver;
	}
	
	private By signin=By.cssSelector(".theme-btn.register-btn");
	private By t=By.xpath("//h2[text()='Featured Courses']");
	private By n=By.xpath("//div[@class='nav-outer clearfix']");
	//By declaring variables as private and making accessible methods as public we are actually hiding data implementation and achieving data encapsulation
	
	//achieving encapsulation
	private By d=By.cssSelector(".fa.fa-lock.fa-lg");
	
	
	public WebElement getlogin()
	{
		return driver.findElement(signin);
		
	}
	
	public WebElement login()
	{
		return driver.findElement(d);
		
	}
	
	
	public WebElement gettitle()
	{
		return driver.findElement(t);
		
	}
	
	public WebElement navbar()
	{
		return driver.findElement(n);
		
	}
	
	

}
