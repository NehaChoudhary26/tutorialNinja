package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	By username = By.id("input-email");
	By passwordTextBox = By.id("input-password");
	By ForgottenPasswodLink = By.linkText("Forgotten Password");
	By loginBtn = By.xpath("//input[contains(@class,'btn-primary')]");
	By changePwdMsg =  By.xpath("//body/div[@id='account-login']/div[1]");
	By editAccountLink = By.linkText("Edit your account information");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public MyAccountPage enterCredentialsToLogin(String type,String Username, String Password) {
		driver.findElement(username).sendKeys(Username);
		driver.findElement(passwordTextBox).sendKeys(Password);
		driver.findElement(loginBtn).click();
		return new MyAccountPage(driver);
	}
	
	public String getLoginPageUrl() {
	String loginPageUrl =	driver.getCurrentUrl();
	return loginPageUrl;
	}
	
	public ForgottenPasswordPage forgottenPwdLink() {
		driver.findElement(ForgottenPasswodLink).click();
		return new ForgottenPasswordPage(driver);
	}
	
	public boolean IsPwdChangeMsgDisplayed() {
		boolean confirmationMsg = driver.findElement(changePwdMsg).isDisplayed();
		return confirmationMsg;
   }
	
}
