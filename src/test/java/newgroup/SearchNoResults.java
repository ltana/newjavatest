package newgroup;

import org.testng.*;
import org.testng.annotations.*;

import newgroup.model.User;
import pages.TestBase;

@Test
public class SearchNoResults extends TestBase {
  //private boolean acceptNextAlert = true;
  //private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	  public void mayBeLogout() {
	    if (app.getUserHelper().isNotLoggedIn()) {
	      return;
	    }
	    app.getUserHelper().logout();
	  }
	
  public void testSearchNoResults() throws Exception {
	  User user = new User().setLogin("admin").setPassword("admin");
	    
	    app.getUserHelper().loginAs(user);
    
   
    String filmTitle = app.getFilmHelper().getFilmTitle();
    System.out.println("first film title is " + filmTitle);

    app.getFilmHelper().searchFilm(filmTitle + "testtest");

   Assert.assertTrue(app.getFilmHelper().showNoResultsSearchMessage());
 }

  
  @AfterClass
  public void afterAddFilmPositive() throws Exception {
	  app.getUserHelper().logout();
  }
}

