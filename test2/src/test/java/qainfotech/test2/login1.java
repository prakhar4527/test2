package qainfotech.test2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class login1 
{
	WebDriver driver;
	JavascriptExecutor js=(JavascriptExecutor) driver;
	public login1(WebDriver driver)
	{
		this.driver=driver;
	}
	public void clickOnFormVadilation()
	{
		WebElement pro1=driver.findElement(By.xpath("//*[text()[contains(.,'Form Authentication')]]"));
		pro1.click();
		 String title=driver.getTitle();
	      Assert.assertEquals(title, "QA InfoTech Selenium Test Site");//Verify Login Page is displayed
	}
	public void verifyErrorMessage()
	{
		driver.findElement(By.id("username")).sendKeys("Prakhar");
		driver.findElement(By.id("password")).sendKeys("dfozjvnfgbkl");
		driver.findElement(By.className("radius")).click();
		//WebElement re = driver.findElement(By.xpath("//*[text()[contains(.,'Your username is invalid!')]]"));	
		String actual_msg=driver.findElement(By.id("flash")).getText();
		String expect="Your username is invalid!\n" + 
				"×";
		//System.out.print(actual_msg);
		Assert.assertEquals(actual_msg, expect);//Verify error message is displayed on Login page
	}
}
