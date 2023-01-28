package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class productComparePage {

	WebDriver driver;
	By product1Name = By.xpath("//div[@id='product-compare']//div[@id='content']");
	By product2Name = By.xpath("//div[@id='product-compare']//div[@id='content']");
	public productComparePage(WebDriver driver) {
		this.driver = driver;
	}
	public String nameOfProduct1() {
		return driver.findElement(product1Name).getText();
	}
	public String nameOfProduct2() {
		return driver.findElement(product2Name).getText();
	}
}
