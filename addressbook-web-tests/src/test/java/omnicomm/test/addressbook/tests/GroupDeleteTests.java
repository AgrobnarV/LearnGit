package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeleteTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereaGroup()) {
      app.getGroupHelper().createGroup (new GroupData("test2", null, null));
    }
  }

  @Test
  public void testGroupDelete() throws Exception {
    List<GroupData> before = app.getGroupHelper().getGroupList();
    int index = before.size() - 1;
    app.getGroupHelper().selectGroup(index);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returntoGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),index);

    before.remove(index);
    Assert.assertEquals(before,after);
    }
}
