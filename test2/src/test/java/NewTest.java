import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import qainfotech.test2.login1;

public class NewTest 
{
	WebDriver driver;
	login1 lg1 ;
	login2 lg2 ;
	@Test
	public void LaunchBrowser()
	{
		driver = new ChromeDriver();
		driver.get("http://10.0.31.161:9292/");
		lg1 =new login1(driver);
	}
	@Test(dependsOnMethods={"LaunchBrowser"})
	public void checkLogin1()
	{
		lg1.clickOnFormVadilation();  
		lg1.verifyErrorMessage();
		lg2 =new login2(driver);
	}
	@Test(dependsOnMethods={"checkLogin1"})
	public void checkLogin2()
	{
		lg2. checkValidCredentials();  
		lg2.checkLogout();
	}
}

