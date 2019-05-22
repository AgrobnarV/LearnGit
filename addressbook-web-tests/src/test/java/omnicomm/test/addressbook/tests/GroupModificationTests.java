package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereaGroup()) {
      app.getGroupHelper().createGroup (new GroupData("test2", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().modificationGroup(new GroupData("one", null, "three"));
  }
}
