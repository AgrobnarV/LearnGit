package omnicomm.test.addressbook.appmanager;

import omnicomm.test.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

  public void selectGroup() {
    submit(By.name("selected[]"));
  }
  public void clicktoGroupCheckbox() {
    submit(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='test2'])[1]/input[1]"));
  }
}
