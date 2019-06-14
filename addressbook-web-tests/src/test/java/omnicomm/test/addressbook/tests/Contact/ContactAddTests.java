package omnicomm.test.addressbook.tests.Contact;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import omnicomm.test.addressbook.model.ContactData;
import omnicomm.test.addressbook.model.Contacts;
import omnicomm.test.addressbook.model.GroupData;
import omnicomm.test.addressbook.tests.TestBase;
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
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
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

  @DataProvider
  public Iterator<Object[]> validContactsJson() throws IOException {
    File photo = new File("src/test/resources/Swi.png");
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null){
      json += line;
      line= reader.readLine();
    }
    Gson gson = new Gson();
    List<ContactData> contact = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
    return contact.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
  }


  @Test(dataProvider = "validContactsJson")
  public void testNewContact(ContactData contacts) throws Exception {
    /*   File photo = new File("src/test/resources/test1.jpg");
    ContactData contact = new ContactData()
            .withFirstname("test23")
            .withLastname("test33")
            .withAddress("Moscow123")
            .withTelephone("+1234567890")
            .withEmail("primer2@mail.ru")
            .withGroup("one")
            .withPhoto(photo); */
    if (app.group().all().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withGname("test 1"));

    }
    app.goTo().homePage();
    Contacts before = app.contact().contAll();
    app.contact().buttonAddContact();
    app.contact().createContact(contacts);
    Contacts after = app.contact().contAll();
    assertThat(app.group().count(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contacts.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));   //максимум среди id всех контактов
  }
}
