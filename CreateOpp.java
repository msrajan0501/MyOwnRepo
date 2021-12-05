package normalExecn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpp {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//div[@class='al-modal-container slds-grid slds-grid_vertical slds-scrollable_none']")).click();
		WebElement content = driver.findElement(By.xpath("//div[@data-name='Content']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", content);
		WebElement link = driver.findElement(By.xpath("//span[@class='viewAllLabel' and text()='View All Key Deals']"));
		jse.executeScript("arguments[0].scrollIntoView();",link);
		jse.executeScript("arguments[0].click();", link);
		driver.findElement(By.xpath("//span[contains(@class,'triggerLinkText selectedListView')]")).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class=' virtualAutocompleteOptionText'])[1]")));
		driver.findElement(By.xpath("(//span[@class=' virtualAutocompleteOptionText'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='forceActionLink']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("SRM Steels Nov21MS");
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys("7500");
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("11/13/2021");
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div//input"));
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
	}

}
