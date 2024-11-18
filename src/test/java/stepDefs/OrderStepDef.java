package stepDefs;

import java.util.List;

import javax.annotation.WillCloseWhenClosed;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductListPage;

public class OrderStepDef {
	//WebDriver driver = TestBase.getDriver();
	LoginPage loginPage;
	ProductListPage productListPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	public OrderStepDef() {
		TestBase.initDriver();
		driver = TestBase.getDriver();
		loginPage = new LoginPage(driver);
		productListPage = new ProductListPage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
	
	@Given ("User is on Login Page")
	public void user_is_on_Login_page{
		TestBase.openUrl("https://www.saucedemo.com/");
	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String strUser, String strpwd) {
		loginPage.validLogin("standard_user", "secret_sauce");
	}
	@Given("User should be on Home Page")
	public void user_should_be_on_home_page() {
		Assert.assertTrue(productListPage.isOnProducts());
	}
	@When("User add item to cart")
	public void user_add_item_to_cart() {
		productListPage.addTocart();
	}
	@Then("Items must be added")
	public void item_must_be_added() {
		productListPage.validateCart();
		Assert.assertTrue(cartPage.isItemAdded());
	}
	@Given("User is on cart Page")
	public void user_is_on_cart_page() {
		productListPage.validateCart();
	}
	@When("User do checkout")
	public void user_do_checkout() {
		cartPage.checkoutItems();
	}
	@Then("Should navigate to checkout page")
	public void should_navigate_to_checkout_page() {
		 checkoutPage.validateTitle();
		  checkoutPage.checkoutInformation("Testname", "TestPassword", "123");
		  checkoutPage.finish();
		  checkoutPage.validateThanksMessage();
	}

	/*
	 * @BeforeAll
	 * 
	 * public static void setup() {
	 * System.out.println("Before all the scenarios executed first");
	 * 
	 * }
	 */	
	
	/*
	 * @Before ("@SmokeTest") public static void initChromeBrowser() {
	 * System.out.println("Chrome browser Initialized...");
	 * 
	 * }
	 * 
	 * @Before ("@RegressionTest") public static void initEdgeBrowser() {
	 * System.out.println("Edge browser Initialized...");
	 * 
	 * }
	 */
	
	@Before (value = "@SmokeTest", order = 1)
	public static void readPropertyFile() {
		System.out.println("Read Property file Initialized...");
		
	}
	@Before (value = "@SmokeTest", order = 2)
	public static void initChromeBrowser() {
		System.out.println("Chrome browser Initialized...");
		
	}
	@Before (value = "@SmokeTest", order = 3)
	public static void initDBConnection() {
		System.out.println("Initialized initDBConnection...");
		
	}
	
@AfterAll
	
	public static void tearDown() {
		System.out.println("After all the scenarios executed last");
		
	}
	@Given("User is on Google Page")
	public void user_is_on_google_page() {
		 public void LaunchPage() throws InterruptedException {
			 ChromeOptions opt = new ChromeOptions();
				opt.setBrowserVersion("120");
				driver = new ChromeDriver(opt);

				driver.get("https://www.google.com/");
				driver.manage().window().maximize();
				Thread.sleep(3000);
			  
		  }
	    
	}

	/*
	 * @When("User Enters Credentials") public void user_search_java_tutorial() { //
	 * Write code here that turns the phrase above into concrete actions WebElement
	 * uName = driver.findElement(By.id("username")); uName.sendKeys("tomsmith");
	 * WebElement pWord = driver.findElement(By.id("password"));
	 * pWord.sendKeys("SuperSecretPassword!"); WebElement login =
	 * driver.findElement(By.xpath("//*[text()=' Login']")); login.submit();
	 * 
	 * 
	 * }
	 */
	/*
	 * //datatable concept
	 * 
	 * @When("User Enters Credentials") public void
	 * user_search_java_tutorial(DataTable dataTable) { List<<List<String>> data =
	 * dataTable.asLists(); String userName = data.get(0).get(0); String password =
	 * data.get(0).get(1); // Write code here that turns the phrase above into
	 * concrete actions WebElement uName = driver.findElement(By.id("username"));
	 * uName.sendKeys(userName); WebElement pWord =
	 * driver.findElement(By.id("password")); pWord.sendKeys(password); WebElement
	 * login = driver.findElement(By.xpath("//*[text()=' Login']")); login.submit();
	 * 
	 * 
	 * }
	 */

	// Map concept
	@When("User Enters Credentials")
		public void user_search_java_tutorial(DataTable dataTable) {
			List<<List<String>> data = dataTable.asMaps();
			String userName = data.get(0).get("username");
			String password = data.get(0).get("password");
		    // Write code here that turns the phrase above into concrete actions
			 WebElement uName = driver.findElement(By.id("username"));
			  uName.sendKeys(userName);
			  WebElement pWord = driver.findElement(By.id("password"));
			  pWord.sendKeys(password);
			  WebElement login = driver.findElement(By.xpath("//*[text()=' Login']"));
			  login.submit();
			
		    
		}

	@Then("Should display Java Tutorial Page")
	public void should_display_java_tutorial_page() {
		List<<List<String>> msg = dataTable.asLists();
		String expMsg = data.get(0).get(0);
		
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Navigated to the page sucessfully"+ driver.getTitle());
	  
	}

}
