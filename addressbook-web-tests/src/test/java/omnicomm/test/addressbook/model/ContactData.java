package omnicomm.test.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private  String firstname;
  private  String lastname;
  private  String address;
  private  String telephone;
  private  String email;
  private String group;

  public ContactData( String firstname, String lastname, String address, String telephone, String email, String group)  {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.telephone = telephone;
    this.email = email;
    this.group = group;
  }

  public ContactData(int id, String firstname, String lastname, String address, String telephone, String email, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.telephone = telephone;
    this.email = email;
    this.group = group;
  }

  public ContactData(int id, String firstName, String lastName) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
  }



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

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
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
