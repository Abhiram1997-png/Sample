package first;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstDriver {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.youtube.com");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("input[id='search']")).sendKeys("ragadi");
		
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("button[id='search-icon-legacy']")).click();
		driver.findElement(By.cssSelector("div[id='search-clear-button']")).click();
		

	}

}
