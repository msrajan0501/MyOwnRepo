import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditIndividual {

	public static void main(String[] args) throws InterruptedException {

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
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='slds-input' and @name='Individual-search-input']")));
		driver.findElement(By.xpath("//input[@class='slds-input' and @name='Individual-search-input']")).sendKeys("Soundararajan" + "\n");
		//driver.findElement(By.xpath("//label[text()='Search this list...']/following::input")).sendKeys("Soundararajan" + "\n");
		
		// 6. Click on the Dropdown icon and Select Edit
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']//span[1]")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
		// 7.Select Salutation as 'Mr'
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[@title='Mr.']")).click();
		
		// 8.Enter the first name as 'Ganesh'.
		driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys("Mahalakshmi");
		
		// 9. Click on Save and Verify the first name as 'Ganesh'
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		String Editedname = driver
				.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small')]")).getText();
		if (Editedname.contains("Mahalakshmi Soundararajan")) {
			System.out.println("Individual edited successfully");
		}
		driver.quit();
	}

}
