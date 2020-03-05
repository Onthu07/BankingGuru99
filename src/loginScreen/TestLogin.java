package loginScreen;

import org.testng.annotations.Test;
import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

@Test
public class TestLogin {
	 
	String baseURL = "http://www.demo.guru99.com/V4";
	String expTitle = "Guru99 Bank Home Page";
	String ActTitle = "";
	WebDriver driver;

	@BeforeTest
	public void LaunchBrowser() {
		driver = new FirefoxDriver();
		System.out.println("Launching the Browser");
		System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
		driver.get(baseURL);

	}

	@BeforeMethod
	public void VerifyHomePage() {
		
		System.out.println("Testing the Home Tittle ");
		ActTitle = driver.getTitle();
		
		if (ActTitle.contentEquals(expTitle))
			System.out.println("Tittle Matched");
		else
			System.out.println("Tittle dd not match!");
	}

	        @Test(priority = 0)
	        public void logIn() {
	        	
	         System.out.println("Test the Login ");
             WebElement UserId = driver.findElement(By.xpath("//input[@name='uid']"));
             UserId.sendKeys("mngr214418");
             
             WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
             password.sendKeys("qEYgUv");
             
	        }
	        
	        @Test(priority = 1)
	        
	        public void  SuccessLogin() {
	        	
	        	driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	    		
	    		

	    		String actualURL = "http://www.demo.guru99.com/V4/manager/Managerhomepage.php";
	    		String expectURL = driver.getCurrentUrl();

	    		if (actualURL.equalsIgnoreCase(expectURL)) 
	    			System.out.println("Test Passed.");
	    		 else 
	    			driver.switchTo().alert().accept();
	    		
	    		    System.out.println("Login Failed");
	    		


	        
	        
	        
	        }

	@AfterMethod
	public void goBackTotheLoginScreen() {
		
		driver.navigate().back();
	}

	@AfterTest
	public void terminateBroser() {
		
//	driver.close();
	}

}
