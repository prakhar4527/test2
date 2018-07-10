import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class broken_images
{
	WebDriver driver;
	public broken_images(WebDriver driver)
	{
		this.driver=driver;
		driver.findElement(By.xpath("//*[text()[contains(.,'Go to Home')]]")).click();
	}
	public void checkBrokenImage()
	{
		driver.findElement(By.xpath("//*[text()[contains(.,'Broken Images')]]")).click();

		WebElement image1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/img[1]"));
		Object result1 = ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && "+
						"typeof arguments[0].naturalWidth != \"undefined\" && "+
						"arguments[0].naturalWidth > 0", image1);
		boolean loaded1 = false;
		if (result1 instanceof Boolean) {
			loaded1 = (Boolean) result1;
			System.out.println(loaded1);
			if(loaded1==false)
			{
				String url1=image1.getAttribute("src").toString();
				System.out.println(url1);
			}
			Assert.assertEquals(loaded1, false);
		}
		WebElement image2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/img[2]"));
		Object result2 = ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && "+
						"typeof arguments[0].naturalWidth != \"undefined\" && "+
						"arguments[0].naturalWidth > 0", image2);
		boolean loaded2 = false;
		if (result2 instanceof Boolean) {
			loaded2 = (Boolean) result2;
			System.out.println(loaded2);
			if(loaded2==false)
			{
				String url2=image2.getAttribute("src").toString();
				System.out.println(url2);
			}
			Assert.assertEquals(loaded2, false);
		}
		WebElement image3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/img[3]"));
		Object result3 = ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && "+
						"typeof arguments[0].naturalWidth != \"undefined\" && "+
						"arguments[0].naturalWidth > 0", image3);
		boolean loaded3 = false;
		if (result3 instanceof Boolean) {
			loaded3 = (Boolean) result3;
			System.out.println(loaded3);
			if(loaded3==false)
			{
				String url3=image3.getAttribute("src").toString();
				System.out.println(url3);
			}
			Assert.assertEquals(loaded3, true);
		}
	}
}

