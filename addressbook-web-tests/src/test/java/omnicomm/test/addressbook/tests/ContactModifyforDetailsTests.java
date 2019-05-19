package omnicomm.test.addressbook.tests;

import omnicomm.test.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModifyforDetailsTests extends TestBase {
  @Test
  public void testModificationContact () throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().clicktoDetailsPic();
    app.getContactHelper().clicktoModify();
    app.getContactHelper().fillContactform(new ContactData(null, "Kusov", "44UK, London Oxford str.", "+440112457", null));
    app.getContactHelper().clicktoUpdate();
    app.getContactHelper().returnToHomepage();
  }
}
