import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class basic_auth 
{
	WebDriver driver;
	JavascriptExecutor js=(JavascriptExecutor) driver;
	public basic_auth(WebDriver driver)
	{
		this.driver=driver;
	WebElement pro1=driver.findElement(By.xpath("//*[text()[contains(.,'Go to Home')]]"));
		pro1.click();
    
	}
	public void openLinkBasicAuth()
{
//		WebElement pro1=driver.findElement(By.xpath("//*[text()[contains(.,'Basic Auth')]]"));
//		pro1.click();
//	/*	Alert alert=driver.switchTo().alert();
//		System.out.println(alert.getText());*/
	//driver.get("http://10.0.31.161:9292/");
		driver.get("http://admin:admin@10.0.31.161:9292/basic_auth");
	//driver.navigate().to("http://admin:admin@http://10.0.31.161:9292/basic_auth");
	}
}