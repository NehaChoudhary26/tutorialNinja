package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import common.BaseTest;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.SearchProductPage;
import pages.ShopingCartPage;
import pages.WishlistPage;

public class EstimateShipingAndTaxesTest extends BaseTest {
	
	@Test
	public void verifyEstimateShipingAndTaxes() {
		SoftAssert softAssert = new SoftAssert();
		HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnAccountButtonAndLoginBtn();
		MyAccountPage myAccountPage=login.enterCredentialsToLogin("valid", defaultuser, defaultpassword);
		SearchProductPage search =myAccountPage.searchItem("iPhone");
		search.clickToWishlistIconToaddProduct();
		WishlistPage wishlist = header.clickOnWishlistBtn();
		wishlist.clickOnAddToCartBtn();
		ShopingCartPage cartPage = header.clickOnShopingCartBtn();
		 cartPage.estimateShipingAndTaxes();
		 String actMsg = cartPage.isEstimateShipingAndTaxescalculatedsuccesfully();
		 String expectedMsg = "Success: Your shipping estimate has been applied!";
		if(actMsg.contains(expectedMsg)) {
			softAssert.assertTrue(true);
		}else {
			softAssert.assertTrue(false);
		}
	}

}
