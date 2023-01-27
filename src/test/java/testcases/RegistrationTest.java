package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import commonUtilities.BaseTest;
import pages.HeaderPage;
import pages.RegistrationPage;
public class RegistrationTest extends BaseTest {
	String expectedResult = "Edit your account information";
	
	@Test
	public void verifyRegistration() throws IOException {
		HeaderPage header = new HeaderPage(driver);
		RegistrationPage registration = header.clickOnAccountButtonAndRegistrationBtn();
		registration.enterCredentialsForRegistrationAndSubmit();
		
		if(registration.isYourAccountHasBeenCreatedMsgDisplayed())
		{
		 boolean actualMsg =registration.isYourAccountHasBeenCreatedMsgDisplayed();
			Assert.assertTrue(actualMsg);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
}

