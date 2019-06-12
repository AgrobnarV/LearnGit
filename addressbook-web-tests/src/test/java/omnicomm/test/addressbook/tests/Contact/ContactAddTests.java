package omnicomm.test.addressbook.tests.Contact;

import omnicomm.test.addressbook.model.ContactData;
import omnicomm.test.addressbook.model.Contacts;
import omnicomm.test.addressbook.tests.TestBase;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddTests extends TestBase {

  @Test
  public void testNewContact() throws Exception {
    Contacts before = app.contact().contAll();
    app.contact().buttonAddContact();
    ContactData contact = new ContactData()
            .withFirstname("test23")
            .withLastname("test33")
            .withAddress("Moscow123")
            .withTelephone("+1234567890")
            .withEmail("primer2@mail.ru")
            .withGroup("one");
    app.contact().createContact(contact);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().contAll();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));   //максимум среди id всех контактов
  }
}
