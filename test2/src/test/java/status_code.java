import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class status_code 
{
	WebDriver driver;
	public status_code(WebDriver driver)
	{
		this.driver=driver;
		driver.findElement(By.xpath("//*[text()[contains(.,'Go to Home')]]")).click();
	}
	public void checkLinkStatusCodes()
	{
		driver.findElement(By.xpath("//*[text()[contains(.,'Status Codes')]]")).click();
		String text=driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
		Assert.assertEquals(text,"Status Codes");
	}
	public void check404Link()
	{
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/a")).click();
		String s=driver.findElement(By.tagName("p")).getText();
		String s2=s.substring(0,37);
		String s1="This page returned a 404 status code.";
		//System.out.println(s2);
		Assert.assertEquals(s2, s1);
	}
}
