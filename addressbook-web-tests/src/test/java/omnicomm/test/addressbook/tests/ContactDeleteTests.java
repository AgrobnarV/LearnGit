package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactDeleteTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition () {
    app.goTo().homePage();
    if (app.contact().contAll().size() == 0) {
      app.contact().createContact(new ContactData()
              .withAddress("test3")
              .withTelephone("test4")
              .withEmail("test1@test.ru")
              .withGroup("test5"));
    }
  }

  @Test
  public void testContactDelete() throws Exception {
    Set<ContactData> before = app.contact().contAll();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().contAll();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }
}
