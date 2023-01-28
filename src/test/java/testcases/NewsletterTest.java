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
		logger.info("Click on login option from Account Dropdown");
		LoginPage login = header.clickOnAccountButtonAndLoginBtn();
		logger.info("login page open");
		logger.info("enter username and password to login");
		MyAccountPage myAccountPage=login.enterCredentialsToLogin("valid", defaultuser, defaultpassword);
		logger.info("user login successfully");
		logger.info("click on newsletter button");
		myAccountPage.newsletterOption();
		logger.info("newsletter page will open and chooes the subscription option ");
		String expMsgOfNewletterSubscription = "Success: Your newsletter subscription has been successfully updated!";
		String actMsgOfNewletterSubscription = myAccountPage.isSubscriptionSuccessMsgDisplayed();
		Assert.assertEquals(expMsgOfNewletterSubscription,actMsgOfNewletterSubscription);
		logger.info("NewsletterTest passed");
	}
}
