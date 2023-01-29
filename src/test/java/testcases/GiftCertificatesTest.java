package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.BaseTest;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ShopingCartPage;
import pages.VoucherPage;
import pages.VoucherSuccessPage;

public class GiftCertificatesTest extends BaseTest{
	@Test
    public void verifyGiftCertificatesAdded() {
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
