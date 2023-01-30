package testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyAccountPage;

public class LoginTest extends BaseTest{
	@Test(dataProvider="loginDataSet")
	public void verifyLogin(String type,String Username, String Password) throws IOException {
	    HeaderPage header = new HeaderPage(driver);
		LoginPage login = header.clickOnAccountButtonAndLoginBtn();
		MyAccountPage myAccPage =login.enterCredentialsToLogin(type,Username,Password);
		
		if (type.equalsIgnoreCase ("valid")) {
			boolean isEditAccountLinkDisplayed=myAccPage.varifyLoginIsSuccess();
			Assert.assertTrue(isEditAccountLinkDisplayed);
				}else {
				String expectedResult= "\"http: //tutorialsninja.com/demo/index.php?route=account/login\";";
				String actualResult = login.getLoginPageUrl();
				Assert.assertTrue (actualResult.contains(expectedResult));
				}
	     }
	
	@org.testng.annotations.DataProvider(name = "loginDataSet")
	  public Object[][] loginDataSet() {
	    return new Object[][] {
	      new Object[] {"valid", "softwaretesting328@gmail.com", "Software@2022" },
	      new Object[] {"invalidEmail","softwaretesting328", "Software@2022" },
	      new Object[] {"invalidPwd","softwaretesting328@gmail.com", "2022" },
	      new Object[] {"bothInvalid","softwaretesting328", "2022" },
	      new Object[] {"bothBlank","", "" },
	      new Object[] {"valid","softwaretesting328@gmail.com", "Software@2022" },
	    };
	  }
}
