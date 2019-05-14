package omnicomm.test.addressbook.tests;

import org.testng.annotations.Test;

public class ContactSearchTests extends TestBase {
  @Test
  public void testSearchContacts () {
    app.getContactHelper().clickSearchField();
    app.getContactHelper().fillSearchForm();
    app.getContactHelper().clickAllContacts();
  }
}
