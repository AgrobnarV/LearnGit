package omnicomm.test.addressbook.tests.Contact;

import omnicomm.test.addressbook.tests.TestBase;
import omnicomm.test.addressbook.model.ContactData;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      ContactData newContact = new ContactData()
              .withFirstname("test1")
              .withLastname("test2")
              .withAddress("Russia, Moscow")
              .withTelephone("89091234567")
              .withMobilePhone("+8 751 58 790")
              .withWorkPhone("44 12345678")
              .withEmail("test1@gmail.com")
              .withEmailHome("test2@yandex.ru")
              .withEmailWork("test3@mail.ru")
              .withHomepage("testbase.ru");
 //           .withGroup("test4");
      app.contact().createContact(newContact);
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactPhones() {
    ContactData contact = app.db().contacts().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    MatcherAssert.assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    verifyContactListInUI();
  }

  private String mergeEmails(ContactData contact) {
    return Stream.of(contact.getEmail(), contact.getEmailHome(), contact.getEmailWork()).filter(s -> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactData contact) {
    return Stream.of(contact.getTelephone(), contact.getMobilePhone(), contact.getWorkPhone()).filter((s) -> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("[-()\\s]", "");
  }
}
