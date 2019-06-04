package omnicomm.test.addressbook.appmanager;

import omnicomm.test.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
  private boolean creation;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomepage() {
    click(By.linkText("home"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactform(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getTelephone());
    type(By.name("email"), contactData.getEmail());

    if ( creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertTrue(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
    wd.findElement(By.cssSelector("div.msgbox"));
  }

  public void clicktoUpdate() {
    click(By.name("update"));
  }

  public void clicktoEditPic() {
    click(By.xpath("//img[@alt='Edit']"));
  }


  public boolean isThereaContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData contactData)  {
    initContactCreation();
    fillContactform (new ContactData("test23", "test33", "test6788", "98343434343", "shjkfjksfs@mail.ru", "test1"));
    submitContactCreation();
    returnToHomepage();
  }

  public void modificationContact(ContactData contactData) {
    fillContactform(new ContactData("test23", "test33", "test123", "1213213", "s1211@mail.ru", "test2"));
    clicktoUpdate();
    returnToHomepage();
  }

  public int getContactCount() {
    return  wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts =new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for(WebElement element : elements) {
      List<WebElement> elements1 = element.findElements(By.tagName("td"));
      String firstname = elements1.get(2).getText();
      String lastname = elements1.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, firstname, lastname);
      contacts.add(contact);
    }

    return contacts;
  }
}
