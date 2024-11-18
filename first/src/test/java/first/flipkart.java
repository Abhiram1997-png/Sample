package first;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkart {

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
	
		//List<WebElement> list1 =driver.findElements(By.xpath("(//div[@class='tLbyDf'])[1]//div[@class='_25HC_u']"));
		//System.out.println(list1.size());
		//push
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@class='_3qmi1z'])[1]//span")).click();
		
		//System.out.println(list);
		Thread.sleep(3000);
		List<WebElement> list2 =driver.findElements(By.xpath("(//div[@class='tLbyDf'])[1]//div[@class='_25HC_u']"));
		Thread.sleep(7000);
		list2.get(0).getText();
		int n=list2.size();
		for(WebElement e:list2)
		{
			System.out.println(e.getText());
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='_2o9o_t _2pNTc_'])[2]")).click();
		
		//System.out.println(list2);
		
		
		//System.out.println("------"+list.get(7).getText());
		String str=list2.get(6).getText();
		System.out.println(str);
		for(int i=0;i<list2.size();i++)
		{
			if(list2.get(i).getText().equalsIgnoreCase(str)&& i<n-2 )
			{
				
					list2.get(i).click();
					
					driver.navigate().back();
					break;
				}
			else if(list2.get(i).getText().equalsIgnoreCase(str)&&(i==n-2 &&i==n-1))
			{
				driver.findElement(By.xpath("(//button[@class='_3qmi1z'])[1]//span")).click();
				Thread.sleep(10000);
				list2.get(i).click();
				
				break;
					
				}
				
					
				
			}
		System.out.println("Done");
	
			}
		
		//driver.close();
		}
		
		
	
		

	




