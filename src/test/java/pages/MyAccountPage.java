package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MyAccountPage {
	WebDriver driver;
	By editAccountLink = By.xpath("//a[contains(text(),'Edit your account information')]");
	By firstNameField = By.id("input-firstname");
	By lastNameField = By.id("input-lastname");
	By emailField = By.id("input-email");
	By phoneNoField = By.id("input-telephone");
	By continueBtn = By.xpath("//input[@value='Continue']");
	By yourAccountCreatedMsg = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
	By modifyAddressLink = By.linkText("Modify your address book entries");
	By newAddressBtn = By.linkText("New Address");
	By address1Field = By.id("input-address-1");
	By cityField = By.id("input-city");
	By postcodeField = By.id("input-postcode");
	By countryDropdown = By.id("input-country");
	By zoneDropdown = By.id("input-zone");
	By defaultAddressRadioBtn = By.xpath("//input[@value='1']");
	By addressSubmitBtn = By.xpath("//input[@value='Continue']");
	By addressAddedMsg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	By search_Field = By.xpath("//input[@name='search']");
	By searchBtn = By.className("input-group-btn");
	By subscriptionLink = By.linkText("Subscribe / unsubscribe to newsletter");
	By subscriptionBtn = By.className("radio-inline");
	By continueSubscription = By.xpath("(//input[@value='Continue'])[1]");
	By subscriptionSuccessMsgDisplayed = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	By giftCertificateLink = By.linkText("Gift Certificates");
	By camerasLink = By.xpath("//ul[@class='nav navbar-nav']//li[7]");
	
	public MyAccountPage (WebDriver driver) {
		this.driver = driver;
	}
	public MyAccountPage editYourAccountDetailsAndSubmit() {
		    driver.findElement(editAccountLink).click();
			driver.findElement(firstNameField).clear();
			driver.findElement(firstNameField).sendKeys("kiii");
			driver.findElement (lastNameField).clear ();
			driver.findElement(lastNameField).sendKeys("lastname");
			/*driver.findElement(By.id("input-email")).clear();
			driver.findElement(By.id("input-email")).sendKeys("softwaretesting328@gmail.com");*/
			driver.findElement (phoneNoField).clear ();
			driver.findElement(phoneNoField).sendKeys("0123456789");
			driver.findElement(continueBtn).click();
			return new MyAccountPage(driver);
	     }
	
	public boolean varifyLoginIsSuccess() {                          //To varify Login is sucessfull
		boolean actualResult = driver.findElement(editAccountLink).isDisplayed();
		return actualResult;
	}
	 public Boolean getAccounUpdatedMessage() {
		 Boolean confirmMsg = driver.findElement(By.xpath("//div[@id='account-account']/div[1]")).isDisplayed();
		 return confirmMsg;
	 }
	 
	 public void addNewAddressAndSubmit() {
		  driver.findElement(modifyAddressLink).click();
		  driver.findElement(newAddressBtn).click();
		  driver.findElement(firstNameField).sendKeys("pri");
		  driver.findElement(lastNameField).sendKeys("Singh");
		  driver.findElement(address1Field).sendKeys("Area");
		  driver.findElement(cityField).sendKeys("Gothenburg");
		  driver.findElement(postcodeField).sendKeys("43567");
		  new Select(driver.findElement(countryDropdown)).selectByVisibleText("Sweden");
		  new Select(driver.findElement(zoneDropdown)).selectByVisibleText("Västra Götaland");
		  driver.findElement(defaultAddressRadioBtn).click();
		  driver.findElement(addressSubmitBtn).click();
		  }
	public boolean verifyAddressAddedMessage() {
		boolean confirmMsg = driver.findElement(addressAddedMsg).isDisplayed();
		return confirmMsg;
	}
	public SearchProductPage searchItem(String productName) {
		driver.findElement(search_Field).click();
		driver.findElement(search_Field).sendKeys(productName);
		driver.findElement(searchBtn).click();
		return new SearchProductPage(driver);
	}
	public MyAccountPage newsletterOption() {
		driver.findElement(subscriptionLink).click();
		driver.findElement(subscriptionBtn).click();
		driver.findElement(continueSubscription).click();
		return this;
	}
	public String isSubscriptionSuccessMsgDisplayed() {
		String actConfirmMsg = driver.findElement(subscriptionSuccessMsgDisplayed).getText();
		return actConfirmMsg;
	}

	public VoucherPage clickOnGiftCertificate() {
		driver.findElement(giftCertificateLink).click();
		return new VoucherPage(driver);
	}
	public ProductCategoryPage navigateToCameras() {
		driver.findElement(camerasLink).click();
		return new ProductCategoryPage(driver);		
	}
}
