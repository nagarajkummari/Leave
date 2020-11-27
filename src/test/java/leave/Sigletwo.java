package leave;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageobject.Base;

public class Sigletwo extends Base {
	WebDriver driver;
	public void bftest() throws IOException {
		driver = intial();
		System.out.println("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void test() throws IOException {
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin123");
		driver.findElement(By.cssSelector("#btnLogin")).click();

		driver.findElement(By.cssSelector("#menu_leave_viewLeaveModule")).click();
		driver.findElement(By.cssSelector("#menu_leave_applyLeave")).click();
		Select sc = new Select(driver.findElement(By.cssSelector("#applyleave_txtLeaveType")));
		sc.selectByIndex(1);

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
			if (str.equalsIgnoreCase("20")) {
				driver.findElements(By.xpath("//*[@class='ui-state-default']")).get(i).click();
				break;
			}
		}
		Select sc1 = new Select(driver.findElement(By.cssSelector("#applyleave_duration_duration")));
		sc1.selectByIndex(2);
		Select scc = new Select(driver.findElement(By.cssSelector("#applyleave_duration_time_from")));
		scc.selectByVisibleText("09:00");
		Select sccc = new Select(driver.findElement(By.cssSelector("#applyleave_duration_time_to")));
		sccc.selectByVisibleText("09:30");
		driver.findElement(By.cssSelector("#applyleave_txtComment")).sendKeys("carona");

		driver.findElement(By.cssSelector("#applyBtn")).click();
		File ts = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ts, new File(System.getProperty("user.dir") + "\\screen\\cren.png"));
	}

	@AfterTest
	public void exit() {
		driver.close();
	}

}
