package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgottenPasswordPage {
	WebDriver driver;
	
	By emailTextbox = By.xpath("//input[@id='input-email']");
	By continueBtn = By.xpath("(//input[contains(@class,Continue)])[5]");
	
	public ForgottenPasswordPage(WebDriver driver1) {
		this.driver = driver1;
	}
		
		public LoginPage enterValidEmailAndClickOnContinueBtn() {
			driver.findElement(emailTextbox).sendKeys("softwaretesting328@gmail.com");
			driver.findElement(continueBtn).click();
			return new LoginPage(driver);
		}
}
