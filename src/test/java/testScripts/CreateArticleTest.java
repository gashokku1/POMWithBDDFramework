package testScripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ArticlePage;
import pages.CreatedArticlePage;
import pages.LoginPage;
import pages.ApplicationHomepage;

public class CreateArticleTest {
	WebDriver driver;
	LoginPage loginPage;
	ApplicationHomepage applicationHomePage;
	ArticlePage articlePage;
	CreatedArticlePage createdArticlePage;
	public CreateArticleTest() {
		TestBase.initDriver();
		driver = TestBase.getDriver();
		loginPage = new LoginPage(driver);
		applicationHomePage = new ApplicationHomepage(driver);
		articlePage = new ArticlePage(driver);
		createdArticlePage = new CreatedArticlePage(driver);
		
	}
	
	@BeforeTest
	public void setUp() {
		TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/");
		loginPage.navigateToLoginPage();
	}

	@Test
	public void login() {
		loginPage.validLogin("TestUserBot@testmail.com", "TestUserBot");

	}

	@Test(priority = 1)
	public void navigateToHomePage() throws InterruptedException {
		boolean title = applicationHomePage.validateHomePage();
		Assert.assertTrue(title);
		applicationHomePage.navigateToArticle();

	}

	@Test(priority = 2)
	public void writeArticle() throws InterruptedException {
		articlePage.validateArticlePage()
		articlePage.sendTitle("TestArticleDemo");
		articlePage.sendDescription("New Description");
		articlePage.sendContent("TestContent");
		articlePage.sendTags("TestTag");
		articlePage.publishArticle();
		

	}

	@Test(priority = 3)
	public void validateTheCreatedArticle() throws InterruptedException {
		createdArticlePage.validateCreatedArticle();

	}
	@AfterTest
	public void closeBrowser() {
		
		TestBase.tearDown();
	}


}
