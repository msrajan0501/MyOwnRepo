import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteIndividuals {

	public static void main(String[] args) throws InterruptedException {
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
		// 4. Click on the Individuals tab
		
		// 5. Search the Individuals 'Kumar'
		String ln = "Soundararajan";
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='slds-input' and @name='Individual-search-input']")));
		driver.findElement(By.xpath("//input[@class='slds-input' and @name='Individual-search-input']")).sendKeys(ln + "\n");
		// 6. Click on the Dropdown icon and Select Delete
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']//span[1]")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		// 7.Click on the Delete option in the displayed popup window.
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Delete']//span[1]")).click();
		// 8. Verify Whether Individual is Deleted using Individual last name
		String tm = driver.findElement(By.xpath("//div[contains(@class,'slds-theme--success slds-notify--toast')]")).getText();
		driver.findElement(By.xpath("//div[contains(@class,'slds-theme--success slds-notify--toast')]")).click();
		if (tm.contains(ln))
		System.out.println("The Individual was deleted successfully");
		driver.quit();
	}

}
