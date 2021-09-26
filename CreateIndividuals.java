import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateIndividuals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. Login to https://login.salesforce.com
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
		// 2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		// 3. Click View All and click Individuals from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Indi = driver.findElement(By.xpath("//p[text()='Individuals']"));
		js.executeScript("arguments[0].scrollIntoView();", Indi);
		driver.findElement(By.xpath("//p[text()='Individuals']")).click();
		// 4. Click on the Dropdown icon in the Individuals tab

		// 5. Click on New Individual
		driver.findElement(By.xpath("//div[text()='New']")).click();
		// 6. Enter the Last Name as 'Kumar'
		String Lastname = "Soundararajan";
		driver.findElement(By.xpath("//input[contains(@class,'lastName')]")).sendKeys(Lastname);
		// 7.Click save and verify Individuals Name
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		String LastnameNew = driver
				.findElement(By.xpath("//div[contains(@class,'slds-theme--success slds-notify--toast')]")).getText();
		if (LastnameNew.contains(Lastname)) {
			System.out.println("Create Individuals TC passed");
		}
        driver.quit();
	}

}
