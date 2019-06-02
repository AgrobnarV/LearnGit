package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {
  @Test
  public void testModificationContactbyIcon () throws Exception {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    if (! app.getContactHelper().isThereaContact()) {
      app.getContactHelper().createContact (new ContactData("primer1", "primer2", "Moscow", "+1234567890", "primer2@mail.ru", "one"),true);
    }
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().clicktoEditPic();
    ContactData contact = new ContactData("test3", "test4", null, "+888", "test3@yahoo.net", null);
    app.getContactHelper().modificationContact(contact,false);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size()-1, before.size()-1);
  }
}
