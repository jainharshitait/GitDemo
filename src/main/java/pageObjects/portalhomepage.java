package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalhomepage {
	public WebDriver driver;

	public portalhomepage(WebDriver driver)
	{
	 this.driver=driver;
	}
	
	//By signin=By.xpath("//a[@class='theme-btn register-btn']");
	By sb=By.id("hcaptcha_submit");
	
	
	
	
	public WebElement searchquery()
	{
		return driver.findElement(sb);
		
	}
	

}
