package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeleteTests extends TestBase {

  @Test
  public void testContactDelete() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereaContact()) {
      app.getContactHelper().createContact(new ContactData("test23", "test33", "test3", "test4", "test1@test.ru", "test5"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContact();
  //  app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }

}
