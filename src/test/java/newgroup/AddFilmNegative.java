package newgroup;

import org.testng.Assert;
import org.testng.annotations.*;
import newgroup.model.Film;
import newgroup.model.User;
import pages.TestBase;

public class AddFilmNegative extends TestBase {
  //private boolean acceptNextAlert = true;
  //private StringBuffer verificationErrors = new StringBuffer();
  
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
    app.getNavigationHelper().gotoAddNewMovie();
    
    Film film = new Film().setTitle("name").setYear("");
    
    app.getFilmHelper().create(film);
    Thread.sleep(5000);
    Assert.assertTrue(app.getFilmHelper().shownErrorMessageYear());
  
    //Assert.assertEquals(driver.switchTo().activeElement(), driver.findElement(By.name("year")));
 }
  
  @AfterClass
  public void afterAddFilmPositive() throws Exception {
	  app.getUserHelper().logout();
  }
}

