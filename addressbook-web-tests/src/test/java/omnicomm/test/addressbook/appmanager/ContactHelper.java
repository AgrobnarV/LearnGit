package omnicomm.test.addressbook.appmanager;

import omnicomm.test.addressbook.model.ContactData;
import omnicomm.test.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
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
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmailHome());
    type(By.name("email3"), contactData.getEmailWork());
    attach(By.name("photo"),contactData.getPhoto());

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

 /* public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }*/


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
      String name = elements1.get(2).getText();
      String lastname = elements1.get(1).getText();
      String address = elements1.get(3).getText();
      String allEmails = elements1.get(4).getText();
      String allPhones = elements1.get(5).getText();
      int id = Integer.parseInt(elements1.get(0).findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData()
              .withId(id)
              .withFirstname(name)
              .withLastname(lastname)
              .withAddress(address)
              .withAllEmails(allEmails)
              .withAllPhones(allPhones)
      );
    }
    return new Contacts(contactCache);
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public ContactData infoFromEditForm(ContactData contact) {
    picEditById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withFirstname(firstname)
            .withLastname(lastname)
            .withAddress(address)
            .withTelephone(home)
            .withMobilePhone(mobile)
            .withWorkPhone(work)
            .withEmail(email)
            .withEmailHome(email2)
            .withEmailWork(email3)
            .withHomepage(home);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }
}
