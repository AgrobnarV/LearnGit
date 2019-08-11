package omnicomm.test.mantis.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import omnicomm.test.mantis.appmanager.ApplicationManager;
import omnicomm.test.mantis.model.Issue;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws IOException {
    app.ftp().restore("config_inc.php.bak", "config_inc.php");
    app.stop();
  }

  public Issue issueById(int issueId) {
    String json = RestAssured.get(String.format("http://bugify.stqa.ru/api/issues/%s.json", issueId)).asString();
    JsonElement issues = new JsonParser().parse(json).getAsJsonObject().get("issues");
    Set<Issue> issuesSet = new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {
    }.getType());
    Issue issue = issuesSet.iterator().next();
    return issue;
  }

  public boolean isIssueOpen(int issueID) {
    Issue myIssue = issueById(issueID);
    String status = myIssue.getState_name();
    if (status.equals("Deleted") || status.equals("Closed")) {
      return false;
    } else {
      return true;
    }
  }

  public void skipIfNotFixed(int issueId) {
    if (isIssueOpen(issueId)) {
      System.out.println("Ignored because of unresolved issue " + issueId + " in Mantis bugtracker");
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

}
