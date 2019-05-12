package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.GroupData;
import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test2", "test33", "test45"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returntoGroupPage();
    app.getGroupHelper().clicktoGroupCheckbox();
  }

}