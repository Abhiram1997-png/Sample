package first;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver=new ChromeDriver(options);
		Actions a=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.nykaafashion.com");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		//driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//button[text()='No thanks']")).click();
		Thread.sleep(2000);
		WebElement men= driver.findElement(By.xpath("(//span[text()='Men'])[1]"));
		a.moveToElement(men).build().perform();
		WebElement footwear=driver.findElement(By.xpath("//div[text()='Footwear']"));
		a.moveToElement(footwear).build().perform();
		driver.findElement(By.xpath("//a[text()='Sneakers']")).click();
		String parent=driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();	
		//driver.switchTo().newWindow(null);
		System.out.println(child.size());
		Thread.sleep(2000);
		for(String s:child)
		{
			if(!s.equals(parent))
			{
			driver.switchTo().window(s);
			}
		}
		String current=driver.getWindowHandle();
		WebElement element=driver.findElement(By.xpath("//h1[@class='css-h8pwvr']"));
		System.out.println(element.getText());
		
		//WebElement sole=driver.findElement(By.xpath("//div[text()='Gian Mens Casual Solid Grey Sneakers']"));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,200)","");
		
			//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		slowScroll(driver);
		List<WebElement> list =driver.findElements(By.xpath("//div[@class='css-1ago99h']//div[@class='css-zzdc8z']//div[@class='evejxsf1 css-384pms']"));
		System.out.println(list.size());
		Thread.sleep(3000);
		//list.get(7).click();
		/*for(WebElement l:list)
			
		{
			if(l.getText().contains("Puma"))
			{
				
			l.click();
			System.out.println(l.getText());
			driver.switchTo().window(current);
			
			}
		}
		String parent1=driver.getWindowHandle();
		Set<String> child1 = driver.getWindowHandles();	
		//driver.switchTo().newWindow(null);
		System.out.println(child.size());
		Thread.sleep(2000);
		for(String s:child1)
		{
			if(!s.equals(parent1) && !s.equals(parent))
			{
			driver.switchTo().window(s);
			js.executeScript("window.scrollBy(0,200)","");
			driver.findElement(By.xpath("//span[text()='UK 9']")).click();
			driver.findElement(By.xpath("//button[text()='Add to Bag']")).click();
			
			}
		}*/
	}
		
		public static void slowScroll(WebDriver driver) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        long scrollHeight = (long) js.executeScript("return document.body.scrollHeight");

	        for (int i = 0; i < scrollHeight; i++) {
	            js.executeScript("window.scrollBy(0, 10)");
	            try {
	                // Wait for a small amount of time to simulate slow scrolling
	                TimeUnit.MILLISECONDS.sleep(100);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
		

	}

}

