package TravelP.TravelAgency;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class commonMethod {
	WebDriver driver;
	@Test
	public void scrollUppage(WebDriver driver){
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("window.scrollBy(200,300)");
	}
	@Test
	public void scrollDown(WebDriver driver){
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("window.scrollBy(-200,300)");
	}
	@Test
	public void screenshotTake(WebDriver driver) throws IOException
	{
		//Current Date
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   String currentTime=dtf.format(now);	
		File scrShot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrShot,new File("E:/TTS/screenshot_"+timestump()+".png"));
	}
	public String timestump(){
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		
	}
	
	
}
