package week1.day1;


import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		
			//WebDriverManager.chromedriver().setup();
		
		   // System.setProperty("webdriver.chrome.driver","C:\\AllSoftwares\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			
			//WebDriver driver=new ChromeDriver();
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
	
	
		
			driver.close();

	}

}
