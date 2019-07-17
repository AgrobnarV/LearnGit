package omnicomm.test.mantis.tests;

import omnicomm.test.mantis.appmanager.HttpSession;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase {
  @Test
  public void testLogin() throws IOException {
    HttpSession session = app.NewSession();
    assertTrue(session.login("administrator", "123456"));
    assertTrue(session.isLoggedInAs("administrator"));
  }
}
