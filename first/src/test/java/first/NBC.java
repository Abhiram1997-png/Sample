package first;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver=new ChromeDriver(options);
		Actions a=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.nbc.com");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("//a[text()='FAQ']")).click();
		String parent = driver.getWindowHandle();
		Set<String> handles= driver.getWindowHandles();
		System.out.println(handles.size());
		for(String s:handles)
		{
			if(!s.equals(parent))
			{
				driver.switchTo().window(s);
			}
		}
		
		System.out.println(driver.findElement(By.xpath("//*[contains(text(),'Welcome to the NBC Help Center')]")).isDisplayed());
		

	}

}
