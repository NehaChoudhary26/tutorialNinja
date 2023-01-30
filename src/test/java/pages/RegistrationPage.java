package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.CommonUtils;

public class RegistrationPage extends CommonUtils{
	WebDriver driver;
	By yourAccountCreatedMsg = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
	By first_Name=By.id("input-firstname");
	By last_Name = By.id("input-lastname");
	By email_Field = By.id("input-email");
	By telephone_Field =By.id("input-telephone");
	By pwd_Field = By.id("input-password");
	By confirm_Pwd_field = By.id("input-confirm");
	By radioBtn = By.xpath("//input[@value='0']");
	By privacyBtn =By.xpath("//input[@name='agree']");
	By continueBtn = By.xpath("//input[@value='Continue']");
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterCredentialsForNewRegistrationAndSubmit(String email,String password ) {
		CommonUtils commonUtils =new CommonUtils();
		 driver.findElement(first_Name).sendKeys(commonUtils.generateRandomString());
		 driver.findElement(last_Name).sendKeys(commonUtils.generateRandomString());
		 driver.findElement(email_Field).sendKeys(email);
		 driver.findElement(telephone_Field).sendKeys(commonUtils.generateRandomeNumber());
		 driver.findElement(pwd_Field).sendKeys(password);
		 driver.findElement(confirm_Pwd_field).sendKeys(password);
		 driver.findElement(radioBtn).click();
		 driver.findElement(privacyBtn).click();
		 driver.findElement(continueBtn).click();
		 //driver.findElement(By.xpath("//a[text()='Continue']")).click();
	}
	
	public String isYourAccountHasBeenCreatedMsgDisplayed() {
		String accountCreationMsg = driver.findElement(yourAccountCreatedMsg).getText();
		return accountCreationMsg;
	}

	public String getRegisterAccountPageUrl() {
		return driver.getCurrentUrl();
	}
}
