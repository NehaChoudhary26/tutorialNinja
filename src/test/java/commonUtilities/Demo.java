package commonUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo{
		public static String baseurl = "http://tutorialsninja.com/demo/";
		public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get(baseurl);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("softwaretesting328@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Software@2022");
		driver.findElement(By.xpath("//input[contains(@class,'btn-primary')]")).click();
		Thread.sleep(3000);
	
		driver.findElement(By.linkText("Cameras")).click();
		
		/*driver.findElement(By.xpath("//i[@class='fa fa-exchange']")).click();
		String actMsg =driver.findElement(By.className("alert-success")).getText();// actMsg ofcannon
		System.out.println(actMsg);
		String expMsg = "Success: You have added Canon EOS 5D to your product comparison!";
		Assert.assertTrue(actMsg.contains(expMsg));*/
		
		driver.findElement(By.xpath("//i[@class='fa fa-exchange']")).click();
		String expMsg1 ="Success: You have added Nikon D300 to your product comparison!";
		String actMsg1= driver.findElement(By.className("alert-success")).getText();
		System.out.println(actMsg1);
		Assert.assertTrue(actMsg1.contains(expMsg1));
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='product-category']/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/button[3]/i[1]")).click();
		
		
		driver.findElement(By.xpath("//a[@id='compare-total']")).click();
		
		String canon =driver.findElement(By.xpath("//strong[contains(text(),'Canon EOS 5D')]")).getText();
		String nicon = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/a[1]")).getText();
		String actCannonMsg = "Canon EOS 5D";
		String actNiconMsg = "Nikon D300";
		Assert.assertEquals(actCannonMsg, canon);
		Assert.assertEquals(actNiconMsg, nicon);
		
		System.out.println("done");
		
		driver.quit();
	}

}
