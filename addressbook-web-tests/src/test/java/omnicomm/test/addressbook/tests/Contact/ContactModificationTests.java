package omnicomm.test.addressbook.tests.Contact;

import omnicomm.test.addressbook.model.ContactData;
import omnicomm.test.addressbook.model.Contacts;
import omnicomm.test.addressbook.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if(app.db().contacts().size() == 0){
      app.goTo().homePage();
      app.contact().createContact(new ContactData()
              .withFirstname("test1")
              .withLastname("test2")
              .withAddress("test3")
              .withTelephone("test4")
              .withEmail("test1@test.ru"));
      //      .withGroup("test5"));
    }
  }

  @Test
  public void testModifyContactIcon() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    app.goTo().homePage();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstname("test1")
            .withLastname("test2")
            .withAddress("test3")
            .withTelephone("test4")
            .withEmail("test5@test6.ru");
    //           .withGroup("test123");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(
            before.withoutContact(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}
