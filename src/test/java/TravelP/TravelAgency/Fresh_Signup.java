package TravelP.TravelAgency;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Fresh_Signup extends BrowserIni {
	
	WebDriver driver;
	Pageobject po=null;
	@Test(priority=1)
	public void signUp () throws IOException{
		driver= setBrowser();
		// Open the page through Link and 
		driver.get("http://www.phptravels.net/register");
		if (driver.findElement(By.xpath("//div[@class='panel-heading']")).isDisplayed()){
			System.out.println("Registration page opened successfully");
		}
		else
		{
			System.out.println("Component is not found");
		}
	}
	//Submit the data without entering any of the data
	@Test(priority=2)
	public void blankPage() throws InterruptedException{
		commonMethod cm =new commonMethod();
		cm.scrollUppage(driver);
		//click on the Submit button
		//WebElement Signup=driver.findElement(By.xpath("//div[@id='login']/form/div[9]/button"));
		//Signup.click(); 
		po.signup();
		
	}
	@Test(priority=3)
	public void numberOnly()
	{
		commonMethod cm =new commonMethod();
		cm.scrollDown(driver);
		po= new Pageobject(driver);
		po.firstName().sendKeys("1234");
		po.lastName().sendKeys("1234");
		po.mobile().sendKeys("1234");
		po.email().sendKeys("1234");
		po.password().sendKeys("1234");
		po.conPass().sendKeys("1234");
		cm.scrollUppage(driver);
		po.signup().click();
		
	}
	@Test(priority=4)
	public void CorrectData(){
		commonMethod cm =new commonMethod();
		cm.scrollDown(driver);
		po= new Pageobject(driver);
		po.firstName().sendKeys("Rajesh");
		po.lastName().sendKeys("Beg");
		po.mobile().sendKeys("9769824622");
		po.email().sendKeys("animeshsahu09@gmail.com");
		po.password().sendKeys("rajesh123");
		po.conPass().sendKeys("rajesh123");
		cm.scrollUppage(driver);
		po.signup().click();
	if (driver.findElement(By.xpath("//div[@class='resultlogin']/div")).toString().equals("Invalid Email or Password"))
	{
		System.out.println("Please enter the correct username and password");
	}
	else if(driver.findElement(By.xpath("//div[@id='body-section']/div/div[1]/div[1]/div[1]")).equals("")){
		
	}
	}
	@AfterTest
	public void closePage()
	{
		driver.quit();
	}


}
