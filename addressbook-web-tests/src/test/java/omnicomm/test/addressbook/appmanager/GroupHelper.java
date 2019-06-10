package omnicomm.test.addressbook.appmanager;

import omnicomm.test.addressbook.model.GroupData;
import omnicomm.test.addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returntoGroupPage() {
    submit(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    submit(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getGname());
    type(By.name("group_header"), groupData.getGheader());
    type(By.name("group_footer"), groupData.getGfooter());
  }

  public void initGroupCreation() {
    submit(By.name("new"));
  }

  public void deleteSelectedGroups() {
    submit(By.xpath("(//input[@name='delete'])"));
  }

  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value= '" + id + "']")).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    groupCache = null;
    returntoGroupPage();
  }

  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    groupCache = null;
    returntoGroupPage();
  }

  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroups();
    groupCache = null;
    returntoGroupPage();
  }

  private Groups groupCache = null;

  public Groups all() {
    if (groupCache != null) {
      return new Groups(groupCache);
    }
    groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCache.add(new GroupData()
              .withId(id)
              .withGname(name));
    }
    return new Groups(groupCache);
  }
  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
