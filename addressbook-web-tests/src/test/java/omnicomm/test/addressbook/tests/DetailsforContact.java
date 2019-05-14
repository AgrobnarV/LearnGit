package omnicomm.test.addressbook.tests;

import org.testng.annotations.Test;

public class DetailsforContact extends TestBase {
  @Test
  public void testDetailsforContact () throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().clicktoDetails();
    app.getContactHelper().returnToHomepage();
  }
}
