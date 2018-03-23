package wolters.Controllers;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class Sample {

	 WebDriver driver = new ChromeDriver();
	 String URL = "http://localhost/ITrade/WebApps/LoginHome/Home.aspx";
		
@Test(priority=1)
	public void Login()
	{
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUserName")).sendKeys("donto");
		driver.findElement(By.id("txtPassword")).sendKeys("jmon@88");
		driver.findElement(By.id("btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

@Test(priority=2)
	public void submitpreclearReq() throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(".//div[@id='Header_iTradeMenu1_radiTradeMenu']/ul/li[3]/a/span"))).build().perform();
		WebElement target = driver.findElement(By.xpath(".//div[@id='Header_iTradeMenu1_radiTradeMenu']/ul/li[3]/div/ul/li[2]/a/span"));
		act.moveToElement(target).build().perform();
		target.click();
		
		WebElement secType = driver.findElement(By.id("ctlSecurityAutoSuggest_radcmbST_exRadCombo_Input"));
		secType.clear();
		secType.sendKeys("CALL OPTION");
		secType.sendKeys(Keys.ENTER);
		
		WebElement lookup = driver.findElement(By.id("ctlSecurityAutoSuggest_btnAdvLookup"));
		lookup.click();
		driver.switchTo().frame("SecurityDialog");
		System.out.println(driver.findElement(By.id("txtCusip")).isDisplayed());
		driver.findElement(By.id("txtCusip")).sendKeys("AAEX");
		
		
		
		
	}
		
@AfterTest
	public void closeBrowser()
	{
	
		//driver.close();
	}
	

}
