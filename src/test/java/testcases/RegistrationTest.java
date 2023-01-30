package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;
import common.CommonUtils;
import pages.HeaderPage;
import pages.RegistrationPage;
public class RegistrationTest extends BaseTest {
	String expectedResult = "Edit your account information";
	
	@Test
	public void verifyRegistrationWitnValidCredential() throws IOException {
		CommonUtils commonUtils =new CommonUtils();
		HeaderPage header = new HeaderPage(driver);
		RegistrationPage registration = header.clickOnAccountButtonAndRegistrationBtn();
		registration.enterCredentialsForNewRegistrationAndSubmit(commonUtils.generateRandomString()+"@gmail.com",defaultpassword);
		 String expectedResult = "Your Account Has Been Created!";
		 String actualMsg =registration.isYourAccountHasBeenCreatedMsgDisplayed();
			Assert.assertEquals(actualMsg, expectedResult);
		}
	
	@Test
	  public void verifyRegisterAccountWithInValidEmail() {
		HeaderPage header = new HeaderPage(driver);
		RegistrationPage registration = header.clickOnAccountButtonAndRegistrationBtn();
		registration.enterCredentialsForNewRegistrationAndSubmit("software", "welcome");
		 String actualResult =registration .getRegisterAccountPageUrl();
		 String expectedResult = "http://tutorialsninja.com/demo/index.php?route=account/register";
		 Assert.assertEquals(actualResult, expectedResult);
	  }
}

