package newgroup;

import static org.testng.AssertJUnit.assertTrue;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangePassTest extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
public void testChangePass() throws Exception {
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

    driver.findElement(By.linkText("My profile")).click();
    WebElement newpass = driver.findElement(By.id("password"));
	newpass.clear();
    newpass.sendKeys("1");
    WebElement newpassagain = driver.findElement(By.id("password2"));
	newpassagain.clear();
    newpassagain.sendKeys("1");
    driver.findElement(By.name("submit")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Log out")).click();
    wait.until(ExpectedConditions.alertIsPresent());
    driver.switchTo().alert().accept();
    driver.switchTo().defaultContent();
    Thread.sleep(2000);
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
   
    Assert.assertTrue(driver.findElement(By.cssSelector(".error")).isDisplayed());
  }

  @AfterClass
  public void afterChangePass() throws Exception {
	    WebElement userNameField = driver.findElement(By.id("username"));
		userNameField.clear();
	    userNameField.sendKeys("admin");
	    WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.clear();
	    passwordField.sendKeys("1");
	    driver.findElement(By.name("submit")).click();

	    driver.findElement(By.linkText("My profile")).click();
	    WebElement newpass = driver.findElement(By.id("password"));
		newpass.clear();
	    newpass.sendKeys("admin");
	    WebElement newpassagain = driver.findElement(By.id("password2"));
		newpassagain.clear();
	    newpassagain.sendKeys("admin");
	    driver.findElement(By.name("submit")).click();
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

