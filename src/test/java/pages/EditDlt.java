package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditDlt {
	
	@FindBy(xpath="//a[text()=' Edit Article']")
	WebElement editBtn;
	
	@FindBy(xpath="//button[text()=' Delete Article']")
	WebElement dltBtn;

	public EditDlt(WebDriver driver) 
	  {
			
			PageFactory.initElements(driver,this);
			
		}
	
	public void EditArticle() {
		
		editBtn.click();
	}
	
	public void DltArticle() {
		
		dltBtn.click();
	}

}
