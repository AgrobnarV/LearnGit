package omnicomm.test.mantis.tests;

import omnicomm.test.mantis.appmanager.HttpSession;
import omnicomm.test.mantis.appmanager.MailMessage;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class RegistrationTests extends TestBase {

  //@BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testRegistration() throws MessagingException, IOException {
    long now = System.currentTimeMillis();
    String user = String.format("username%s", now);
    String password = "password";
    String email = String.format("username%s@localhost.localdomain", now);
    app.james().createUser(user, password);
    app.registration().start(user, email);
    //List<MailMessage> mailMessages = app.mail().vaitForMail(2, 10000);
    List<MailMessage> mailMessages = app.james().waitForMail(user, password, 600000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, password);
    HttpSession session = app.newSession();
    session.login(user, password);
    assertTrue(session.isLoggedInAs(user));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }


 // @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
