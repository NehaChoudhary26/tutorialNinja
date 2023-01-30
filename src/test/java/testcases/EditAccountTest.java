package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;
import pages.MyAccountPage;
import pages.HeaderPage;
import pages.LoginPage;

public class EditAccountTest extends BaseTest {
	@Test
	public void validateAcoountUpdateTest() {
	   HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnAccountButtonAndLoginBtn();
		MyAccountPage myAccPage=login.enterCredentialsToLogin("valid", defaultuser, defaultpassword);
		myAccPage.editYourAccountDetailsAndSubmit();
	boolean getAccountUpdateMsg = myAccPage.getAccounUpdatedMessage();
		Assert.assertTrue(getAccountUpdateMsg);
	}
}
