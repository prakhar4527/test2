import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class exit_intent 
{
	WebDriver driver;
	public exit_intent(WebDriver driver)
	{
		this.driver=driver;
		driver.findElement(By.xpath("//*[text()[contains(.,'Go to Home')]]")).click();
	}
	public void checkExitIntentPageIsDisplayed()
	{
		driver.findElement(By.xpath("//*[text()[contains(.,'Exit Intent')]]")).click();
		String text=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/h3")).getText();
		Assert.assertEquals(text,"Exit Intent");
	}
	public void hoverMouseOverPage() throws AWTException, InterruptedException
	{
	
	 //*  Robot Class code using TestNG
	 driver.manage().window().maximize();
		  Robot robot = new Robot();
		 // for(int i=0;i<10;i++)
		  //Thread.sleep(5000);
		  for(int i=150;i>=100;i--)
		  robot.mouseMove(746,i); 
		 // Thread.sleep(5000);
		  String text=driver.findElement(By.className("modal-title")).getText().toUpperCase();
		  driver.findElement(By.className("modal-footer")).click();
		  System.out.println(text);
		  String exp="THIS IS A MODAL WINDOW";
		  Assert.assertEquals(text, exp);
		  
	}
}

