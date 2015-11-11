package newgroup;

import org.testng.*;
import org.testng.annotations.*;

import newgroup.model.Film;
import newgroup.model.User;
import pages.TestBase;

public class AddFilmPositive extends TestBase {
 // private boolean acceptNextAlert = true;
 // private StringBuffer verificationErrors = new StringBuffer();

  
  @BeforeMethod
  public void mayBeLogout() {
    if (app.getUserHelper().isNotLoggedIn()) {
      return;
    }
    app.getUserHelper().logout();
  }
  
  @Test
  public void testAddFilmNegative() throws Exception {
    User user = new User().setLogin("admin").setPassword("admin");
    
    app.getUserHelper().loginAs(user);
    
    int oldFilms = app.getFilmHelper().countFilms();
    System.out.println("films i have = " + oldFilms);
    		
    app.getNavigationHelper().gotoAddNewMovie();
    
    Film film = new Film().setTitle("new film1").setYear("1234");
    
    app.getFilmHelper().create(film);
    app.getNavigationHelper().gotoHomePage();
    
    int newFilms = app.getFilmHelper().countFilms();
    System.out.println("films i have = " + newFilms);
    
    Assert.assertEquals(newFilms, oldFilms+1);
}
  
  @AfterClass
  public void afterAddFilmPositive() throws Exception {
	  app.getUserHelper().logout();
  }
}

