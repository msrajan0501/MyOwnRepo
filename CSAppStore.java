import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CSAppStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Launch Salesforce application https://login.salesforce.com/
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "D:\\TestLeaf\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//2. Login with username as "makaia@testleaf.com" and password as "India@123"
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		//3. Click on the sliding icon until "Download SalesForceA" is displayed
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']")).click();
		if (driver.findElement(By.xpath("//span[text()='Download SalesforceA']")).
		isDisplayed()) {
		 driver.findElement(By.xpath("//span[text()='Download SalesforceA']")).click(); } 
		else 
		{ driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']")).click(); 
		}
		driver.findElement(By.xpath("//span[text()='Download SalesforceA']")).click();
		String parentWindow = driver.getWindowHandle();
			//4. Click on App Strore link
		driver.findElement(By.xpath("//button[@title='App Store']")).click();
			//5. Navigate to the new window 
		   //6. Get the link displayed and click confirm
		  //7. Verify url https://apps.apple.com/us/app/salesforcea/<id> loaded 
		Set<String> handles =  driver.getWindowHandles();
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		          driver.switchTo().window(windowHandle);
		        System.out.println(driver.findElement(By.xpath("//p[@class='warning']")).getText());
		        driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		        String url= driver.getCurrentUrl();
		        String ud = "https://apps.apple.com/us/app/salesforcea/id731117958";
		        if (url.equals(ud))
		        	System.out.println("Download link is available now");
		         driver.close();
		         driver.switchTo().window(parentWindow); 
		         driver.quit();
		          }
		       }
			
	}

}
