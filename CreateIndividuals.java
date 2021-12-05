package normalExecn;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CreateIndividuals {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setPlatform(Platform.MAC);
		dc.setBrowserName("chrome");
		// 1. Login to https://login.salesforce.com
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver(ops);
		//WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dc);
		WebDriver driver = new RemoteWebDriver(new URL("https://oauth-mahalakshmi5191-8dd58:ac1f89f4-7159-46f5-b276-1c2b39037a7c@ondemand.eu-central-1.saucelabs.com:443/wd/hub"),dc);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		/*// 2. Click on the toggle menu button from the left corner
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		// 3. Click View All and click Individuals from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Indi = driver.findElement(By.xpath("//p[text()='Individuals']"));
		js.executeScript("arguments[0].scrollIntoView()", Indi);
		driver.findElement(By.xpath("//p[text()='Individuals']")).click();
		// 4. Click on the Dropdown icon in the Individuals tab

		// 5. Click on New Individual
		driver.findElement(By.xpath("//div[text()='New']")).click();
		// 6. Enter the Last Name as 'Kumar'
		String Lastname = "Bachchan";
		driver.findElement(By.xpath("//input[contains(@class,'lastName')]")).sendKeys(Lastname);
		// 7.Click save and verify Individuals Name
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		String LastnameNew = driver
				.findElement(By.xpath("//div[contains(@class,'slds-theme--success slds-notify--toast')]")).getText();
		if (LastnameNew.contains(Lastname)) {
			System.out.println("Create Individuals TC passed");
		}*/
        driver.quit();
	}

}
