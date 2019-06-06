package omnicomm.test.addressbook.model;

import java.util.Objects;

public class GroupData {
  private int id = Integer.MAX_VALUE;
  private String gname;
  private String gheader;
  private String gfooter;

  public int getId() {
    return id;
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  public GroupData withGname(String gname) {
    this.gname = gname;
    return this;
  }

  public GroupData withGheader(String gheader) {
    this.gheader = gheader;
    return this;
  }

  public GroupData withGfooter(String gfooter) {
    this.gfooter = gfooter;
    return this;
  }

  public String getGname() {
    return gname;
  }

  public String getGheader() {
    return gheader;
  }

  public String getGfooter() {
    return gfooter;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(gname, groupData.gname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gname);
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", gname='" + gname + '\'' +
            '}';
  }

}