package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModifyforDetailsTests extends TestBase {
  @Test
  public void testModificationContact () throws Exception {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereaContact()) {
      app.getContactHelper().createContact (new ContactData("primer1", "primer2", "Moscow", "+1234567890", "primer2@mail.ru", "one"),true);
    }
    app.getContactHelper().clicktoDetailsPic();
    app.getContactHelper().modificationContactbyDetails(new ContactData("test1", "test2", null, "+99999", "test3@yahoo.net", null),false);
  }
}
