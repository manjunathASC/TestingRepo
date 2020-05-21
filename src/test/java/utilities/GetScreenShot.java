package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenShot {	
	public  String destination;
	public  String capture(WebDriver driver, String screenshotName) throws Exception {                     
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());      
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);       
		destination = System.getProperty("user.dir") + "\\target\\screenshots\\capture\\"+screenshotName+"\\"+screenshotName+"_"+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(scrFile, finalDestination);        
		scrFile.deleteOnExit();
		return destination;
	}
}
