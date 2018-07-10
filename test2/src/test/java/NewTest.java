import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import qainfotech.test2.login1;

public class NewTest 
{
	WebDriver driver;
	login1 lg1 ;
	login2 lg2 ;
	basic_auth ba;
	broken_images bi;
	exit_intent ei;
	tables t;
	hover h;
	status_code sc;
	wyswyg w;
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
		ba=new basic_auth(driver);
	}
	@Test(dependsOnMethods={"checkLogin2"})
	public void checkBasic_Auth()
	{
		ba.openLinkBasicAuth();
		bi=new broken_images(driver);
	}
	@Test(dependsOnMethods={"checkBasic_Auth"})
	public void verifyBrokenImages()
	{
		bi.checkBrokenImage();
		ei=new exit_intent(driver);
	}
	@Test(dependsOnMethods={"verifyBrokenImages"})
	public void testOfExitIntent() throws AWTException, InterruptedException
	{
		ei.checkExitIntentPageIsDisplayed();
		ei.hoverMouseOverPage();
	}
	@Test(dependsOnMethods={"testOfExitIntent"})
	public void testOftableLink()
	{
		t=new tables(driver);
		t.checkLinkTable();
		t.checkSortDue();
	}
	@Test(dependsOnMethods={"testOftableLink"})
	public void testOfhoverLink()
	{
		h=new hover(driver);
		h.checkHoverLink();
		h.checkHoverImage();
		h.checkRemoveMouseOverImage();
	}
	@Test(dependsOnMethods={"testOfhoverLink"})
	public void testOfStatusCodesLink()
	{
		sc=new status_code(driver);
		sc.checkLinkStatusCodes();
		sc.check404Link();
	}
	@Test(dependsOnMethods={"testOfStatusCodesLink"})
	public void testOfwyswygLink()
	{
		w=new wyswyg(driver);
		w.checkLinkwyswyg();
		w.text();
	}
}

