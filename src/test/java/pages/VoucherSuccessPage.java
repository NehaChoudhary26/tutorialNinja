package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VoucherSuccessPage {
	WebDriver driver;
	By continueBtn = By.linkText("Continue");
	By purchseSuccessMsg = By.xpath("//p[contains(text(),'Thank you for purchasing a gift certificate! Once ')]");
	
	public VoucherSuccessPage(WebDriver driver) {
		this.driver=driver;
	}
   
	public ShopingCartPage clickOnContinueToPurchaseGiftCard() {
		driver.findElement(continueBtn).click();
		return new ShopingCartPage(driver);
	}
	
	public String getSuccessMsgOfGigtCertificatePurchage() {
	String successMsg =	driver.findElement(purchseSuccessMsg).getText();
	return successMsg;
	}
}
