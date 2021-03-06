package newgroup.applogic2;

import java.util.List;

import org.openqa.selenium.WebElement;

import newgroup.applogic.FilmHelper;
import newgroup.model.Film;

public class FilmHelper2 extends DriverBasedHelper implements FilmHelper {

  public FilmHelper2(ApplicationManager2 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void create(Film film) {
    pages.addFilmPage.ensurePageLoaded()
    .setFilmTitle(film.getTitle())
    .setFilmYear(film.getYear())
    .clickSubmitButton();
  }

  @Override
  public void deleteFilm() {
	  pages.filmPage.ensurePageLoaded().
	  clickRemoveLink();
    // TODO Auto-generated method stub
  }

  @Override
  public List<Film> search1(String title) {
    // TODO Auto-generated method stub
    return null;
  }
  
  @Override
  public void searchFilm(String text) {
	  pages.internalPage.ensurePageLoaded().searchFilms(text);
  }
  
  @Override
  public void clearSearchResultsAfterSearch() {
	  pages.internalPage.ensurePageLoaded().clearSearchResults();
  }
  
  @Override
  public void searchFilmsWithNewResults(String text) {
	  pages.internalPage.ensurePageLoaded().searchFilmsWithResults(text);
  }
  
  @Override
  public WebElement oldFilmElement() {
    return pages.internalPage.oldElement();
  }
  
  @Override
  public WebElement oldResultElement() {
    return pages.internalPage.oldResult();
  }
  
  @Override
  public int countFilms() {
    return pages.internalPage.filmsCount();
  }
  
  @Override
  public String getFilmTitle() {
    return pages.internalPage.ensurePageLoaded().filmTitle();
  }
  
  @Override
  public boolean shownErrorMessageYear() {
	    return pages.addFilmPage.showErrorMessageYear();
  }
  
  @Override
  public boolean showNoResultsSearchMessage() {
	    return pages.internalPage.noResultsSearchMessage();
  }
}
