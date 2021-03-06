package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.appmanager.ApplicationManager;
import omnicomm.test.addressbook.tests.Contact.MyTestListener;
import omnicomm.test.addressbook.tests.Group.GroupCreationTests;
import omnicomm.test.addressbook.model.Contacts;
import omnicomm.test.addressbook.model.GroupData;
import omnicomm.test.addressbook.model.Groups;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Listeners(MyTestListener.class)

public class TestBase {
  Logger logger = LoggerFactory.getLogger(GroupCreationTests.class);

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp(ITestContext context) throws Exception {
    app.init();
    context.setAttribute("app",app);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod(alwaysRun = true)
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test" + m.getName() + "with parameters" + Arrays.asList(p));

  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m) {
    logger.info("Stop test" + m.getName());

  }

  public void verifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream().map((g) -> new GroupData()
              .withId(g.getId())
              .withGname(g.getGname()))
              .collect(Collectors.toSet())));
    }
  }

  public void verifyContactListInUI() {
    if(Boolean.getBoolean("verifyUI")){
      Contacts dbContacts = app.db().contacts();
      Contacts uiContacts = app.contact().contAll();
      assertThat(uiContacts, equalTo(dbContacts));
    }
  }
}
