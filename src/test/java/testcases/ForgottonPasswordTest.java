package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;
import pages.ForgottenPasswordPage;
import pages.HeaderPage;
import pages.LoginPage;

public class ForgottonPasswordTest extends BaseTest {

	  @Test
	  public void verifyFogottonPwdWithValidEmail() {
		  
		  HeaderPage header = new HeaderPage(driver);
		  LoginPage login = header.clickOnAccountButtonAndLoginBtn();
		  ForgottenPasswordPage forgotPwd=login.forgottenPwdLink();
		  forgotPwd.enterValidEmailAndClickOnContinueBtn();
		  boolean getPwdChangeMsg =login.IsPwdChangeMsgDisplayed();
		  Assert.assertTrue(getPwdChangeMsg);
	  }
}
