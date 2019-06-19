package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser")); //, BrowserType.CHROME

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }
}
