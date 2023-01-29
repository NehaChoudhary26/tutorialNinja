package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDisplayPage {
  
	WebDriver driver;
	By product1 = By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12'][1]");
	By compareButton1 = By.xpath("//i[@class = 'fa fa-exchange']");
	By compareButton2 = By.xpath("(//i[@class = 'fa fa-exchange'])[2]");
	By alertSuccess = By.className("alert-success");
	By product2 = By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12'][2]");
	By productCompareBtn = By.partialLinkText("Product Compare (");
	
	public ProductDisplayPage(WebDriver driver) {
		this.driver = driver;
	}
	public ProductDisplayPage addProduct1ToCompare() {
		driver.findElement(compareButton1).click();
		return this;
	}	
	
	public ProductDisplayPage addProduct2ToCompare() throws InterruptedException {
		driver.findElement(compareButton2).click();
		return this;
	}
	public productComparePage navigateToProductComparisonPage() {
		driver.findElement(productCompareBtn).click();
		return new productComparePage(driver);
	}

}
