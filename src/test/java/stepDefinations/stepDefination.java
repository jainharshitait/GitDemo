

package stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalhomepage;
import resources.base;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class stepDefination  extends base{
	
	public WebDriver driver;

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	driver=initializeDriver();
    }

 

    @Then("^verify that user is successfuly logged in$")
    public void verify_that_user_is_successfuly_logged_in() throws Throwable {
        portalhomepage p=new portalhomepage(driver);
        Assert.assertTrue(p.searchquery().isDisplayed());
        
    }

   /* @When("^User login into application with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_login_into_application_with_something_and_something(String username, String password) throws Throwable {
    	System.out.println(username);
    	System.out.println(password);
    	LoginPage lp=new LoginPage(driver);
		Thread.sleep(3000L);
		lp.emailid().sendKeys(username);
		lp.password().sendKeys(password);
        //System.out.println(user);
		lp.login().click();
    }*/
    
    @When("^User login into application with (.+) and (.+) $")
    public void user_login_into_application_with_and(String username, String password) throws Throwable {
    	System.out.println(username);
    	System.out.println(password);
    	LoginPage lp=new LoginPage(driver);
		Thread.sleep(3000L);
		lp.emailid().sendKeys(username);
		lp.password().sendKeys(password);
        //System.out.println(user);
		lp.login().click();
    }

    @And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }

    
    /*@When("^User login into application with \"(.*)\" and \"(.*)\" $")
    public void user_login_into_application_with_and(String username, String password) throws Throwable {
    	LoginPage lp=new LoginPage(driver);
		Thread.sleep(3000L);
		lp.emailid().sendKeys(username);
		lp.password().sendKeys(password);
        //System.out.println(user);
		lp.login().click();
    }*/
    
    
    @And("^click on login link in home page to land on secure sign in page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
    	LandingPage ln=new LandingPage(driver);
    	ln.getlogin().click();
    }
    	
    	/*@When("^User login into application with harshita\\.jain\\.sweetz@gmail\\.com and harshita@(\\d+)$")
    	public void user_login_into_application_with_harshita_jain_sweetz_gmail_com_and_harshita(int arg1) throws Throwable {
    	    // Write code here that turns the phrase above into concrete actions
    	    
    	}*/
    	
    

}