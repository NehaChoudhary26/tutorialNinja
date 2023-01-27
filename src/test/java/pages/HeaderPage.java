package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
	
      WebDriver driver;

      By myAccountButton = By.xpath("//a[@title='My Account']");
      By registerButton = By.xpath("//a[text()='Register']");
      By loginButton = By.linkText("Login");
      By wishListBtn = By.xpath("//a[@id='wishlist-total']");
      By shopingCartBtn = By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[4]");

	public HeaderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public RegistrationPage clickOnAccountButtonAndRegistrationBtn() {
		  driver.findElement(myAccountButton).click();
		  driver.findElement(registerButton).click();
		  return new RegistrationPage(driver);
		}
	
	public LoginPage clickOnAccountButtonAndLoginBtn() {
		  driver.findElement(myAccountButton).click();
		  driver.findElement(loginButton).click();
		  return new LoginPage(driver);
		}
	public WishlistPage clickOnWishlistBtn() {
		driver.findElement(wishListBtn).click();
		return new WishlistPage(driver);
	}
	public ShopingCartPage clickOnShopingCartBtn() {
		driver.findElement(shopingCartBtn).click();
		return new ShopingCartPage(driver);
	}
}
