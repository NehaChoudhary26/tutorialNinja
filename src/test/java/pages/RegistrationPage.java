package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
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
	
	public void enterCredentialsForRegistrationAndSubmit() {
		 driver.findElement(first_Name).sendKeys("Neha");
		 driver.findElement(last_Name).sendKeys("Choudhary");
		 driver.findElement(email_Field).sendKeys("softwaretesting2345@gmail.com");
		 driver.findElement(telephone_Field).sendKeys("0734545237");
		 driver.findElement(pwd_Field).sendKeys("Software@2022");
		 driver.findElement(confirm_Pwd_field).sendKeys("Software@2022");
		 driver.findElement(radioBtn).click();
		 driver.findElement(privacyBtn).click();
		 driver.findElement(continueBtn).click();
		 driver.findElement(By.xpath("//a[text()='Continue']")).click();
	}
	
	public boolean isYourAccountHasBeenCreatedMsgDisplayed() {
		boolean accountCreationMsg = driver.findElement(yourAccountCreatedMsg).isDisplayed();
		return accountCreationMsg;
	}
}
