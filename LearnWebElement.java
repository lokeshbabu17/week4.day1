package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWebElement {
	public static void main(String[] args) throws InterruptedException {
		
		   WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver= new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://erail.in/");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(27));
			driver.findElement(By.id("txtStationFrom")).clear();
			driver.findElement(By.id("txtStationFrom")).sendKeys("ms");
			Thread.sleep(1000);
			driver.findElement(By.id("txtStationFrom")).sendKeys(Keys.ENTER);
			
			driver.findElement(By.id("txtStationTo")).clear();
			driver.findElement(By.id("txtStationTo")).sendKeys("mdu");
			Thread.sleep(2000);
			driver.findElement(By.id("txtStationTo")).sendKeys(Keys.ENTER);
			
			driver.findElement(By.id("chkSelectDateOnly")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//table@_'DataTable")).click();
	}

}
