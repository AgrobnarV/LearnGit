package omnicomm.test.addressbook;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test2", "test33", "test45"));
    submitGroupCreation();
    returntoGroupPage();
    clicktoGroupCheckbox();
  }

}
