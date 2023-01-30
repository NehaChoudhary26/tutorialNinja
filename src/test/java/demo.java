import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import common.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class demo extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("softwaretesting328@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Software@2022");
		driver.findElement(By.xpath("//input[contains(@class,'btn-primary')]")).click();
		
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[7]")).click();
		
		driver.findElement(By.xpath("//i[@class = 'fa fa-exchange']")).click();//Canon EOS 5D
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.quit();
		
	}

}