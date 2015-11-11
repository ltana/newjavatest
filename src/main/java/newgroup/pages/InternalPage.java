package newgroup.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class InternalPage extends AnyPage {

	public InternalPage(PageManager pages) {
		super(pages);
	}
	
  public InternalPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.cssSelector("nav")));
    return this;
  }
  
  public InternalPage ensureSearchResultsLoaded() {
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.className("title")));
	    return this;
	  }
  
  @FindBy(css = "nav a[href $= '?go=profile']")
  private WebElement userProfileLink;

  @FindBy(css = "nav a[href $= '?go=users']")
  private WebElement userManagementLink;

  @FindBy(css = "nav a[href $= '?logout']")
  private WebElement logoutLink;
  
  @FindBy(css = "nav a[href='./?go=add']")
  private WebElement addMovie;
  
  @FindBy(css = ".movie_box")
  private List<WebElement> filmsItems;
  
  @FindBy(css = ".movie_box")
  private WebElement filmItem;
  
  @FindBy(css = ".movie_box .title")
  private WebElement filmTitle;
  
  @FindBy(css = "#q")
  private WebElement searchField;
  
  
  public WebElement oldElement() {
		 return filmItem;
	  }
  
  public UserProfilePage clickUserProfilePage() {
    userProfileLink.click();
    return pages.userProfilePage;
  }

  public UserManagementPage clickUserManagementLink() {
    userManagementLink.click();
    return pages.userManagementPage;
  }
  
  public LoginPage clickLogoutLink() {
    logoutLink.click();
    wait.until(alertIsPresent()).accept();
    return pages.loginPage;
  }
  
  public AddFilmPage clickAddMovieLink() {
	  addMovie.click();
	  return pages.addFilmPage;
	  }
  
  public FilmPage clickFilmItem() {
	  filmItem.click();
	  return pages.filmPage;
	  }

  public int filmsCount() {
	 return filmsItems.size();
  }
  
  public String filmTitle() {
		 return filmTitle.getText();
	  }
  
  public boolean noResultsSearchMessage() {
	  return isElementPresent(By.className("content"));
  }
  
  public void searchFilms(String text) {
	  searchField.clear();
	    searchField.sendKeys(text + Keys.RETURN);
	    wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("movie_box"))));
	  }
  
  public void clearSearchResults() {
	  searchField.clear();
	    searchField.sendKeys(Keys.RETURN);
	    wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(".//*[@id='results']/div[1]"))));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("title")));
	  }
  
  public void searchFilmsWithResults(String text/*, WebElement element*/) {
	  searchField.clear();
	    searchField.sendKeys(text + Keys.RETURN);
	    //wait.until(ExpectedConditions.stalenessOf(element));
	    wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("movie_box"))));
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.className("movie_box")));
	  }
  
  public void waitForStale(WebElement element) {
 wait.until(ExpectedConditions.stalenessOf(element));

	  }
}
