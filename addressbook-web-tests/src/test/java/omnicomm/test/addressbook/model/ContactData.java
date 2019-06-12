package omnicomm.test.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String address;
  private String telephone;
  private String mobilePhone;
  private String workPhone;
  private String allPhones;
  private String email;
  private String emailHome;
  private String emailWork;
  private String allEmails;
  private String group;
  private String homepage;

  public ContactData withId(int id) { this.id = id; return this;}

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withTelephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmailHome(String emailHome) {
    this.emailHome = emailHome;
    return this;
  }
  public ContactData withEmailWork(String emailWork) {
    this.emailWork = emailWork;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }


  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getTelephone() {
    return telephone;
  }

  public String getWorkPhone() {return workPhone;}

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getAllPhones() { return allPhones; }

  public String getEmail() {
    return email;
  }

  public String getEmailHome() {
    return emailHome;
  }

  public String getEmailWork() {
    return emailWork;
  }

  public String getAllEmails() { return allEmails; }

  public String getGroup() {
    return group;
  }

  public String getHomepage() { return homepage; }


  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }
}
