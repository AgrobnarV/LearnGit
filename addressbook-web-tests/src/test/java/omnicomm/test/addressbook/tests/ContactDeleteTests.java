package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import omnicomm.test.addressbook.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeleteTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
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
    Contacts before = app.contact().contAll();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().contAll();
    Assert.assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(
            before.withoutContact(deletedContact)));
  }
}
