import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstTestCase {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "D:\\TestLeaf\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement element = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		String inputStr = "Salesforce Automation by Mahalakshmi05";
				driver.findElement(By.xpath("//input[@class='slds-input'and @name='Name']"))
				.sendKeys(inputStr);
		driver.findElement(By.xpath("//input[@class='slds-input'and @name='CloseDate']")).sendKeys("9/25/2021");
		driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[3]")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String outputStr = driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small')]")).getText();
		 if (outputStr.contains(inputStr)) {
				System.out.println("Test case passed");
	}
		 driver.quit();
		 }
}


