package newgroup;

import static org.testng.AssertJUnit.assertTrue;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@Test
public class SearchNoResults extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  public void testSearchNoResults() throws Exception {
	  driver.manage().window().maximize();
	  WebDriverWait wait = new WebDriverWait(driver, 5);
    driver.get(baseUrl + "/php4dvd/");
    WebElement userNameField = driver.findElement(By.id("username"));
	userNameField.clear();
    userNameField.sendKeys("admin");
    WebElement passwordField = driver.findElement(By.name("password"));
	passwordField.clear();
    passwordField.sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("q")));
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.className("movie_box")));
   
    String filmTitle = driver.findElement(By.className("movie_box"))
    		.findElement(By.className("title")).getText();
    System.out.println("first film title is " + filmTitle);

    WebElement searchWord = driver.findElement(By.id("q"));
	searchWord.clear();
    	searchWord.sendKeys(filmTitle + "searchnoresults" + Keys.RETURN);

   wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("movie_box"))));

   Assert.assertTrue(isElementPresent(By.className("content")));
 }

  
private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  
  @AfterClass
  public void afterSearchNoResults() throws Exception {
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	    driver.findElement(By.linkText("Log out")).click();
	    wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	    driver.switchTo().defaultContent();
  }
}

