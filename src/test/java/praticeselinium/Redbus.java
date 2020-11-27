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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Redbus{
	
	
	WebDriver driver;
	ExtentReports extent = Report.report();
	ExtentTest test;
	@BeforeTest
	public void landing()
	{	
		String path = System.getProperty("user.dir")+"\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("https://www.redbus.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void redbus() throws InterruptedException, IOException
	{
		test = extent.createTest("Booking the ticket");
		WebElement from = driver.findElement(By.cssSelector("#src"));
		from.click();
		from.sendKeys("HYD");
		Thread.sleep(2000);
		from.sendKeys(Keys.ARROW_DOWN , Keys.ENTER);
		
		WebElement to = driver.findElement(By.cssSelector("#dest"));
		to.click();
		to.sendKeys("KUR");
		Thread.sleep(2000);
		to.sendKeys(Keys.ARROW_DOWN , Keys.ENTER);
		int count = driver.findElements(By.cssSelector("td[class='wd day']")).size();
		for(int i=0;i<count;i++)
		{
		String str=	driver.findElements(By.cssSelector("td[class='wd day']")).get(i).getText();
			if(str.equalsIgnoreCase("25"))
			{
				driver.findElements(By.cssSelector("td[class='wd day']")).get(i).click();
			}
			
		}
		int count1 = driver.findElements(By.cssSelector("td[class='wd day']")).size();
		for(int i=0;i<count1;i++)
		{
		String str=	driver.findElements(By.cssSelector("td[class='wd day']")).get(i).getText();
			if(str.equalsIgnoreCase("30"))
			{
				driver.findElements(By.cssSelector("td[class='wd day']")).get(i).click();
			}
			
		}
		
		
		
		driver.findElement(By.cssSelector("#search_btn")).sendKeys(Keys.CONTROL,Keys.ENTER);
		
		File fs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fs, new File("\\Redbus\\book.png"));
		//test.addScreenCaptureFromPath("Nagaraju", "Ticket");
		
		
		
	}
	
	@AfterTest
	public void exit()
	{	
		extent.flush();
		driver.close();
	}

}
