package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition () {
    app.goTo().gotoHomePage();
    if (!app.getContactHelper().isThereaContact()) {
      app.getContactHelper().createContact(new ContactData(null, null, "test3", "test4", "test1@test.ru", "test5"));
    }
  }

  @Test
  public void testModificationContactbyIcon() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    app.getContactHelper().selectContact(index);
    app.getContactHelper().clicktoEditPic(index);
    ContactData contact = new ContactData(before.get(index).getId(), "test1", "test2", "test3", "test4", "test5@test6.net", "test7");
    app.getContactHelper().modificationContact(contact);

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
