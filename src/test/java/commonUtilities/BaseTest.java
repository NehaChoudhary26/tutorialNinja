package commonUtilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    public static WebDriver driver;
    public  ExtentReports report; 
	public  ExtentTest test;
    
    ReadConfig readConfig = new ReadConfig();

	String baseurl = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	String type = readConfig.getDataType();

	public String defaultuser = readConfig.getEmail() ;
	public String defaultpassword = readConfig.getPassword();
	
    public static Properties prop = new Properties();
    public static FileReader fr;

	@BeforeMethod
	public void setup() throws IOException {
		
		if(driver == null) {
		FileReader fr = new FileReader(System.getProperty("user.dir")+"/Confuguration/config.properties");
		 prop.load(fr);
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		driver.get(prop.getProperty("baseurl"));
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void quitBrowser(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
		captureScreenShot(driver, result.getName());
		}
		driver.quit();
	}

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

}
