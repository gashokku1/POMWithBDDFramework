package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DealsManagementTest {
		WebDriver driver;
	@Test (groups = "FeatureOne")
	public void SampleOne() {
		driver = new ChromeDriver();
		long threadid = Thread.currentThread().getId();
		System.out.println("Sample one got executed...." +threadid);
		
		}
	

	@Test(groups = "FeatureTwo")
	public void SampleTwo() {
		
		driver = new ChromeDriver();
		long threadid = Thread.currentThread().getId();
		System.out.println("Sample SampleTwo got executed...." +threadid);
		
		}
	
	@Test
	public void SampleThree() {
		
		driver = new EdgeDriver();
		long threadid = Thread.currentThread().getId();
		System.out.println("Sample SampleThree got executed...." +threadid);
		
		}
	
	@Test(invocationCount = 4,threadPoolSize = 2,timeOut = 10000)
	public void SampleFour() {
		
		driver = new EdgeDriver();
		long threadid = Thread.currentThread().getId();
		System.out.println("SampleFour got executed...." +threadid);
		
		}


}
