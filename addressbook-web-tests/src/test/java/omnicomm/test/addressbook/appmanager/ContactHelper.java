package omnicomm.test.addressbook.appmanager;

import omnicomm.test.addressbook.model.ContactData;
import omnicomm.test.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactform(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getTelephone());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void returnContact() {
    click(By.linkText("home page"));
  }

  public void homePage() {
    click(By.linkText("home"));
  }

  public void acceptAlertMessage() {
    wd.switchTo().alert().accept();
    wd.findElement(By.cssSelector("div.msgbox"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void submitContact() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void buttonAddContact() {
    click(By.linkText("add new"));
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }


  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
  }

  public void createContact(ContactData contact) {
    fillContactform(contact, true);
    submitContact();
    contactCache = null;
    returnContact();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    picEditById(contact.getId());
    fillContactform(contact, false);
    buttonUpdate();
    contactCache = null;
    homePage();
  }

  public void buttonUpdate() {
    click(By.name("update"));
  }

  public void picEditById(int id) {
    click(By.cssSelector("a[href='edit.php?id=" + id + "']"));
  }


  public void delete(ContactData deletedContact) {
    selectContactById(deletedContact.getId());
    deletionButton();
    acceptAlertMessage();
    contactCache = null;
    homePage();
  }

  public void deletionButton() {
    click(By.xpath("//input[@value='Delete']"));
  }

  private Contacts contactCache = null;

  public Contacts contAll() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));

    for (WebElement element : elements) {
      List<WebElement> elements1 = element.findElements(By.tagName("td"));
      String firstname = elements1.get(2).getText();
      String lastname = elements1.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData()
              .withId(id)
              .withFirstname(firstname)
              .withLastname(lastname));
    }
    return new Contacts(contactCache);
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
