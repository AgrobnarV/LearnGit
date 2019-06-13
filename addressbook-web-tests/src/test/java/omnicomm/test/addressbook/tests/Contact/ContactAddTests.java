package omnicomm.test.addressbook.tests.Contact;

import omnicomm.test.addressbook.model.ContactData;
import omnicomm.test.addressbook.model.Contacts;
import omnicomm.test.addressbook.model.GroupData;
import omnicomm.test.addressbook.tests.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    File photo = new File("src/test/resources/test1.jpg");
    list.add(new Object[]{new ContactData().withFirstname("test 13").withLastname("test 23").withPhoto(photo).withAddress("Russia, Moscow").withTelephone("+1234567890").withEmail("test1@mail.ru").withHomepage("ololo.ru").withGroup("test 1")});
    list.add(new Object[]{new ContactData().withFirstname("test 33").withLastname("test 43").withPhoto(photo).withAddress("USA, New York").withTelephone("+6999021021").withEmail("test2@yandex.ru").withHomepage("kuskus.com").withGroup("test 1")});
    list.add(new Object[]{new ContactData().withFirstname("test 53").withLastname("test 63").withPhoto(photo).withAddress("UK, London").withTelephone("+4412587098").withEmail("test3@gmail.com").withHomepage("tapok.net").withGroup("one")});
    return list.iterator();
  }

  @Test(dataProvider = "validContacts")
  public void testNewContact(ContactData contacts) throws Exception {
    /*   File photo = new File("src/test/resources/test1.jpg");
    ContactData contact = new ContactData()
            .withFirstname("test23")
            .withLastname("test33")
            .withAddress("Moscow123")
            .withTelephone("+1234567890")
            .withEmail("primer2@mail.ru")
            .withGroup("one")
            .withPhoto(photo); */
    if (app.group().all().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withGname("test 1"));

    }
    app.goTo().homePage();
    Contacts before = app.contact().contAll();
    app.contact().buttonAddContact();
    app.contact().createContact(contacts);
    Contacts after = app.contact().contAll();
    assertThat(app.group().count(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contacts.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));   //максимум среди id всех контактов
  }
}
