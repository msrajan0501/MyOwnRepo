import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepwise {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://c6.avaamo.com/web_channels/444588bc-92fe-477f-87c1-88a92946346a/demo.html?theme=avm-messenger&banner=true&demo=true&banner_text=%20&banner_title=This%20is%20how%20the%20chat%20agent%20shows%20up");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//- Welcome Screen - Click on Notification, get that text and get into the bot.
		String notif_text = driver.findElement(By.xpath("//div[@class='avm-banner']/following-sibling::div[1]")).getText();
		System.out.println(notif_text);
		driver.findElement(By.xpath("//a[@class='avm-icon-cross']")).click();
		driver.findElement(By.xpath("//a[@class='avm-bot-avatar']")).click();
		driver.findElement(By.xpath("//a[@class='get-started-link']")).click();
		//- Type any greetings message and fetch the response message
		driver.switchTo().frame("avaamoIframe");
		driver.findElement(By.xpath("//div/button[@data-ele-name='switch_typing']")).click();
		driver.findElement(By.xpath("//div/textarea[@id='queryTextbox']")).sendKeys("hi");
		driver.findElement(By.xpath("//div/button[text()='Send']")).click();
		System.out.println(driver.findElement(By.xpath("(//p[@class='desc text-content '])[2]")).getText());
        //- Menu Options click on the “Start Over” button > Click on Download Motor Policy and Click on Download link
		driver.findElement(By.xpath("//button[@aria-label='Switch to chat agent menu']")).click();
		driver.findElement(By.xpath("//a[text()='Start Over']")).click();
		driver.findElement(By.xpath("//div/a[text()='Download Motor Policy']")).click();
		driver.findElement(By.xpath("//div/a[text()='Download']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWin = it.next();
		String childWin = it.next();
		driver.switchTo().window(childWin);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentWin);
       //- Type "Test Bot" > Fill the Form and Submit
		driver.switchTo().frame("avaamoIframe");
		driver.findElement(By.xpath("//div/textarea[@id='queryTextbox']")).sendKeys("Testbot");
		driver.findElement(By.xpath("//div/button[text()='Send']")).click();
		driver.findElement(By.xpath("//input[@class='textbox avm_accessible_txt_box_helper']")).sendKeys("IRA");
		driver.findElement(By.xpath("//div/textarea[@class='textbox avm_accessible_txt_box_helper']")).sendKeys("test address");
		driver.findElement(By.xpath("//span[text()='Male']")).click();
		driver.findElement(By.xpath("//input[@class='textbox picklist-textbox avm_pick_list_input']")).click();
		driver.findElement(By.xpath("//ul/li[text()='Rarely']")).click();
		driver.findElement(By.xpath("//label[@class='avm_rating_helper']")).click();
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
       //- Type "New Test" ​> Click on Links “Google” and close the web view. Click on call and Close the call popup
		driver.findElement(By.xpath("//div/textarea[@id='queryTextbox']")).sendKeys("New Test");
		driver.findElement(By.xpath("//div/button[text()='Send']")).click();
		driver.findElement(By.xpath("//div/a[text()='Google']")).click();
		driver.findElement(By.xpath("//button[@class='close']")).click();
		driver.findElement(By.xpath("//div/a[text()='Call']")).click();
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window("037C5E999A91B997C85E4B8378F675A9");
		System.out.println(driver.getCurrentUrl());
	}

}
