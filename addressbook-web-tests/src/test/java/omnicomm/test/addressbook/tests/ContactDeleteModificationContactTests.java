package omnicomm.test.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteModificationContactTests extends TestBase {
  @Test
  public void testDeleteModificationContact () throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().clicktoEditPic();
    app.getContactHelper().DeleteContact();
    app.getContactHelper().returnToHomepage();

  }
}
