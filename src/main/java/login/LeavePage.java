package login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LeavePage {
	WebDriver driver;
	
	public LeavePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By leave = By.cssSelector("a[href*='LeaveModule']");
	private By apply = By.cssSelector("#menu_leave_applyLeave");
	private By leavetype = By.cssSelector("#applyleave_txtLeaveType");
	private By fromdate = By.xpath("//ol/li[3]/img");
	private By date 	=	By.xpath("//*[@class='ui-state-default']");
	private By todate = By.xpath("//ol/li[4]/img");
	private By date1 = By.xpath("//*[@class='ui-state-default']");
	private By partailday = By.cssSelector("#applyleave_partialDays");
	private By  endfirst = By.cssSelector("#applyleave_duration_duration");
	private By endsecond = By.cssSelector("#applyleave_firstDuration_ampm");
	private By comment = By.cssSelector("#applyleave_txtComment");
	
	private By applyleave = By.cssSelector("//input[@value='Apply']");
	
	
	
	public WebElement leave()
	{
		return driver.findElement(leave);
	}

	public WebElement apply()
	{
		return driver.findElement(apply);
	}
	public void leaveType()
	{
		Select sc = new Select( driver.findElement(leavetype));
		sc.selectByValue("2");
	}
	public void fromdate()
	{
		driver.findElement(fromdate).click();

		int count = driver.findElements(date).size();
		for(int i=0;i<count;i++)
		{
		String str = driver.findElements(date).get(i).getText();
		if(str.equalsIgnoreCase("21"))
		{
		driver.findElements(date).get(i).click();
		break;
		}
		}		
	}
	public void todate()
	{
		driver.findElement(todate).click();
		int count1 = driver.findElements(date1).size();
		for(int i=0;i<count1;i++)
		{
		String str = driver.findElements(date1).get(i).getText();
		if(str.equalsIgnoreCase("22"))
		{
		driver.findElements(date1).get(i).click();
		break;
		}
		}
		
	}
	public void partailday()
	{
		Select sc1 = new Select(driver.findElement(partailday));
		sc1.selectByIndex(1);
	}
	public void endfirst()
	{
		Select scc = new Select(driver.findElement(endfirst));
		scc.selectByIndex(0);
	}
	public void endsecond()
	{
		Select sc3 = new Select(driver.findElement(endsecond));
		sc3.selectByIndex(1);
	}
	public WebElement comment()
	{
		return driver.findElement(comment);
	}
	public WebElement applyleave()
	{
		return driver.findElement(applyleave);
	}
	
}
