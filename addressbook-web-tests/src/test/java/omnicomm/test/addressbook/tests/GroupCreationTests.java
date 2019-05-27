package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("test2", null, null));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before + 1);
  }

}
