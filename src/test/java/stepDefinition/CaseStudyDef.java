package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ArticleCreation;
import pages.EditDlt;
import pages.HomePage;
import pages.LoginPage;

public class CaseStudyDef {
	WebDriver driver = TestBase.getDriver();
	LoginPage loginPage;
	HomePage homePage;
	ArticleCreation articleCreation;
	EditDlt editDelete;
	
	public CaseStudyDef() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		articleCreation= new ArticleCreation(driver);
		editDelete = new EditDlt(driver);
	}
	
	
	@Given("User is on login Page")
	public void user_is_on_login_page() {
		TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/login");
	    
	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String strEmail, String strPwd) {
		loginPage.ValidLogin(strEmail, strPwd);

	}
	@Then("User should be on Home Page")
	public void user_should_be_on_home_page() {
		Assert.assertTrue(homePage.isLoginSuccess());

	}
	@Given("User should be on New Article Page")
	public void user_should_be_on_new_article_page() {
	   homePage.ArticleBtn();
	}
	@When("User enters Article details")
	public void user_enters_article_details(DataTable dataTable) {
	    List<Map<String,String>> content = dataTable.asMaps();
	    
	    String title = content.get(0).get("Title");
	    String desc = content.get(0).get("Description");
	    String cont = content.get(0).get("Content");
	    String tags = content.get(0).get("Tag");
	    articleCreation.ArtCreation(title,desc,cont,tags);
	    
	    
	}
	@Then("Article must be created")
	public void article_must_be_created() {
		Assert.assertTrue(articleCreation.isArticleCreated());  
}
	@Given("User should be on Global Feed page")
	public void user_should_be_on_global_feed_page() {
		homePage.HomeBtn();
		homePage.ViewArticle();
	    
	}
	@When("User select an article Article title")
	public void user_select_an_article_article_title() {
		homePage.DetailedView();
	    
	}
	@Then("Article details page must be displayed")
	public void article_details_page_must_be_displayed() {
		Assert.assertTrue(articleCreation.isDetailsDisplayed());
	}
	
	@When("User update article details")
	public void user_update_article_details() {
		editDelete.EditArticle();
		articleCreation.ArtEdit("Selenium2", "selenium details", "Follow the required courses");
	    
	}
	@Then("Article details must be displayed")
	public void article_details_must_be_displayed() {
		Assert.assertTrue(articleCreation.isArticleUpdated());
	}

   @When("User delete article")
   public void user_delete_article() {
	    editDelete.DltArticle();
		driver.switchTo().alert().accept();
   
   }
   @Then("Article must be deleted")
   public void article_must_be_deleted() {
	   Assert.assertTrue(homePage.isArticleDeleted());
   }
   
   @Given("Article Home page must be displayed")
   public void article_home_page_must_be_displayed() {
        Assert.assertTrue(homePage.homePageDisplay());
   }
   @Then("Message should display")
   public void message_should_display() {
	   Assert.assertEquals(homePage.message(), "Article available");
     
   }
   
   @Then("Error message should dsiplay")
   public void error_message_should_dsiplay() {
       Assert.assertTrue(loginPage.ErrorMessage());
   }


}
