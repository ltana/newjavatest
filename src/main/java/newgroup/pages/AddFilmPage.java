package newgroup.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddFilmPage extends AnyPage {
	
	public AddFilmPage(PageManager pages) {
		super(pages);
	}
	
	  @FindBy(css = "input[name='name']")
	  private WebElement filmTitle;

	  @FindBy(css = "input[name='year']")
	  private WebElement filmYear;
	  
	  @FindBy(css = "#submit")
	  private WebElement submitButton;
	  
	  @FindBy(css = "label[for='year']")
	  private WebElement errorMessageYear;
	  
	  public AddFilmPage setFilmTitle(String text) {
		  filmTitle.sendKeys(text);
		  return this;
		  }
	  
	  public WebElement filmYear() {
		  return filmTitle;
		  }
	  
	  public WebElement activeElement() {
		  return driver.switchTo().activeElement();
		  }

		  public AddFilmPage setFilmYear(String text) {
			  filmYear.sendKeys(text);
		    return this;
		  }

		  public void clickSubmitButton() {
		    submitButton.click();
		  }
		  
		  public boolean showErrorMessageYear() {
			  return errorMessageYear.isDisplayed();
			  }
	  
	  /*public FilmPage clickSubmitButton() {
	    submitButton.click();
	    return pages.filmPage;
	  }*/

	    public AddFilmPage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    wait.until(presenceOfElementLocated(By.cssSelector(".addmovie")));
	    return this;
	  }
}