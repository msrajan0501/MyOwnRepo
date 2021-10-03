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

public class LegalEntitiesSort {

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
		// 3. Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Indi = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		js.executeScript("arguments[0].scrollIntoView()", Indi);
		driver.findElement(By.xpath("//p[text()='Legal Entities']")).click();
		// 4. Click on the legal Entities tab
		// 5. Click the sort arrow in the Last Modified Date.
		// driver.findElement(By.xpath("//span[text()='Last Modified Date']")).click();
		List<WebElement> udates = driver.findElements(By.xpath("//span[@class='slds-truncate uiOutputDateTime']"));
		List<String> usplit = new ArrayList<>();
		for (int i = 0; i < udates.size(); i++) {
			usplit.add(udates.get(i).getText());
			System.out.println("Default Form" + udates.get(i).getText());

		}

		WebDriverWait wait = new WebDriverWait(driver, 10);
		for (int i = 0; i <= 1; i++) {
			WebElement lastModDate = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Last Modified Date']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", lastModDate);
			Thread.sleep(3000);
		}

		// 6. Verify the Legal Entities displayed in ascending order by Last Modified
		// Date.
		List<WebElement> dates = driver.findElements(By.xpath("//span[@class='slds-truncate uiOutputDateTime']"));
		List<String> split = new ArrayList<>();
		for (int i = 0; i < dates.size(); i++) {
			split.add(dates.get(i).getText());
			System.out.println("Sorted Form" + dates.get(i).getText());

		}

		if (usplit.equals(split)) {
			System.out.println("Dates not sorted in ascending order");
		} else {
			System.out.println("Dates sorted in ascending order");
		}

		driver.quit();
	}

}
