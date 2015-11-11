package newgroup.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilmPage  extends AnyPage {
	
	public FilmPage(PageManager pages) {
		super(pages);
	}
	
	  @FindBy(linkText = "Home")
	  private WebElement homePageLink;
	  
	  @FindBy(linkText = "Remove")
	  private WebElement removeFilmLink;

	public InternalPage gotoHomePage() {
		homePageLink.click();
	    return pages.internalPage;
	}
	
	public InternalPage clickRemoveLink() {
		removeFilmLink.click();
	    wait.until(alertIsPresent()).accept();
	    return pages.internalPage;
	}

public FilmPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.linkText("Remove")));
    return this;
  }


	
}
