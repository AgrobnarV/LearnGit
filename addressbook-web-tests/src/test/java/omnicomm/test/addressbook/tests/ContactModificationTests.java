package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
  @Test
  public void testModificationContactbyIcon () throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().clicktoEditPic();
    app.getContactHelper().fillContactform(new ContactData("Evgeniy", "Kotukhov", "test123", "8229999999", "test2@gmail.net"));
    app.getContactHelper().clicktoUpdate();
    app.getContactHelper().returnToHomepage();

  }
}
