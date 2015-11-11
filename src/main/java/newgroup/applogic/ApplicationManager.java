package newgroup.applogic;

public interface ApplicationManager {

	UserHelper getUserHelper();
	FilmHelper getFilmHelper();
  NavigationHelper getNavigationHelper();

  void stop();

}
