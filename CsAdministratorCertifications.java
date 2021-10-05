import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CsAdministratorCertifications {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 1. Launch Salesforce application https://login.salesforce.com/

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "D:\\TestLeaf\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();

		// 2. Login with username as "makaia@testleaf.com" and password as "India@123"

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 3. Click on Learn More link in Mobile Publisher

		driver.findElement(By.xpath("//span[text()='Learn More']")).click();

		// 4.Navigate to Create and publish custom-branded mobile apps.
		Set<String> windows = driver.getWindowHandles();// [parentid,childid,subchildId]
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);

		// 5. Mouse hover on resources and select SalesForce Certification

		WebElement resources = (WebElement) js.executeScript(
				"return document.querySelector('#c360-hgf-nav').shadowRoot.querySelector('header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul')");
		js.executeScript("arguments[0].focus();", resources);
		WebElement sfCert = (WebElement) js.executeScript(
				"return document.querySelector('#c360-hgf-nav').shadowRoot.querySelector('header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > div > div > div > div:nth-child(2) > ul > li > div.sub-nav > ul > li:nth-child(3) > a > span:nth-child(1')");
		js.executeScript("arguments[0].click();", sfCert);

		// 6. Navigate to Certification-Administrator Overview

		Set<String> win = driver.getWindowHandles();
		Iterator<String> it1 = win.iterator();
		String parent = it1.next();
		String child1 = it1.next();
		String child2 = it1.next();
		driver.switchTo().window(child2);
		// 7. Click on SalesForce Administrator

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Salesforce Administrator']")).click();

		// 8. Verify the Certifications available for Administrator

		List<WebElement> cert = driver.findElements(By.xpath("//div[@class='Fz(16px) Lh(18px) Fw(b) Pv(5px)']"));
		List<String> indi = new ArrayList<>();
		for (int i = 0; i < cert.size(); i++) {
			indi.add(cert.get(i).getText());
			System.out.println(cert.get(i).getText());

		}

		ArrayList<String> ud = new ArrayList<>(Arrays.asList("Administrator", "Advanced Administrator",
				"CPQ Specialist", "Marketing Cloud Administrator", "Platform App Builder"));
		if (indi.equals(ud)) {
			System.out.println("TC Passed");
		} else {
			System.out.println("TC Failed");
		}

	}

}
