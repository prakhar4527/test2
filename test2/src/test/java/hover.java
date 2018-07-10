import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class hover 
{
	WebDriver driver;
	public hover(WebDriver driver)
	{
		this.driver=driver;
		driver.findElement(By.xpath("//*[text()[contains(.,'Go to Home')]]")).click();
	}
	public void checkHoverLink()
	{
		driver.findElement(By.xpath("//*[text()[contains(.,'Hovers')]]")).click();
		String text=driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
		Assert.assertEquals(text,"Hovers");
		 List<WebElement> listImages=driver.findElements(By.className("figure"));
		 System.out.println("No. of Images: "+listImages.size());
		 Assert.assertEquals(listImages.size(), 3);
	}
	public void checkHoverImage()
	{
		WebElement web_Element_To_Be_Hovered = driver.findElement(By.cssSelector("#content > div > div:nth-child(3) > img"));
		Actions builder = new Actions(driver);
		builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a")).isDisplayed(), true);
	}
	public void checkRemoveMouseOverImage()
	{
		driver.navigate().refresh();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a")).isDisplayed(), false);
	}
}
