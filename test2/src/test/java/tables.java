import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class tables 
{
	WebDriver driver;
	public tables(WebDriver driver)
	{
		this.driver=driver;
		driver.findElement(By.xpath("//*[text()[contains(.,'Go to Home')]]")).click();
	}
	public void checkLinkTable()
	{
		driver.findElement(By.xpath("//*[text()[contains(.,'Sortable Data Tables')]]")).click();
		String text=driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
		Assert.assertEquals(text,"Data Tables");
	}
	public void checkSortDue()
	{
		driver.findElement(By.xpath("//*[@id=\"table1\"]/thead/tr/th[4]/span")).click();
		double max=0;
		boolean flag=false;
		for(int i=1; i<=4; i++)
		{
			String s1=driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr["+(i)+"]/td[4]")).getText();
			String s2=s1.substring(1);
			double x=Double.parseDouble(s2);
			if(x>max)
			{
				max=x;
				flag=true;
			}
		}
		Assert.assertTrue(flag);	
	}
}

