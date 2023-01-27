package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {
	WebDriver driver;
	By removeBtn = By.xpath("//tbody/tr/td[6]/a[@class='btn btn-danger']");
	By addToCartIcon = By.xpath("//button[@class='btn btn-primary']");
    By productRemoveMsg= By.xpath("//div[@class='alert alert-success alert-dismissible']");
	
	public WishlistPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean varifyProductAddedToWishlist() {
		boolean checkProductAdded =driver.findElement(removeBtn).isDisplayed();
		return checkProductAdded;
	}
	public String wishlistPageTitle() {
		String wishistPageTitle = driver.getTitle();
		return wishistPageTitle;
	}
	public WishlistPage clickOnAddToCartBtn() {
		driver.findElement(addToCartIcon).click();
		return this;
	}
	public WishlistPage removeProductFromWishlist() {
		driver.findElement(removeBtn).click();
		return new WishlistPage(driver);
	}
	public boolean verifyProductIsRemoved() {
		boolean successMsg = driver.findElement(productRemoveMsg).isDisplayed();
		return successMsg;
	}
	
}
