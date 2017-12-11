package TravelP.TravelAgency;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp extends BrowserIni {
	public Properties prop= new Properties();
	public FileInputStream fis;
	Pageobject po=null;
	public  SignUp() throws IOException{
		
		fis= new FileInputStream("C:\\Users\\Rajesh_B\\workspace\\TravelAgency\\src\\main\\java\\TravelP\\TravelAgency\\data.properties");
//		prop= new Properties();
		prop.load(fis);
		
		
	}
	@BeforeTest
	public void getUrl() throws IOException, InterruptedException{
		driver =setBrowser();
		driver.get(prop.getProperty("url"));
		Thread.sleep(3000);		
	}
	@Test(priority=1)
	public void LunchSignupPage(){		
		//Click on Text  MY ACCount
		//driver.findElement(By.xpath("//div[@class='navbar']/div[2]/ul/ul/li[1]"));
		driver.findElement(By.partialLinkText("MY ACCOUNT")).click();
		
		//Select from Dropdown 
		//Select s= new Select(driver.findElement(By.xpath("//div[@class='navbar']/div[2]/ul/ul/li[1]/ul")));
		//s.selectByIndex(1);
		
		//Click on Signup option
		driver.findElement(By.xpath("//div[@class='navbar']/div[2]/ul/ul/li[1]/ul/li[2]/a")).click();
	}
	@Test(priority=2)
	//Submit the sign up button 
	public void BlankData() throws InterruptedException{
		// scroll up the page 
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("window.scrollBy(200,300)");
		
		//dont enter any data and click on Sign up page 
		driver.findElement(By.xpath("//div[@id='login']/form/div[9]/button")).click();
		Thread.sleep(2000);
		String ReadText=driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		Thread.sleep(2000);
		System.out.println(ReadText);
	}
	@Test(priority=3)
	public void xyz(){
		 po= new Pageobject(driver);
		po.myAccount();
	}
	
}
