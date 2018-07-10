import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class wyswyg 
{
	WebDriver driver;
	public wyswyg(WebDriver driver)
	{
		this.driver=driver;
		driver.findElement(By.xpath("//*[text()[contains(.,'Go to Home')]]")).click();
	}
	public void checkLinkwyswyg()
	{
		driver.findElement(By.linkText("WYSIWYG Editor")).click();
		WebElement editor=driver.findElement(By.xpath("//*[@id=\"mceu_13-body\"]"));
		boolean ActualResult = editor.isDisplayed();
		Assert.assertTrue(ActualResult);
	}
public void text() {
		
	    driver.switchTo().frame("mce_0_ifr");
	    driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).clear();
	    driver.findElement(By.id("tinymce")).sendKeys("QA Infotech");
	    driver.findElement(By.id("tinymce")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	   
	    driver.switchTo().defaultContent();
	    driver.findElement(By.xpath("//*[@id=\"mceu_3\"]/button/i")).click();
	    driver.switchTo().frame("mce_0_ifr");
	    String Expected="QA Infotech";
	    String Actual=driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p/strong")).getText();
	    System.out.println(Actual);
	    Assert.assertEquals(Actual, Expected);
	}
}

