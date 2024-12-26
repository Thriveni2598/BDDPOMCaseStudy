package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticleCreation {

	@FindBy(name="title")
	WebElement article;
	
	@FindBy(xpath="//input[ @name='description']")
	WebElement about;
	
	@FindBy(name="body")
	WebElement details;
	
	@FindBy(name="tags")
	WebElement tag;
	
	@FindBy(xpath = "//button[text()='Publish Article']")
	WebElement subBtn;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement updateBtn;
	
	@FindBy(xpath="//div[@class='article-page']")
	WebElement articlePage;
	
	
   public ArticleCreation(WebDriver driver) 
  {
		
		PageFactory.initElements(driver,this);
		
	}
   
   public void ArtCreation(String strart, String strabout, String strdetails, String strtags){
	   
	 
	   article.sendKeys(strart);
	   about.click();
	   about.sendKeys(strabout);
	   details.click();
	   details.sendKeys(strdetails);
	   tag.click();
	   tag.sendKeys(strtags);
	   subBtn.click();
   }
   
   public  boolean isArticleCreated() {
	   
	   return articlePage.isDisplayed();
	   
   }
   
   public void ArtEdit(String editart, String editabout, String editdetails ) {
	   
	   article.clear();
	   article.sendKeys(editart);
	   about.clear();
	   about.sendKeys(editabout);
	   details.clear();
	   details.sendKeys(editdetails);
	   updateBtn.click();
	   
   }
   public  boolean isArticleUpdated() {
	   
	   return articlePage.isDisplayed();
	   
   
   }
   
   public boolean isDetailsDisplayed() {
	   return articlePage.isDisplayed();
   }

}
