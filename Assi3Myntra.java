package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assi3Myntra {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions builder=new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//a[text()='Men']"))).perform();
		driver.findElement(By.linkText("Jackets")).click();
		List<WebElement> items = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		System.out.println("No. of items:"+items.size());
		
		driver.findElement(By.xpath("//div[@class='common-checkboxIndicator']")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']//div")).click();
		driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]")).click();
		List<WebElement> jackets = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		List<String> jacketNames=new ArrayList<String>();
		System.out.println(jackets.size());
		Thread.sleep(2000);
		int count=0;
		for(int i=0;i<jackets.size();i++)
		{
			
				String text=driver.findElement(By.xpath("//h3[@class='product-brand']")).getText();
				jacketNames.add(text);
		}
		System.out.println(jacketNames);
		System.out.println(jacketNames.size());
		
		for(int i=0;i<jacketNames.size();i++)
		{
			
				if(jacketNames.get(i).equals("Duke"))
					count++;
				
		}
		if(count==jacketNames.size())
			System.out.println("All the jackets are of Duke");
		else
			System.out.println("Jackets are not of Duke");
		
		builder.moveToElement(driver.findElement(By.xpath("//div[text()='Sort by : ']"))).perform();
		driver.findElement(By.xpath("(//label[@class='sort-label '])[3]")).click();
		
		Thread.sleep(2000);
		String price = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		System.out.println("Price of first item:"+price);
		
		driver.findElement(By.xpath("(//img[@class='img-responsive'])[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList=new ArrayList<String>(windowHandles);
		String secondWindow=windowHandlesList.get(1);
		driver.switchTo().window(secondWindow);
		
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();		
		
		
	}

}
