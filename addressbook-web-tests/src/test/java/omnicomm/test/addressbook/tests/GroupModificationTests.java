package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (! app.getGroupHelper().isThereaGroup()) {
      app.getGroupHelper().createGroup (new GroupData("test2", null, null));
    }
    app.getGroupHelper().selectGroup(before - 1); // выбираем последнюю запись
    app.getGroupHelper().modificationGroup(new GroupData("one", null, "three"));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before);
  }
}
