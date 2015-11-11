package newgroup.applogic2;

import newgroup.applogic.NavigationHelper;

public class NavigationHelper2 extends DriverBasedHelper implements NavigationHelper {

  private String baseUrl;

  public NavigationHelper2(ApplicationManager2 manager) {
    super(manager.getWebDriver());
    this.baseUrl = manager.getBaseUrl();
  }
  
  @Override
  public void openMainPage() {
    driver.get(baseUrl);
  }

  @Override
  public void openRelativeUrl(String url) {
    driver.get(baseUrl + url);
  }
  
  @Override
  public void gotoUserProfilePage() {
    pages.internalPage.ensurePageLoaded().clickUserProfilePage();
    //driver.findElement(By.cssSelector("nav a[href $= '?go=profile']"))
    //  .click();
    // openRelativeUrl("?go=profile");
  }

  @Override
  public void gotoUserManagementPage() {
    pages.internalPage.ensurePageLoaded().clickUserManagementLink();
    //driver.findElement(By.cssSelector("nav a[href $= '?go=users']"))
    //  .click();
    //openRelativeUrl("?go=users");
  }
  
  @Override
  public void gotoAddNewMovie() {
    pages.internalPage.ensurePageLoaded().clickAddMovieLink();
    //driver.findElement(By.cssSelector("nav a[href='./?go=add']"))
    //  .click();
    //openRelativeUrl("?go=add");
  }

  @Override
  public void gotoHomePage() {
    pages.filmPage.ensurePageLoaded().gotoHomePage();
    //driver.findElement(By.cssSelector("nav a[href='http://localhost/php4dvd/']"))
    //  .click();
    //openRelativeUrl("Home");
  }
  
  @Override
  public void gotoFilmPage() {
    pages.internalPage.ensurePageLoaded().clickFilmItem();
    //driver.findElement(By.cssSelector(".movie_box"))
    //  .click();
    //openRelativeUrl("Home");
  }
  
}
