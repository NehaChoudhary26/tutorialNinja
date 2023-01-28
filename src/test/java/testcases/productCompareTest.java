package testcases;

import commonUtilities.BaseTest;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyAccountPage;

public class productCompareTest extends BaseTest {
	
	public void verifyProductAddedToComaparePage() {
		HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnAccountButtonAndLoginBtn();
		MyAccountPage myAccountPage=login.enterCredentialsToLogin("valid", defaultuser, defaultpassword);
	}

}
