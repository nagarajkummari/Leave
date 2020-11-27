package praticeselinium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Facebook {
	WebDriver driver;
	@BeforeTest
	public void landing()
	{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException, IOException
	{
		driver.findElement(By.cssSelector("#u_0_2")).sendKeys(Keys.CONTROL , Keys.ENTER);
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("nagaraju");
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("kummari");
		driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("nagaraju0-35@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("nagaraju0-35@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("1234567890");
		
		Select sc = new Select(driver.findElement(By.cssSelector("#day")));
		sc.selectByIndex(26);
		
		Select sc1 = new Select(driver.findElement(By.cssSelector("#month")));
		sc1.selectByVisibleText("Jan");
		

		Select sc2 = new Select(driver.findElement(By.cssSelector("#year")));
		sc2.selectByVisibleText("1993");
		
		driver.findElement(By.xpath("//span[@data-type='radio']/span[2]/input")).click();
		
		driver.findElement(By.xpath("//button[@type='submit'] ")).click();
		
		File fc= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fc, new File(("user.dir")+"\\src\\facebook.png"));
		
		//System.out.println(driver.findElement(By.xpath("//div[@id='js_0']")).getText());
		
	}
	
	@AfterTest
	public void exit()
	{
		driver.close();
	}
}
