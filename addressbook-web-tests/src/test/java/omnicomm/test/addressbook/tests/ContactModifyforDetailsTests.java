package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModifyforDetailsTests extends TestBase {
  @Test
  public void testModificationContact () throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().clicktoDetailsPic();
    app.getContactHelper().clicktoModify();
    app.getContactHelper().fillContactform(new ContactData("Kus", "Kusov", null, "+440112457", "123123@mail.ru",null),false);
    app.getContactHelper().clicktoUpdate();
    app.getContactHelper().returnToHomepage();
  }
}
