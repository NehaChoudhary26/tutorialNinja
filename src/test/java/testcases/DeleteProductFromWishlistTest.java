package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.BaseTest;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.SearchProductPage;
import pages.WishlistPage;

public class DeleteProductFromWishlistTest extends BaseTest {
	
	@Test
	public void removeProductFromWishlist() throws Throwable {
		SoftAssert softAssert = new SoftAssert();
		HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnAccountButtonAndLoginBtn();
		MyAccountPage myAccountPage=login.enterCredentialsToLogin("valid", defaultuser, defaultpassword);
		SearchProductPage search =myAccountPage.searchItem("iPhone");
		search.clickToWishlistIconToaddProduct();
		Thread.sleep(3000);
		WishlistPage wishlist = header.clickOnWishlistBtn();
		Thread.sleep(3000);
		wishlist.removeProductFromWishlist();
		boolean actualMsg =wishlist.verifyProductIsRemoved();
		softAssert.assertTrue(actualMsg, "Not Pass");
		
	}

}
