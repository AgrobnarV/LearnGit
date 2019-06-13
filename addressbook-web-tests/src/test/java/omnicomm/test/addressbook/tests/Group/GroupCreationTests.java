package omnicomm.test.addressbook.tests.Group;

import omnicomm.test.addressbook.model.GroupData;
import omnicomm.test.addressbook.model.Groups;
import omnicomm.test.addressbook.tests.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new GroupData().withGname("test 1").withGheader("header 1").withGfooter("footer 1")});
    list.add(new Object[]{new GroupData().withGname("test 2").withGheader("header 2").withGfooter("footer 2")});
    list.add(new Object[]{new GroupData().withGname("test 3").withGheader("header 3").withGfooter("footer 3")});
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(
            before.withAdded(group.withId(
                    after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));   //максимум среди id всех групп
  }
}
