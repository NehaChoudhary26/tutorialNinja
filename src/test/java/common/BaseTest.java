package common;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

 public class BaseTest {
    
    public static WebDriver driver;
	public static Logger logger;
	public static ExtentReports report;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentTest test;
	
	@BeforeSuite
	public static void configExtentReport() {
		File extentReportFilePath =new File(System.getProperty("user.dir")+"/ExtentReport/MyExtentReports.html");
		htmlReporter = new  ExtentSparkReporter(extentReportFilePath);
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		
		ReadConfig readConfig =new ReadConfig();
		report.setSystemInfo("browser", readConfig.getBrowser());
		report.setSystemInfo("OS", "Mac");
	    report. setSystemInfo ("username", "nehachoudhary"); 
		report. setSystemInfo("Java Version", "17");
		
		htmlReporter.config().setDocumentTitle("Tutorial ninja Test report");
		htmlReporter.config().setReportName("TutorialsNinja Test Automation Results Report");
		htmlReporter.config ().setTheme (Theme.DARK); 
		htmlReporter.config().setTimeStampFormat("dd/mm/yyyy-hh:mm:ss");
     }
	CommonUtils commonUtils =new CommonUtils();
    ReadConfig readConfig = new ReadConfig();

	String baseurl = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	String type = readConfig.getDataType();

	public String defaultuser = readConfig.getEmail() ;
	public String defaultpassword = readConfig.getPassword();
	
    public static Properties prop = new Properties();
    public static FileReader fr;

	@BeforeMethod
	public void setup(ITestResult result, ITestContext context) throws IOException {
		
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//logger = LogManager.getLogger("tutorialNinja");
		driver.get(prop.getProperty("baseurl"));
		//logger.info("url opened");
		test=report.createTest (result.getMethod().getMethodName());

	    driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void quitBrowser(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
		String	screenShotPath= commonUtils.captureScreenShot(driver, result.getName());
		String s = "";
		StackTraceElement[] x = result.getThrowable().getStackTrace();
		for (StackTraceElement stackTraceElement : x) {
			s +=stackTraceElement.toString()+"\n";
		}
		test.fail(s);
		test.skip(s);
		test.addScreenCaptureFromPath(screenShotPath);
		}
		driver.quit();
	}
	
	@AfterSuite
	public void finishExtent() {
		report.flush();
	}
}
