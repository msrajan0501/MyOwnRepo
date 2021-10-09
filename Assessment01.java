import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assessment01 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		1. Login to https://login.salesforce.com
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//			2. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
//			3. Click view All 
		driver.findElement(By.xpath("//button[text()='View All']")).click();
//			4. Click Service Console from App Launcher
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Service Console']")));
		driver.findElement(By.xpath("//p[text()='Service Console']")).click();
//			5. Select Home from the DropDown
		
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		driver.findElement(By.xpath("//span[@class='menuLabel slds-listbox__option-text slds-listbox__option-text_entity' and text()='Home']")).click();
		
		//6. Add CLOSED + OPEN values and result should set as the GOAL (If the result is less than 10000 then set the goal as 10000)
		
		List<WebElement> amt = driver.findElements(By.xpath("//span[@class='metricAmount uiOutputText']"));
		List<String> indi = new ArrayList<>();
		for (int i = 0; i < amt.size(); i++) {
			indi.add(amt.get(i).getText());
			System.out.println(amt.get(i).getText());

		}
				
		
//			7. Select Dashboards from DropDown
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		driver.findElement(By.xpath("//span[@class='menuLabel slds-listbox__option-text slds-listbox__option-text_entity' and text()='Dashboards']")).click();
//			8. Click on New Dashboard
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
//			9. Enter the Dashboard name as "YourName_Workout"
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='slds-input']")));
		Thread.sleep(5000);
				driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Mahalakshmi_Workout");
		
//			10. Enter Description as Testing and Click on Create
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Testing");
		//driver.findElement(By.xpath("//label[text()='Description']")).sendKeys("Testing");
//			11. Click on Done
		driver.findElement(By.xpath("//button[text()='Create']")).click();
//			12. Verify the Dashboard is Created
		
//			13. Click on Subscribe
//			14. Select Frequency as "Daily"
//			15. Time as 10:00 AM
//			16. Click on Save
//			17. Verify "You started Dashboard Subscription" message displayed or not
//			18. Close the "YourName_Workout" tab
//			19. Click on Private Dashboards
//			20. Verify the newly created Dashboard available
//			21. Click on dropdown for the item
//			22. Select Delete
//			23. Confirm the Delete
//			24. Verify the item is not available under Private Dashboard folder

	}

}
