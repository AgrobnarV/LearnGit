package omnicomm.test.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteContacts extends TestBase {

  @Test
  public void testContactDelete () throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
  }
}
