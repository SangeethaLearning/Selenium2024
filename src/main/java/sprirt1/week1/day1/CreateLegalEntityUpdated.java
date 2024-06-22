


/*	1. Login to https://login.salesforce.com
	2. Click on the toggle menu button from the left corner
	3. Click View All and click Legal Entities from App Launcher
	4. Click on the Dropdown icon in the legal Entities tab
	5. Click on New Legal Entity
	6. Enter Name as 'Salesforce Automation by Your Name'
	7. Click save and verify Legal Entity Name
*/


package sprirt1.week1.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLegalEntityUpdated {

	public static void main(String[] args) throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Login to https://login.salesforce.com
		
		driver.get("https://login.salesforce.com/");
		
		driver.findElement(By.id("username")).sendKeys("bootcamp_2024@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		driver.findElement(By.id("Login")).click();
		
		//Click on the toggle menu button from the left corner
		
		WebElement appLauncher = driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[1]/div/div/div[1]/one-app-launcher-header/button/div"));
		appLauncher.click();
		
		
		//Click View All and click Legal Entities from App Launcher
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");

		driver.findElement(By.xpath("//mark[text()='Legal Entities']")).click();
		
		//Click on the Dropdown icon in the legal Entities tab
		
		WebElement dropdown1 = driver.findElement(By.xpath("//a[@title='Legal Entities']/following-sibling::one-app-nav-bar-item-dropdown//a/lightning-icon"));
		dropdown1.click();
		
		//Click on New Legal Entity
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		    
		WebElement newLegalEntity = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));

		js.executeScript("arguments[0].click()",newLegalEntity);
		
		//Enter Name as 'Salesforce Automation by Your Name' 
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
		WebElement text= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='Name']")));
		text.sendKeys("Salesforce Automation by Your Name");
		
		//Click save and verify Legal Entity Name
		   
		 driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();
	     WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(3));
		 WebElement verify1= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Salesforce Automation by Your Name']/parent::a")));
		 String verify2=verify1.getText();
		 System.out.println(verify2);
		   
		 driver.close();
		 driver.quit();


		

	}
	

}
