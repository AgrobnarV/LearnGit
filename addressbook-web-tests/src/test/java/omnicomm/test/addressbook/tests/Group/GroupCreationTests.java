package omnicomm.test.addressbook.tests.Group;

import omnicomm.test.addressbook.model.GroupData;
import omnicomm.test.addressbook.model.Groups;
import omnicomm.test.addressbook.tests.TestBase;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withGname("test2");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(
            before.withAdded(group.withId(
                    after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));   //максимум среди id всех групп
  }
}
