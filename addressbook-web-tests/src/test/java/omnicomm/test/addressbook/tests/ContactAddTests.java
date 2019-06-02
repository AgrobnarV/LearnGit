package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactAddTests extends TestBase {

  @Test
  public void testNewContact() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContactData("primer1", "primer2", "Moscow", "+1234567890", "primer2@mail.ru", "one"), true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size()-1, before.size());
  }
}
