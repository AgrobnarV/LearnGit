package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeleteModificationContactTests extends TestBase {
  @Test
  public void testDeleteModificationContact () throws Exception {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereaContact()) {
      app.getContactHelper().createContact (new ContactData("primer1", "primer2", "Moscow", "+1234567890", "primer2@mail.ru", "one"),true);
    }
    app.getContactHelper().clicktoEditPic();
    app.getContactHelper().deleteContactbyDetails();
  }
}
