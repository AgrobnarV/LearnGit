package omnicomm.test.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDetailTests extends TestBase {
  @Test
  public void testDetailsforContact () throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().clicktoDetailsPic();
    app.getContactHelper().returnToHomepage();
  }
}
