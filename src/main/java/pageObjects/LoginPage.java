package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver)
	{
	 this.driver=driver;
	}
	
	//By signin=By.xpath("//a[@class='theme-btn register-btn']");
	By email=By.xpath("//input[@type='email']");
	By pass=By.xpath("//input[@type='password']");
	By submit=By.xpath("//input[@type='submit']");
	
	
	
	public WebElement emailid()
	{
		return driver.findElement(email);
		
	}
	
	public WebElement password()
	{
		return driver.findElement(pass);
		
	}
	
	public WebElement login()
	{
		return driver.findElement(submit);
		
	}
}
