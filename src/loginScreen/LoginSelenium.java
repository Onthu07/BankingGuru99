package loginScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginSelenium {

	public static void main(String[] args)  { // TODO Auto-generated method stub 
		System.setProperty("Webdriver.firefox.marionette", "C:\\geckodriver.exe");
		  WebDriver driver=new FirefoxDriver();
		  driver.manage().window().maximize(); 
		  driver.get("https://www.linkedin.com/login"); 
		  
		  WebElement username=driver.findElement(By.id("username")); 
		  WebElement password=driver.findElement(By.id("password"));
		  
		  WebElement login=driver.findElement(By.xpath("//button[text()='Sign in']")); 
		  username.sendKeys("onthusitse.itumeleng@gmail.com");
		  password.sendKeys("Onthu@007"); 
		 
		  login.click();
		  
		  String actualUrl="https://www.linkedin.com/feed/"; 
		  String expectedUrl= driver.getCurrentUrl();
		  
		  if(actualUrl.equalsIgnoreCase(expectedUrl))
		  
		  { 
		  System.out.println("Test passed"); }
		  
		  else { System.out.println("Test failed"); } }  

}
