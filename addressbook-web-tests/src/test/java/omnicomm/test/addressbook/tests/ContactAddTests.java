package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactAddTests extends TestBase {

  @Test
  public void testNewContact() throws Exception {
    app.getContactHelper().createContact(new ContactData("primer1", "primer2", "Moscow", "+1234567890", "primer2@mail.ru", "one"),true);
  }
}
