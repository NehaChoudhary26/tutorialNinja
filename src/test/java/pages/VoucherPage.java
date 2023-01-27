package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VoucherPage {
	
	By recipientName_field = By.id("input-to-name");
	By recipientemail_field = By.id("input-to-email");
	By senderName_field = By.id("input-from-name");
	By senderEmail_Field = By.id("input-from-email");
	By giftCertificateThemeOption = By.xpath("//input[@value='7']");
	By messageBox = By.id("input-message");
	By amountBox =  By.id("input-amount");
	By agreeBtn = By.name("agree");
	By continueBtn = By.xpath("//input[@value='Continue']");
	
	WebDriver driver;
	public VoucherPage (WebDriver driver) {
		this.driver = driver;
	}
	public VoucherSuccessPage enterDetailsToGiftCertificate() {
		driver.findElement(recipientName_field).sendKeys("key");
		driver.findElement(recipientemail_field).sendKeys("softwaretesting328@gmail.com");
		driver.findElement(senderName_field).sendKeys("key");
		driver.findElement(senderEmail_Field).clear();
		driver.findElement(senderEmail_Field).sendKeys("softwaretesting328@gmail.com");
		driver.findElement(giftCertificateThemeOption).click();
		driver.findElement(messageBox).sendKeys("Happy Birthday");
		driver.findElement(amountBox).clear();
		driver.findElement(amountBox).sendKeys("1");
		driver.findElement(agreeBtn).click();
		driver.findElement(continueBtn).click();
		return new VoucherSuccessPage(driver);
	}

}
