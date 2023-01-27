package commonUtilities;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {
	
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports report; 
	public static ExtentTest test;
	WebDriver driver;

	public static void configExtentReport() {
   
		File extentReportFilePath =new File(System.getProperty("user.dir")+"/ExtentReports/MyExtentReports.html");
		htmlReporter = new  ExtentSparkReporter(extentReportFilePath);
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		
		ReadConfig readConfig =new ReadConfig();
		report.setSystemInfo("browser", readConfig.getBrowser());
		report.setSystemInfo("OS", "Mac");
	    report. setSystemInfo ("username", "nehachoudhary"); 
		report. setSystemInfo("Java Version", "17");
		
		htmlReporter.config().setDocumentTitle("Tutorial ninja Test report");
		htmlReporter.config().setReportName("TutorialsNinja Test•Automation Results Report");
		htmlReporter.config ().setTheme (Theme.DARK); 
		htmlReporter.config().setTimeStampFormat("dd/mm/yyyy-hh:mm:ss");
	}

	@Override
	public void onStart(ITestContext context) {
		configExtentReport();
		System.out.println("On Start method invoked....");
	}

	@Override
	public void onTestStart(ITestResult result) {
	String testName=result.getName();
	test = report.createTest(testName);
	test.log(Status.INFO,MarkupHelper.createLabel("Name of the exetuted test case is: "+testName, ExtentColor.BLUE));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	String testName=result.getName();
	test = report.createTest(testName);
	test.log(Status.PASS,MarkupHelper.createLabel("Name of the pass test case is: "+testName, ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
	String testName=result.getName();
	test = report.createTest(testName);
	test.log(Status.FAIL,MarkupHelper.createLabel("Name of the failed test case is: "+testName, ExtentColor.RED));
	test.log(Status.INFO,result.getThrowable());
	
	String screenShotPath = System.getProperty("user.dir") + "/Screenshots/" + testName + ".png";
	if(result.getStatus()==ITestResult.FAILURE) {
	test.fail("Captured Screenshot is :" + test.addScreenCaptureFromPath(screenShotPath));
      }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName=result.getName();
		test = report.createTest(testName);
		test.log(Status.SKIP,MarkupHelper.createLabel("Name of the pass skipp test case is: "+testName, ExtentColor.YELLOW));
		test.log(Status.SKIP,result.getThrowable());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
