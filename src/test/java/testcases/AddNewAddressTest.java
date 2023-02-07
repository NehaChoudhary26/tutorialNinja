package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common.BaseTest;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyAccountPage;

public class AddNewAddressTest extends BaseTest{
	@Test
	    public void validateAddNewAddressTest() {
	    HeaderPage header = new HeaderPage(driver);
	    
	    test.log(Status.INFO, "clickOn MAccount and clickOn Login");
		LoginPage login = header.clickOnAccountButtonAndLoginBtn();
		test.log(Status.PASS, "login page open");
		
		test.log(Status.INFO, "Enter user credential to login");
		MyAccountPage myAccPage = login.enterCredentialsToLogin("valid", defaultuser, defaultpassword);
		test.log(Status.PASS, "user login successfully");
		
		test.log(Status.INFO, "enter details of new address");
		myAccPage.addNewAddressAndSubmit();
		test.log(Status.PASS, "Details entered successfully");
		
		test.log(Status.INFO, "verify if address added succesfully");
	    boolean successMgsOfAddressAdded= myAccPage.verifyAddressAddedMessage();
	    Assert.assertFalse(successMgsOfAddressAdded);
	    test.log(Status.PASS, "test is passed");
	}
 }
