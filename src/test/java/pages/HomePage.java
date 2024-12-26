package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(linkText = "New Article")
	WebElement newArtBtn;
	
	@FindBy(linkText = "Home")
	WebElement homeBtn;
	
	@FindBy(xpath="//h1[text()='Selenium1']")
	WebElement view;
	
	@FindBy(id="root")
	WebElement landingPage;
	
	@FindBy(xpath="//button[text()='Global Feed']")
	WebElement globalFeed;

	@FindBy(xpath ="//div[text()='Articles not available.']")
	WebElement message;


public HomePage(WebDriver driver) {
	
	PageFactory.initElements(driver,this);
	
}

public void ArticleBtn() {
	
	newArtBtn.click();
	}

public void HomeBtn() {
	homeBtn.click();
}

public void ViewArticle() {
	globalFeed.click();
}

public void DetailedView() {
	view.click();
}

public boolean isLoginSuccess() {
	
	return landingPage.isDisplayed();
}
public boolean homePageDisplay() {
	return landingPage.isDisplayed();
}

public boolean isArticleDeleted() {
	 return landingPage.isDisplayed();
}

public String message() {
	return message.getText();
}
}