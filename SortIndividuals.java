import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SortIndividuals {

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
		// 4. Click the sort arrow in the Name
		// driver.findElement(By.xpath("//span[text()='Name']")).click();
		// 5. Verify the Individuals displayed in ascending order by Name.
		// capture all web elements into list
		List<WebElement> names = driver
				.findElements(By.xpath("//th[@class = 'slds-cell-edit lockTrigger cellContainer']"));

		// Moving the list of webelements to arraylist
		List<String> indi = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			indi.add(names.get(i).getText());
			System.out.println(names.get(i).getText());

		}
		// compare the as-is list with sorted list
		Collections.sort(indi);
		List<String> sortLt = new ArrayList<>();
		for (String itr : indi) {
			sortLt.add(itr);
			System.out.println(itr);
		}

		if (indi.equals(sortLt) == true) {
			System.out.println("Sorted in ascending order");
		} else {
			System.out.println(" Not Sorted alphabetically");
		}

		driver.quit();
	}

}
