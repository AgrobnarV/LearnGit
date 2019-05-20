package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
  @Test
  public void testModificationContactbyIcon () throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().clicktoEditPic();
    app.getContactHelper().fillContactform(new ContactData("test1", "test2", null, null, "test3@gmail.net", null),false);
    app.getContactHelper().clicktoUpdate();
    app.getContactHelper().returnToHomepage();

  }
}
