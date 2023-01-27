package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonUtilities.BaseTest;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyAccountPage;

public class NewsletterTest extends BaseTest{
	@Test
	public void validateNewsletterSubscription() {
		HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnAccountButtonAndLoginBtn();
		MyAccountPage myAccountPage=login.enterCredentialsToLogin("valid", defaultuser, defaultpassword);
		myAccountPage.newsletterOption();
		
		String expMsgOfNewletterSubscription = "Success: Your newsletter subscription has been successfully updated!";
		String actMsgOfNewletterSubscription = myAccountPage.isSubscriptionSuccessMsgDisplayed();
		Assert.assertEquals(expMsgOfNewletterSubscription,actMsgOfNewletterSubscription);
	}
}
