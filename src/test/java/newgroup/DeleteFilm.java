package newgroup;

import org.testng.*;
import org.testng.annotations.*;

import newgroup.model.User;
import pages.TestBase;

@Test
public class DeleteFilm extends TestBase {
 // private boolean acceptNextAlert = true;
 // private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	  public void mayBeLogout() {
	    if (app.getUserHelper().isNotLoggedIn()) {
	      return;
	    }
	    app.getUserHelper().logout();
	  }
	
  public void testDeleteFilm() throws Exception {
	  User user = new User().setLogin("admin").setPassword("admin");
	    
	    app.getUserHelper().loginAs(user);
	    
	    int oldFilms = app.getFilmHelper().countFilms();
	    System.out.println("films i have = " + oldFilms);
  
    app.getNavigationHelper().gotoFilmPage();
    app.getFilmHelper().deleteFilm();
  
    int afterDeleteFilms = app.getFilmHelper().countFilms();
    System.out.println("films i have = " + afterDeleteFilms);
 
    Assert.assertEquals(afterDeleteFilms, oldFilms-1);
 }
  
  @AfterClass
  public void afterAddFilmPositive() throws Exception {
	  app.getUserHelper().logout();
  }
}

