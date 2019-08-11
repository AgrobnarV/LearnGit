package omnicomm.test.mantis.tests;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import omnicomm.test.mantis.model.Issue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.util.Set;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class RestAssured extends TestBase {

  @BeforeClass
  public void init() {
    authentication = io.restassured.RestAssured.basic("288f44776e7bec4bf44fdfeb1e646490", "");
  }

  @Test
  public void testCreateIssue() throws IOException, ServiceException {
    int issueOldId = 1301;
    skipIfNotFixed(issueOldId);
    Set<Issue> oldIssues = getIssues();
    Issue newIssue = new Issue().withSubject("issue test").withDescription("new issue test");
    int issueId = createIssue(newIssue);
    Set<Issue> newIssues = getIssues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }

  private Set<Issue> getIssues() {
    String json = io.restassured.RestAssured.get("http://bugify.stqa.ru/api/issues.json?limit=1000").asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {}.getType());
  }

  private int createIssue(Issue newIssue) {
    String json = io.restassured.RestAssured.given().param("subject", newIssue.getSubject())
            .param("description", newIssue.getDescription())
            .post("http://bugify.stqa.ru/api/issues.json?limit=1000").asString();
    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();
  }
}
