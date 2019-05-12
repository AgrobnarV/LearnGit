package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class NewContact extends TestBase {

  @Test
  public void testNewContact() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactform(new ContactData("Andrey", "Bandin", "Russia,Moscow", "+1234567890", "test@yandex.ru"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomepage();
  }
}
