package omnicomm.test.addressbook.tests.Contact;

import omnicomm.test.addressbook.model.ContactData;
import omnicomm.test.addressbook.model.Contacts;
import omnicomm.test.addressbook.model.GroupData;
import omnicomm.test.addressbook.model.Groups;
import omnicomm.test.addressbook.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddToGroup extends TestBase {

/*  @BeforeMethod
  public void ensurePreconditions() {
    if(app.db().groups().size() == 0){
      app.goTo().homePage();
      app.group().create(new GroupData().withGname("test 1").withGheader("header").withGfooter("footer"));
    }
    if(app.db().contacts().size() == 0){
      ContactData newContact = new ContactData()
              .withFirstname("name 1")
              .withLastname("lastname 1")
              .withAddress("address 1")
              .withTelephone("+380971785225")
              .withEmail("email 1");
      app.contact().createContact(newContact);
      app.goTo().homePage();
    } */
@BeforeMethod
public void ensurePreconditions() {
  if (app.db().groups().size() == 0) {
    app.goTo().groupPage();
    app.group().create(new GroupData().withGname("test12").withGheader("test23").withGfooter("test"));
  }
  Groups groups = app.db().groups();
  File photo = new File("src/test/resources/test1.jpg");
  if (app.db().contacts().size() == 0) {
    app.contact().buttonAddContact();
    app.contact().createContact(new ContactData().withFirstname("test1").withLastname("test2").withAddress("test3").withTelephone("123").withEmail("test4").withPhoto(photo).inGroup(groups.iterator().next()));
  }
}

  @Test
   public void contactAddToGroup() {
    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts().stream().filter(contact -> contact.getGroups().size() < groups.size()).collect(Collectors.toCollection(Contacts::new));

    if (contacts.size() == 0) {
      ContactData newContact = new ContactData()
              .withFirstname("name 1")
              .withLastname("lastname 1")
              .withAddress("address 1")
              .withTelephone("+380971785225")
              .withEmail("email 1");
      app.contact().createContact(newContact);
      contacts = new Contacts().withAdded(newContact);
    }
    app.goTo().homePage();
    ContactData modify = contacts.iterator().next();
    groups.removeAll(modify.getGroups());
    app.contact().addToGroup(groups.iterator().next(), modify);
    ContactData modified = app.db().contacts().stream().filter(c -> c.getId() == modify.getId()).collect(Collectors.toList()).iterator().next();
    assertThat(modified.getGroups(), equalTo(modify.getGroups().withAdded(groups.iterator().next())));
  }
}
