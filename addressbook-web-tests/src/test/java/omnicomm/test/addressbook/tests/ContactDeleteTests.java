package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactDeleteTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition () {
    app.goTo().homePage();
    if (app.contact().contList().size() == 0) {
      app.contact().createContact(new ContactData()
              .withAddress("test3")
              .withTelephone("test4")
              .withEmail("test1@test.ru")
              .withGroup("test5"));
    }
  }

  @Test
  public void testContactDelete() throws Exception {
    List<ContactData> before = app.contact().contList();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().contList();
    Assert.assertEquals(after.size(), index);

    before.remove(index);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
