package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactAddTests extends TestBase {

  @Test
  public void testNewContact() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactform(new ContactData("primer1", null, null, "+1234567890", "primer2@mail.ru", "test2"),true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomepage();
  }
}
