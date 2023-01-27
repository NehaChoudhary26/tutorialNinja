package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ShopingCartPage {
	WebDriver driver;
	By productModelDisplay =By.xpath("//td[contains(text(),'product 11')]");
	By estimateShippingAndTaxesLink = By.partialLinkText("Estimate Shipping &");
	By country_Field = By.id("input-country");
	By zone_Field = By.id("input-zone");
	By postcode_Field = By.xpath("//input[@id='input-postcode']");
	By getQuote_Btn = By.id("button-quote");
	By flatShippingRate_radioBtn = By.xpath("//input[@name='shipping_method']");
	By applyShipingBtn = By.id("button-shipping");
	By shipingEstimateSuccessMsg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	By productTableInCart = By.xpath("//form[@enctype='multipart/form-data']//div[@class='table-responsive']");
	
	public ShopingCartPage(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isProductAddedInShopingCart() {
		boolean isProductModelDisplay = driver.findElement(productModelDisplay).isDisplayed();
		return isProductModelDisplay;
	}
	
    public ShopingCartPage estimateShipingAndTaxes() {
    	driver.findElement(estimateShippingAndTaxesLink).click();
		new Select(driver.findElement(country_Field)).selectByVisibleText("Sweden");
		new Select(driver.findElement(zone_Field)).selectByVisibleText("Västra Götaland");
		driver.findElement(postcode_Field).sendKeys("43162");
		driver.findElement(getQuote_Btn).click();
		
		driver.findElement(flatShippingRate_radioBtn).click();
		driver.findElement(applyShipingBtn).click();
		return this;
    }
    
    public String isEstimateShipingAndTaxescalculatedsuccesfully() {
   String successMsg = driver.findElement(shipingEstimateSuccessMsg).getText();
    return successMsg;
    }
 
    public String isGiftCertificateAddedToShopinCart() {
     String actResult = driver.findElement(productTableInCart).toString();
    return actResult;
    }
}
