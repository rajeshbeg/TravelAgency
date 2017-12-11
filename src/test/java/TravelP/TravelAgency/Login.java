package TravelP.TravelAgency;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTestInterruptedException;
import com.relevantcodes.extentreports.LogStatus;

public class Login extends BrowserIni
{
	public Properties pro= null;
	WebDriver driver;
	Pageobject po=null;
	private static Logger log = LogManager.getLogger(Login.class.getName());
	commonMethod cm =null;
	public ExtentReports extent;
	public ExtentTest test;
	
	@Test(priority=1,enabled=true)
	public void logiIN() throws IOException
	{
		extent = new ExtentReports("C:\\Users\\Rajesh_B\\workspace\\TravelAgency\\Reports\\TestResult.html", true);
		driver= setBrowser();
		po= new Pageobject(driver);
		//System.out.println("login the page");
		//open login page 
		
		// Test name
		test=extent.startTest("Browser's launch is launched");
		
             driver.get("http://www.phptravels.net/login");
             log.info("Object is present ");
             log.error("Object is not present");
           //Url is open successfully 
             test.log(LogStatus.PASS,"Browser open successfully");
             
            
	}
	@Test(priority=2, enabled=true)
	public void blankdata() throws InterruptedException
	{
		// click on submit button without entering any data
		test=extent.startTest("blank data Test");
		po.loginsubmit().click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Successfully clicked on blank data");
		System.out.println( driver.findElement(By.xpath("//div[@class='alert alert-danger']")).toString());
		
//		if (driver.findElement(By.xpath("//div[@class='resultlogin']/div")).toString().equals("Invalid Email or Password"))
//		{
//			System.out.println("please enter the username and password ");
//		}
//		else
//		{
//			System.out.println("element not found");
//		}
		log.error("Object is not present");
	}
		@Test(priority=3,enabled=true)
		public void Wrongdata()
		{
			test=extent.startTest("Enter wrong data");
			po.username().sendKeys("rajesh");
			po.loginpassword().sendKeys("1234");
			cm.scrollUppage(driver);
			po.loginsubmit().click();
			test.log(LogStatus.PASS, "wrong data entry is finished");
//			if (driver.findElement(By.xpath("//div[@class='resultlogin']/div")).toString().equals("Invalid Email or Password"))
//			{
//				System.out.println("please enter the username and password ");
//			}
//			else
//			{
//				System.out.println("element not found");
//			}
//		
	   }
		@Test(priority=4,enabled=true,dataProvider="getdata")
		public void Correctdata(String username,String password) throws IOException, InterruptedException
		{
//			FileInputStream fis = new FileInputStream("C:\\Users\\Rajesh_B\\workspace\\TravelAgency\\src\\main\\java\\TravelP\\TravelAgency\\data.properties");
//			pro.load(fis);
//			System.out.println(pro.getProperty("email"));
			//cleared the field data
			test=extent.startTest("Correct data entry");
			
			po.username().clear();
			po.loginpassword().clear();
			Thread.sleep(2000);
			//enter the user data 
			po.username().sendKeys(username);
			po.loginpassword().sendKeys(password);
			//scrll the page 
			cm= new commonMethod();
			cm.scrollUppage(driver);
			Thread.sleep(2000);
			po.loginsubmit().click();
			log.info("element is present");
			test.log(LogStatus.FAIL,"Invalid password and id");
			 extent.endTest(test);
	         extent.flush();
	   }
		@DataProvider
		public Object[][] getdata(){
			//1st data 
			Object [][]data=new Object[2][2];
			data[0][0]="raju@gmail.com";
			data[0][1]="test123";
			//2nd data 
			data[1][0]="hitesh@gmail.com";
			data[1][1]="test123";
			return data;
		}
		
	
}
	


