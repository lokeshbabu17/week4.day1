package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assi2sortTable {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		System.out.println("Table row size:"+rows.size());
		List<String> nameList=new ArrayList<String>();
		for(int i=1;i<rows.size();i++)
		{
			
				String text=driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
				nameList.add(text);
		}
		System.out.println("sorted name in table:"+nameList);
		int count=0;
		
		for(int i=0;i<nameList.size();i++)
		{
			if(nameList.get(i).equals(nameList.get(i)))
				
				count=0;
			else
				count++;
			
		}
		if(count>0)
			System.out.println("Sorting is not working");
		else
			System.out.println("Sorting is  working");
	}

}
