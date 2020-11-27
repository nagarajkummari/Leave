package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingURL {
	WebDriver driver;
	public LandingURL(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username = By.id("txtUsername");
	By password = By.id("txtPassword");
	By login = By.cssSelector("#btnLogin");
	public WebElement name()
	{
		return driver.findElement(username);
	}
	public WebElement password()
	{
		return driver.findElement(password);
	}
	public LeavePage login()
	{
		driver.findElement(login).click();;
		return new LeavePage(driver);
	}
	
}
