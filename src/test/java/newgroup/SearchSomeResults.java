package newgroup;

import org.testng.*;
import org.testng.annotations.*;

import newgroup.model.User;
import pages.TestBase;


import org.openqa.selenium.*;


@Test
public class SearchSomeResults extends TestBase {
  //private boolean acceptNextAlert = true;
 // private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	  public void mayBeLogout() {
	    if (app.getUserHelper().isNotLoggedIn()) {
	      return;
	    }
	    app.getUserHelper().logout();
	  }
	
  public void testSearchSomeResults() throws Exception {
	  User user = new User().setLogin("admin").setPassword("admin");
	  
	  app.getUserHelper().loginAs(user);
    
	  app.getFilmHelper().clearSearchResultsAfterSearch();
	  
	String filmTitle = app.getFilmHelper().getFilmTitle();
    System.out.println("first film title is " + filmTitle);

    app.getFilmHelper().searchFilmsWithNewResults(filmTitle); 
    Assert.assertTrue(app.getFilmHelper().getFilmTitle().equals(filmTitle));
 }

  
  @AfterClass
  public void afterAddFilmPositive() throws Exception {
	  app.getUserHelper().logout();
  }
}

