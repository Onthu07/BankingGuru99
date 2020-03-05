package loginScreen;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class LoginScreen {

	public static void main(String[] args) {
		System.setProperty("Webdriver.firefox.marionette", "C:\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		String baseURL = "http://www.demo.guru99.com/V4/";
		String expTitle = "Guru99 Bank Home Page";
		String actTitle = "";

		driver.get(baseURL);
		actTitle = driver.getTitle();

		if (actTitle.contentEquals(expTitle))
			System.out.println("Tittle Matched");
		else
			System.out.println("Title did not Match!!");

		WebElement UserId = driver.findElement(By.xpath("//input[@name='uid']"));
		UserId.sendKeys("mngr214418");

		WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		Password.sendKeys("qErYUv");

		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		driver.switchTo().alert().accept();

		String actualURL = "http://www.demo.guru99.com/V4/manager/Managerhomepage.php";
		String expectURL = driver.getCurrentUrl();

		if (actualURL.equalsIgnoreCase(expectURL)) {
			System.out.println("Test Passed.");
		} else {
			System.out.println("Test Failed!");
		}

		//driver.close();
	}

}
