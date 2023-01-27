package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commonUtilities.BaseTest;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.SearchProductPage;
import pages.ShopingCartPage;
import pages.VoucherPage;
import pages.VoucherSuccessPage;
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
	
	@Test
	public void verifyEstimateShipingAndTaxes() {
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

    @Test
    public void verifyGiftCertificates() {
    	HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnAccountButtonAndLoginBtn();
		MyAccountPage myAccountPage = login.enterCredentialsToLogin("valid", defaultuser, defaultpassword);
		VoucherPage voucherForm = myAccountPage.clickOnGiftCertificate();
		VoucherSuccessPage voucherPage= voucherForm.enterDetailsToGiftCertificate();
		SoftAssert softAssert = new SoftAssert();
		String exPectedResult = "Thank you for purchasing a gift certificate";
		String actualResult = voucherPage.getSuccessMsgOfGigtCertificatePurchage();
	    softAssert.assertTrue(actualResult.contains(exPectedResult));
		ShopingCartPage giftCertificate = voucherPage.clickOnContinueToPurchaseGiftCard();
		String actualResult1 = giftCertificate.isGiftCertificateAddedToShopinCart();
		String expectedResult1 = "$1.00 Gift Certificate for key";
		softAssert.assertTrue(actualResult1.contains(expectedResult1));
    }
}
