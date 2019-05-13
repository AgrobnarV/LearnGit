package omnicomm.test.addressbook.appmanager;

import omnicomm.test.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomepage() {
    click(By.linkText("home page")); }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactform(ContactData contactData) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("lastname"),contactData.getLastname());
    type(By.name("address"),contactData.getAddress());
    type(By.name("home"),contactData.getTelephone());
    type(By.name("email"),contactData.getEmail());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void clickSearchField() {
    click(By.name("searchstring"));
  }

  public void fillSearchForm() {
    searchform(By.name("searchstring"), "Anton");
  }

  private void searchform(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void clickAllContacts() {
    click(By.xpath("//input[@id='MassCB']"));
  }
}
