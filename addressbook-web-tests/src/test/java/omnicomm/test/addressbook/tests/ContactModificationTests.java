package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import omnicomm.test.addressbook.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (app.contact().contAll().size() == 0) {
      app.contact().createContact(new ContactData()
              .withFirstname("test1")
              .withLastname("test2")
              .withAddress("test3")
              .withTelephone("test4")
              .withEmail("test1@test.ru")
              .withGroup("test5"));
    }
  }

  @Test
  public void testModifyContactIcon() {
    Contacts before = app.contact().contAll();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstname("test1")
            .withLastname("test2")
            .withAddress("test3")
            .withTelephone("test4")
            .withEmail("test5@test6.ru")
            .withGroup("test123");

    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().contAll();
    assertThat(after, equalTo(
            before.withoutContact(modifiedContact).withAdded(contact)));
  }
}
