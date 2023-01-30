package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import common.BaseTest;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.SearchProductPage;
import pages.ShopingCartPage;
import pages.WishlistPage;

public class ShopingCartTest extends BaseTest{
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void verifyProductMovedFromWishlisttoShopingCart() {
		HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnAccountButtonAndLoginBtn();
		MyAccountPage myAccountPage=login.enterCredentialsToLogin("valid", defaultuser, defaultpassword);
		SearchProductPage search =myAccountPage.searchItem("iPhone");
		search.clickToWishlistIconToaddProduct();
		WishlistPage wishlist = header.clickOnWishlistBtn();
		wishlist.clickOnAddToCartBtn();
		ShopingCartPage cartPage = header.clickOnShopingCartBtn();
		boolean ischeckoutBtnVisible = cartPage.isProductAddedInShopingCart();
		Assert.assertTrue(ischeckoutBtnVisible);
	}
}
