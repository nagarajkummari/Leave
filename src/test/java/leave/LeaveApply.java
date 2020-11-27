package leave;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import login.LandingURL;
import login.LeavePage;
import pageobject.Base;

public class LeaveApply extends Base {
	WebDriver driver;

	@BeforeTest
	public void landing() throws IOException {
		driver = intial();
		// driver.get(pro.getProperty("url"));
		System.out.println("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void landingOnLeavePage() throws InterruptedException {
		LandingURL land = new LandingURL(driver);
		land.name().sendKeys("Admin");
		land.password().sendKeys("admin123");
		LeavePage leave = land.login();
		leave.leave().click();
		leave.apply().click();
		leave.leaveType();
		leave.fromdate();
		leave.todate();
		leave.partailday();
		leave.endfirst();
		leave.endsecond();
		leave.comment().sendKeys("due to covid 19");
		leave.apply().click();
		Thread.sleep(3000);
	}

	@AfterTest
	public void exit() {
		driver.close();
	}
}
