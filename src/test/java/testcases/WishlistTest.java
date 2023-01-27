package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commonUtilities.BaseTest;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.SearchProductPage;
import pages.WishlistPage;

public class WishlistTest extends BaseTest{
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void validateSearchProductAndAddTowishlist() throws Throwable {
	HeaderPage header = new HeaderPage(driver);
	LoginPage login = header.clickOnAccountButtonAndLoginBtn();
		MyAccountPage myAccountPage=login.enterCredentialsToLogin("valid", defaultuser, defaultpassword);
		SearchProductPage search =myAccountPage.searchItem("iPhone");
	    boolean isSearchProductDisplayed =search.isSearchedProductDispayed();
	    softAssert.assertTrue(isSearchProductDisplayed);
	    search.clickToWishlistIconToaddProduct();
		boolean isSuccessMsgDisplayed=search.isSuccessMsgToAddProductToWishlistIsDisplayed();
		softAssert.assertTrue(isSuccessMsgDisplayed);
		
		WishlistPage wishlist = header.clickOnWishlistBtn();
		Thread.sleep(2000);
		String verifyPageTitle = wishlist.wishlistPageTitle();
		String actualPageTitle = "My Wish List";
		softAssert.assertEquals(verifyPageTitle,actualPageTitle);
       boolean isProductAddedToWishlist= wishlist.varifyProductAddedToWishlist();
		softAssert.assertTrue(isProductAddedToWishlist);
    }
	
	@Test
	public void removeProductFromWishlist() throws Throwable {
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
