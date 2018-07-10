import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class login2 
{
	WebDriver driver;
	JavascriptExecutor js=(JavascriptExecutor) driver;
	public login2(WebDriver driver)
	{
		this.driver=driver;
	}
	public void  checkValidCredentials()
	{
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.className("radius")).click();
		String actual_msg=driver.findElement(By.className("example")).getText();
		String expect = "Secure Area\n" + 
				"Welcome to the Secure Area. When you are done click logout below.\n" + 
				"Logout";
	//	System.out.print(actual_msg);
		Assert.assertEquals(actual_msg, expect);// Verify Secure Area page is displayed
	}
	public void checkLogout()
	{
		//driver.findElement(By.className(".button.secondary.radius")).click();
		driver.findElement(By.cssSelector(".button.secondary.radius")).click();
		 String title=driver.getTitle();
		  Assert.assertEquals(title, "QA InfoTech Selenium Test Site");//Verify Login Page is displayed
	}
}