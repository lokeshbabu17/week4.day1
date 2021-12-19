package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assi1RowColm {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		System.out.println("Table row size:"+rows.size());
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table_id']//tr[2]/td"));
		System.out.println("Table column size:"+columns.size());
		
				WebElement progressValue = driver.findElement(By.xpath("//table[@id='table_id']//tr[3]/td[2]"));
				System.out.println("Progress value with Elements:"+progressValue.getText());
				
			
			
				
				Set<String> progressValueSet=new TreeSet<String>();
				for(int i=2;i<=rows.size();i++)
				{
					String text=driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
					
					progressValueSet.add(text);
					
					
				}
				List<String> abc=new ArrayList<String>(progressValueSet);
				System.out.println(abc.get(1));
				
				driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
				
				Thread.sleep(2000);
				
				
				driver.close();

		

	}

}

		
		
	

