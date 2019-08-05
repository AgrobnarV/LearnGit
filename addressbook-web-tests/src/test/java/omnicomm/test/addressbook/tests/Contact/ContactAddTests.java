package omnicomm.test.addressbook.tests.Contact;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import omnicomm.test.addressbook.tests.TestBase;
import omnicomm.test.addressbook.model.ContactData;
import omnicomm.test.addressbook.model.Contacts;
import omnicomm.test.addressbook.model.GroupData;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsXml() throws IOException {
    File photo = new File("src/test/resources/test1.jpg");
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contact = (List<ContactData>) xstream.fromXML(xml);
      return contact.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsJson() throws IOException {
    File photo = new File("src/test/resources/test1.jpg");
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contact = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());
      return contact.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }
  }


  @Test(dataProvider = "validContactsJson")
  public void testNewContact(ContactData contacts) throws Exception {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withGname("test 1"));

    }
    Contacts before = app.db().contacts();
    app.goTo().homePage();
    app.contact().buttonAddContact();
    app.contact().createContact(contacts);
    MatcherAssert.assertThat(app.group().count(), equalTo(before.size() + 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(
            before.withAdded(contacts.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));   //максимум среди id всех контактов
    verifyContactListInUI();
  }
}
