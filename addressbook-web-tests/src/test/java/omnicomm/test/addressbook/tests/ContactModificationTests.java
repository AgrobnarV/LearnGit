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
    app.goTo().homePage();
    if (app.contact().contList().size() == 0) {
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
    List<ContactData> before = app.contact().contList();
    int index = before.size() - 1;
    ContactData contact = new ContactData()
            .withId(before.get(index).getId())
            .withFirstname("test1")
            .withLastname("test2")
            .withAddress("test3")
            .withTelephone("test4")
            .withEmail("test5@test6.ru")
            .withGroup("test123");

    app.contact().modify(index,contact);
    List<ContactData> after = app.contact().contList();
    Assert.assertEquals(before.size(), after.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
