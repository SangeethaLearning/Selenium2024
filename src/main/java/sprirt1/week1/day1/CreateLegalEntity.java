


/*	1. Login to https://login.salesforce.com
	2. Click on the toggle menu button from the left corner
	3. Click View All and click Legal Entities from App Launcher
	4. Click on the Dropdown icon in the legal Entities tab
	5. Click on New Legal Entity
	6. Enter Name as 'Salesforce Automation by Your Name'
	7.Click save and verify Legal Entity Name
*/


package sprirt1.week1.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLegalEntity {

	public static void main(String[] args) throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver=new ChromeDriver(options);
		
		driver.get("https://login.salesforce.com/");
		
		driver.findElement(By.id("username")).sendKeys("bootcamp_2024@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		driver.findElement(By.id("Login")).click();
		
		
		
		//driver.findElement(By.xpath("")).click();

		Thread.sleep(3000);
		
		WebElement appLauncher = driver.findElement(By.className("slds-icon-waffle"));
		appLauncher.click();
		
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		//WebElement viewAll = driver.findElement(By.xpath("(//button[@class='slds-button'])[2]"));
		//viewAll.click();
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");
		//WebElement searchAppsOr = driver.findElement(By.xpath("(//input[@class='slds-input'])[2]"));
		//searchAppsOr.sendKeys("Legal Entities");
		

	

		
		driver.findElement(By.xpath("//mark[text()='Legal Entities']")).click();
		
		Thread.sleep(2000);
		
		//WebElement dropdown1=driver.findElement(By.xpath("html[1]/body[1]/div[4]/div[1]/section[1]/div[1]/div[1]/one-appnav[1]/div[1]/one-app-nav-bar[1]/nav[1]/div[1]/one-app-nav-bar-item-root[18]/one-app-nav-bar-item-dropdown[1]/div[1]/one-app-nav-bar-menu-button[1]/a[1]/lightning-icon[1]/span[1]/lightning-primitive-icon[1]"));
		WebElement dropdown1 = driver.findElement(By.xpath("//one-app-nav-bar-item-root[@data-id='0QkdM0000008RsfSAE']//div"));
		dropdown1.click();
		Thread.sleep(1000);
		Select dropdown2=new Select(dropdown1);
		
		List<WebElement> opt = dropdown2.getOptions();
	    for (WebElement we : opt) 
	    {
	        String name = we.getText();
            if(name=="New Legal Entity")
            {
            	dropdown2.selectByVisibleText(name);
            }
	    }
		//dropdown2.selectByIndex(0);
		
	
		driver.quit();

		
 

	}
	

}
//div[@class='slds-icon-waffle']