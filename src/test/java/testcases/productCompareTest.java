package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import common.BaseTest;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductDisplayPage;
import pages.productComparePage;

public class productCompareTest extends BaseTest {
	@Test
	public void verifyProductAddedToComaparePage() throws InterruptedException {
		
		SoftAssert softAssert = new SoftAssert();
		HeaderPage header = new HeaderPage(driver);
		logger.info("Click on login option from Account Dropdown");
		LoginPage login = header.clickOnAccountButtonAndLoginBtn();
		logger.info("login page open");
		logger.info("enter username and password to login");
		MyAccountPage myAccountPage=login.enterCredentialsToLogin("valid", defaultuser, defaultpassword);
		logger.info("user login successfully");
		logger.info("click on camra link on Accoun Page");
		ProductDisplayPage productDisplay = myAccountPage.clickToCamerasLink();
		logger.info("all cameras open in product page");
		 productDisplay.addProduct1ToCompare();
		logger.info("add first product to product compare page");
		Thread.sleep(2000);
		logger.info("add seccond product to product compare page");
		 productDisplay.addProduct2ToCompare();
		
		 logger.info("open the product comparision page");
		productComparePage comparePage = productDisplay.navigateToProductComparisonPage();
		
		String actualProduct1Name =comparePage.isProduct1AddedToComparePage();
		String expectedProduct1Name = "Canon EOS 5D";
		softAssert.assertEquals(actualProduct1Name, expectedProduct1Name);
		logger.info("verify that Canon EOS 5D present on compare page");
		
		String actualProduct2Name =comparePage.isProduct2AddedToComparePage();
		String expectedProduct2Name = "Nikon D300";
		softAssert.assertEquals(actualProduct2Name, expectedProduct2Name);
		logger.info("verify that Nikon D300 present on compare page");
		softAssert.assertAll();
	}

}
