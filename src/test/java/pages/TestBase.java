package pages;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import newgroup.applogic.ApplicationManager;
//import ru.st.selenium.applogic0.ApplicationManager0;
//import ru.st.selenium.applogic1.ApplicationManager1;
import newgroup.applogic2.ApplicationManager2;

public class TestBase {

  protected ApplicationManager app;

	@BeforeClass
	public void init() {
		app = new ApplicationManager2();
	}
	
	@AfterSuite
	public void stop() {
	  app.stop();
	}

}

