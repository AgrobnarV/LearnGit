package omnicomm.test.addressbook.appmanager;

import omnicomm.test.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
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

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returntoGroupPage();
  }

  public boolean isThereaGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public void modificationGroup(GroupData group) {
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returntoGroupPage();
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      String id = element.findElement(By.tagName("input")).getAttribute("value");
      GroupData group = new GroupData(id, name, null, null);
      groups.add(group);
    }
    return groups;
  }

}
