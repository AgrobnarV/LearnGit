package omnicomm.test.addressbook.tests.Group;

import omnicomm.test.addressbook.model.Groups;
import omnicomm.test.addressbook.tests.TestBase;
import omnicomm.test.addressbook.model.GroupData;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withGname("test1").withGheader("test2").withGfooter("test3"));
    }
  }

  @Test
  public void testGroupModification() {
    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId())
            .withGname("one")
            .withGheader("two")
            .withGfooter("three");
    app.goTo().groupPage();
    app.group().modify(group);
    MatcherAssert.assertThat(app.group().count(), equalTo(before.size())); //в интерфейсе кол-во групп не изменилось
    Groups after = app.db().groups();
    assertThat(after, equalTo(
            before.withoutGroup(modifiedGroup).withAdded(group)));
    verifyGroupListInUI();
  }
}
