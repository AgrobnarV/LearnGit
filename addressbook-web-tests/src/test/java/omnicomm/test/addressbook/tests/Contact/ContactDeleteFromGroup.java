package omnicomm.test.addressbook.tests.Contact;

import omnicomm.test.addressbook.model.ContactData;
import omnicomm.test.addressbook.model.Contacts;
import omnicomm.test.addressbook.model.GroupData;
import omnicomm.test.addressbook.model.Groups;
import omnicomm.test.addressbook.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeleteFromGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if(app.db().groups().size() == 0){
      app.goTo().homePage();
      app.group().create(new GroupData().withGname("test 1").withGheader("header").withGfooter("footer"));
    }
    if(app.db().contacts().size() == 0){
      app.goTo().homePage();
      ContactData newContact = new ContactData()
              .withFirstname("name 1")
              .withLastname("lastname 1")
              .withAddress("address 1")
              .withTelephone("+380971785225")
              .withEmail("email 1");
      app.contact().createContact(newContact);
      app.goTo().homePage();
    }
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
      app.goTo().homePage();
      contacts = new Contacts().withAdded(newContact);
    }
    app.goTo().homePage();
    ContactData modify = contacts.iterator().next();
    groups.removeAll(modify.getGroups());
    app.contact().addToGroup(modify, groups.iterator().next());
    ContactData modified = app.db().contacts().stream().filter(c -> c.getId() == modify.getId()).collect(Collectors.toList()).iterator().next();
    assertThat(modified.getGroups(), equalTo(modify.getGroups().withAdded(groups.iterator().next())));
  }

  @Test
  public void testRemoveContactFromGroup(){
    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts().stream().filter(c -> c.getGroups().size() > 0).collect(Collectors.toCollection(Contacts::new));

    if (contacts.size() == 0) {
      ContactData newContact = new ContactData()
              .withFirstname("name 1")
              .withLastname("lastname 1")
              .withAddress("address 1")
              .withTelephone("+380971785225")
              .withEmail("email 1")
              .inGroup(groups.iterator().next());
      app.contact().createContact(newContact);
      app.goTo().homePage();
      contacts = new Contacts().withAdded(newContact);
    }

    ContactData contact = contacts.iterator().next();
    app.goTo().homePage();
    app.contact().removeGroupFrom(contact);
    app.goTo().homePage();
    ContactData contactWithoutGroup = app.db().contacts().stream().filter(c -> c.getId() == contact.getId()).collect(Collectors.toList()).iterator().next();
    assertThat(contactWithoutGroup.getGroups(), equalTo(contact.getGroups().withoutGroup(contact.getGroups().iterator().next())));
  }
}
