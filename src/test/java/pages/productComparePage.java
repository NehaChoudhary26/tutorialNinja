package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class productComparePage {

	WebDriver driver;
	By product1Name = By.xpath("//strong[contains(text(),'Canon EOS 5D')]");
	By product2Name = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/a[1]/strong[1]");
	public productComparePage(WebDriver driver) {
		this.driver = driver;
	}
	public String isProduct1AddedToComparePage() {
	String getProduct1Name =driver.findElement(product1Name).getText();
	return getProduct1Name;
	}
	public String isProduct2AddedToComparePage() {
		String getProduct2Name= driver.findElement(product2Name).getText();
		return getProduct2Name;
	}
}
