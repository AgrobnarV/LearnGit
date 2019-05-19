package omnicomm.test.addressbook.appmanager;

import omnicomm.test.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomepage() {
    submit(By.linkText("home"));
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactform(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getTelephone());
    type(By.name("email"), contactData.getEmail());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void clickSearchField() {
    click(By.name("searchstring"));
  }

  public void fillSearchForm() {
    type(By.name("searchstring"), "Anton");
  }

  public void type(By locator, String text) {
    click(locator);
    if (text != null) {
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
    }
  }

  public void clickAllContacts() {
    click(By.xpath("//input[@id='MassCB']"));
  }

  public void selectContact() {
    submit(By.name("selected[]"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void clicktoDetailsPic() {
    click(By.xpath("//img[@alt='Details']"));
  }

  public void clicktoModify() {
    click(By.name("modifiy"));
  }

  public void clicktoUpdate() {
    click(By.name("update"));
  }

  public void clicktoEditPic() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void DeleteContact() {
    click(By.xpath("(//input[@name='update'])[3]")); // нажимаем кнопку Delete
  }
}
