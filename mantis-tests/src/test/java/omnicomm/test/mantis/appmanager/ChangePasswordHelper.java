package omnicomm.test.mantis.appmanager;

import omnicomm.test.mantis.model.MailMessage;
import omnicomm.test.mantis.model.UsersData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import ru.lanwen.verbalregex.VerbalExpression;


import java.util.List;

public class ChangePasswordHelper extends HelperBase {

  public ChangePasswordHelper(ApplicationManager app) {
    super(app);
  }

  public void loginAsAdminAndManage() {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), "administrator");
    type(By.name("password"), "123456");
    click(By.cssSelector("input[value='Login']"));
    click(By.linkText("Manage Users"));
  }

  public boolean testUserIsHere() {
    try {
      wd.findElement(By.linkText("Oleg"));
    } catch (NoSuchElementException e) {
      return false;
    }
    return true;
  }

  public void clickOnTestUserAndResetPsw(UsersData user) {
    click(By.linkText(String.format("%s", user.getUsername())));
    click(By.cssSelector("input[value='Reset Password']"));
  }

  public String findResetPasswordLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email) && m.text.contains("Someone (presumably you)")).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  public void changePassword(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("input[value='Update User']"));
  }
}
