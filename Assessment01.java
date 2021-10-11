package salesforceAuto;
import java.time.Duration;
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
		
		//1. Login to https://login.salesforce.com
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "D:\\TestLeaf\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		

		//2. Click on toggle menu button from the left corner
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		//3. Click view All 
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		//4. Click Service Console from App Launcher
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Service Console']")));
		driver.findElement(By.xpath("//p[text()='Service Console']")).click();
		
		//5. Select Home from the DropDown

		Thread.sleep(9000);
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		driver.findElement(By.xpath(
				"//span[@class='menuLabel slds-listbox__option-text slds-listbox__option-text_entity' and text()='Home']"))
				.click();

//		// 6. Add CLOSED + OPEN values and result should set as the GOAL (If the result
//		// is less than 10000 then set the goal as 10000)
//		
//		String closed = driver.findElement(By.xpath("(//span[@class='metricAmount uiOutputText'])[1]")).getText();
//		String open = driver.findElement(By.xpath("(//span[@class='metricAmount uiOutputText'])[2]")).getText();
//		
//		String clsd = closed.replace("$", "");
//		String opn = open.replace("$", "");
//		int i=Integer.parseInt(clsd);  
//		int j=Integer.parseInt(opn);
//		int total = i+j;
//		 String tot = Integer.toString(total);
//		if (total<10000) {
//			driver.findElement(By.xpath("//button[@title='Edit Goal']//lightning-primitive-icon[1]")).click();
//			driver.findElement(By.xpath("//input[contains(@class,'input uiInputSmartNumber')]")).clear();
//			driver.findElement(By.xpath("//input[contains(@class,'input uiInputSmartNumber')]")).sendKeys("10000");
//			driver.findElement(By.xpath("//span[text()='Save']")).click();
//		 }//if
//		else {
//			driver.findElement(By.xpath("//button[@title='Edit Goal']//lightning-primitive-icon[1]")).click();
//			driver.findElement(By.xpath("//input[contains(@class,'input uiInputSmartNumber')]")).clear();
//			driver.findElement(By.xpath("//input[contains(@class,'input uiInputSmartNumber')]")).sendKeys(tot);
//			driver.findElement(By.xpath("//span[text()='Save']")).click();
//			}//else*/

		//7. Select Dashboards from DropDown
		
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
	driver.findElement(By.xpath(
			"//span[@class='menuLabel slds-listbox__option-text slds-listbox__option-text_entity' and text()='Dashboards']"))
			.click();

	//8. Click on New Dashboard
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
	
	//9. Enter the Dashboard name as "YourName_Workout"

	Thread.sleep(5000);
	String name = new String ("Mahalakshmi_Workout");
	driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys(name);
	
	
	//10. Enter Description as Testing and Click on Create
	driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("Testing");
	 driver.findElement(By.xpath("//button[text()='Create']")).click();
	
	//11. Click on Done
	
	driver.findElement(By.xpath("//button[text()='Done']")).click();
	
	
	//12. Verify the Dashboard is Created
	String dname= driver.findElement(By.xpath("//span[@class='slds-page-header__title slds-truncate']")).getText();
	if (dname.equals(name))
	{System.out.println("Dashboard created successfully");}
	else
	{System.out.println("Dashboard creation failed");}
	
	//13. Click on Subscribe
	driver.findElement(By.xpath("//button[text()='Subscribe']")).click();
	
	//14. Select Frequency as "Daily"
	
	driver.findElement(By.xpath("//span[text()='Daily']")).click();
	//15. Time as 10:00 AM
	driver.findElement(By.xpath("//select[@id='time']")).click();
	driver.findElement(By.xpath("//option[text()='10:00 AM']")).click();
	//16. Click on Save
	driver.findElement(By.xpath("//span[text()='Save']")).click();

		
	}//method

}//class
