package newgroup.applogic;

import java.util.List;

import org.openqa.selenium.WebElement;

import newgroup.model.Film;

public interface FilmHelper {

	void create(Film film);
	int countFilms();
	boolean shownErrorMessageYear();
	void deleteFilm();
	String getFilmTitle();
	List<Film> search1(String title);
	void searchFilm(String text);
	boolean showNoResultsSearchMessage();
	void clearSearchResultsAfterSearch();
	void searchFilmsWithNewResults(String text/*, WebElement element*/);
	WebElement oldFilmElement();
	void waitStaless(WebElement element);

}
