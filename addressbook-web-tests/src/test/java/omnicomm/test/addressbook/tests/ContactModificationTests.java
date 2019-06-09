package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition () {
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
    Set<ContactData> before = app.contact().contAll();
    ContactData modifiedGroup = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedGroup.getId())
            .withFirstname("test1")
            .withLastname("test2")
            .withAddress("test3")
            .withTelephone("test4")
            .withEmail("test5@test6.ru")
            .withGroup("test123");

    app.contact().modify(contact);
    Set<ContactData> after = app.contact().contAll();
    Assert.assertEquals(before.size(), after.size());

    before.remove(modifiedGroup);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
