package pageobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	public Properties pro;
	public WebDriver intial() throws IOException
	{
		Properties pro = new Properties();
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\pageobject\\properties");
		FileInputStream fis = new FileInputStream("C:\\Users\\VENKAT\\eclipse-workspace\\Leave\\src\\main\\java\\pageobject\\properties");
		pro.load(fis);
		
		String browserName = pro.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{	
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(browserName.equals("FireFox"))
		{	
			String geckodriver = System.getProperty(("user.dir")+"\\Driver\\firefoxdriver.exe");
			System.setProperty("webdriver.gecko.driver", geckodriver);
			driver = new FirefoxDriver();
		}
		if(browserName.equals("chromeheadless"))
		{	
			String geckodriver = System.getProperty(("user.dir")+"\\Driver\\firefoxdriver.exe");
			System.getProperty("webdriver.gecko.driver", geckodriver);
			driver = new FirefoxDriver();
		}
		return driver;
		
		
	}
}
