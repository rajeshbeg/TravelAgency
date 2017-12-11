package TravelP.TravelAgency;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pageobject {
	WebDriver driver;
	
	public Pageobject(WebDriver driver) {
		this.driver=driver;
	}
	//for registration page
	By MyAccount=By.cssSelector("//a[class='dropdown-toggle go-text-right']");
	By Signup=By.xpath("//div[@id='login']/form/div[9]/button");
	By Firstname =By.xpath("//input[@name='firstname']");
	By LastName =By.xpath("//input[@name='lastname']");
	By Mobile =By.xpath("//input[@name='phone']");
	By Email= By.xpath("//input[@name='email']");
	By Password = By.xpath("//input[@name='password']");
	By ConPass= By.xpath("//input[@name='confirmpassword']");
	//For log in page 
	By Username=By.xpath("//input[@type='email']");
	By Loginpassword=By.xpath("//div[@class='panel-body']/div[2]/input");
	By Loginsubmit= By.xpath("//button[@type='submit']");
	
	
	public WebElement myAccount()
	{
		return driver.findElement(MyAccount);
		
	}
	public WebElement signup()
	{
		return driver.findElement(Signup);
		
	}
	public WebElement firstName()
	{
		return driver.findElement(Firstname);
		
	}
	public WebElement lastName()
	{
		return driver.findElement(LastName);
		
	}
	public WebElement mobile()
	{
		return driver.findElement(Mobile);
		
	}
	public WebElement email()
	{
		return driver.findElement(Email);
		
	}
	public WebElement password()
	{
		return driver.findElement(Password);
		
	}
	public WebElement conPass()
	{
		return driver.findElement(ConPass);	
	}
	public WebElement username()
	{
		return driver.findElement(Username);	
	}
	public WebElement loginpassword()
	{
		return driver.findElement(Loginpassword);	
	}
	public WebElement loginsubmit()
	{
		return driver.findElement(Loginsubmit);	
	}
	

}
