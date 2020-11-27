package leave;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.Base;

public class SingleShot extends Base {
	//WebDriver driver;

	@BeforeTest
	public void bftest() throws IOException {
		//driver = intial();
		//System.out.println("chrome");
		String path = System.getProperty(("user.dir")+"\\Driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", path);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@Test
	public void single() throws IOException {

		driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin123");
		driver.findElement(By.cssSelector("#btnLogin")).click();

		driver.findElement(By.cssSelector("#menu_leave_viewLeaveModule")).click();
		driver.findElement(By.cssSelector("#menu_leave_applyLeave")).click();
		Select sc = new Select(driver.findElement(By.cssSelector("#applyleave_txtLeaveType")));
		sc.selectByIndex(2);

		driver.findElement(By.xpath("//ol/li[3]/img")).click();

		int count = driver.findElements(By.xpath("//*[@class='ui-state-default']")).size();
		for (int i = 0; i < count; i++) {
			String str = driver.findElements(By.xpath("//*[@class='ui-state-default']")).get(i).getText();
			if (str.equalsIgnoreCase("20")) {
				driver.findElements(By.xpath("//*[@class='ui-state-default']")).get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//ol/li[4]/img")).click();

		int count1 = driver.findElements(By.xpath("//*[@class='ui-state-default']")).size();
		for (int i = 0; i < count1; i++) {
			String str = driver.findElements(By.xpath("//*[@class='ui-state-default']")).get(i).getText();
			if (str.equalsIgnoreCase("21")) {
				driver.findElements(By.xpath("//*[@class='ui-state-default']")).get(i).click();
				break;
			}
		}
		Select sc1 = new Select(driver.findElement(By.cssSelector("#applyleave_partialDays")));
		sc1.selectByIndex(1);
		Select scc = new Select(driver.findElement(By.cssSelector("#applyleave_duration_duration")));
		scc.selectByIndex(0);
		Select sc3 = new Select(driver.findElement(By.cssSelector("#applyleave_firstDuration_ampm")));
		sc3.selectByIndex(1);
		driver.findElement(By.cssSelector("#applyleave_txtComment")).click();
		driver.findElement(By.cssSelector("#applyleave_txtComment")).sendKeys("second");

		driver.findElement(By.cssSelector("#applyBtn")).click();
		// System.out.println(driver.switchTo().alert().getText());
		File ts = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ts, new File(System.getProperty("user.dir") + "\\screen\\cren.png"));
	}

	@AfterTest
	public void exit() {
		driver.close();
	}
}
