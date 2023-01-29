package common;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtils {
	public String captureScreenShot(WebDriver driver,String testName) 
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
	
		File sourceScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir") + "/Screenshots/" + testName + ".png";
		File destinationScreenshot = new File(destinationPath);
		try {
			FileUtils.copyFile(sourceScreenshot,destinationScreenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationPath;
	}

 public String generateRandomString() {
	 String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
 
 public String generateRandomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}
