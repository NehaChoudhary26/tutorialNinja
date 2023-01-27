package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProductPage {
	WebDriver driver;
    By searchProductDisplayedcheck = By.xpath("(//button[@type='button'])[11]");
    By addToWishlistBtn = By.xpath("(//button[@type='button'])[11]");
	By MsgToAddProductToWishlist = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	
	public SearchProductPage(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isSearchedProductDispayed() {
		boolean sucessMsg = driver.findElement(searchProductDisplayedcheck).isDisplayed(); //add to wishlist btn is displayed
		return sucessMsg;
	}
	public SearchProductPage clickToWishlistIconToaddProduct() {
		driver.findElement(addToWishlistBtn).click();
		return this;
		}
	public boolean isSuccessMsgToAddProductToWishlistIsDisplayed() {
		boolean successMsg =driver.findElement(MsgToAddProductToWishlist).isDisplayed();
		return successMsg;
	}
}
