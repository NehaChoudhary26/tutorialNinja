package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyAccountPage;

public class AddNewAddressTest extends BaseTest{
	@Test
	public void validateAddNewAddressTest() {
	HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnAccountButtonAndLoginBtn();
		MyAccountPage myAccPage = login.enterCredentialsToLogin("valid", defaultuser, defaultpassword);
	    myAccPage.addNewAddressAndSubmit();
	   boolean successMgsOfAddressAdded= myAccPage.verifyAddressAddedMessage();
	   Assert.assertTrue(successMgsOfAddressAdded);
	}
 }
