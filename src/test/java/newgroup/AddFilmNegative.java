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
public class AddFilmNegative extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  public void testAddFilmNegative() throws Exception {
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
    
    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add movie")));
    
    driver.findElement(By.linkText("Add movie")).click();
    WebElement name = driver.findElement(By.name("name"));
	name.clear();
    name.sendKeys("new film1");
    driver.findElement(By.name("submit")).click();
  
    Assert.assertEquals(driver.switchTo().activeElement(), driver.findElement(By.name("year")));
    Assert.assertTrue(driver.findElement(By.xpath(".//label[@for='year']")).isDisplayed());
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
}

