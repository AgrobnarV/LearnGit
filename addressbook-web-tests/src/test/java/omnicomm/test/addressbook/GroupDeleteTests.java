package omnicomm.test.addressbook;

import org.testng.annotations.Test;

public class GroupDeleteTests extends TestBase{
  @Test
  public void testGroupDelete() throws Exception {
    gotoGroupPage();
      selectGroup();
      deleteSelectedGroups();
      returntoGroupPage();
  }

}
