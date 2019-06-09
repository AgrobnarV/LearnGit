package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactAddTests extends TestBase {

  @Test
  public void testNewContact() throws Exception {
    Set<ContactData> before = app.contact().contAll();
    app.contact().buttonAddContact();
    ContactData contact = new ContactData()
            .withFirstname("test23")
            .withLastname("test33")
            .withAddress("Moscow123")
            .withTelephone("+1234567890")
            .withEmail("primer2@mail.ru")
            .withGroup("one");
    app.contact().createContact(contact);
    Set<ContactData> after = app.contact().contAll();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()); //максимум среди id всех контактов
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
