package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeleteTests extends TestBase {

  @BeforeMethod (enabled = false)
  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().createGroup(new GroupData("test2", null, null));
    }
  }

  @Test (enabled = false)
  public void testGroupDelete() throws Exception {
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    app.group().delete(index);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(),index);

    before.remove(index);
    Assert.assertEquals(before,after);
    }
}
