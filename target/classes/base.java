package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		//it is not good practice that we hard code are source path because diff m/c will having diff system path so for that we use system.getproperty("user.dir")
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		//mvn test -Dbrowser=Chrome
		//String browsername=prop.getProperty("browser");
		System.out.println(browsername);
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedrive\\chromedriver.exe");	
			//ChromeOptions option=new ChromeOptions();
			//option.addArguments("headless");  //headless mode chrome browser will not be invoked
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("hello");
		}
		else if(browsername=="firefox")
		{
			
		}
		else
		{
			//ie
		}
		
		
		return driver;
	}
	public String getScreenshot(String testcasename, WebDriver driver) throws IOException
	{
		System.out.println(System.getProperty("user.dir"));
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String k=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		FileUtils.copyFile(src, new File(k));
		return k;
		
				
		
	}

}
