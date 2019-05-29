package omnicomm.test.addressbook.model;

import java.util.Objects;

public class GroupData {
  private final String gname;
  private final String gheader;
  private final String gfooter;

  public GroupData(String gname, String gheader, String gfooter) {
    this.gname = gname;
    this.gheader = gheader;
    this.gfooter = gfooter;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "gname='" + gname + '\'' +
            '}';
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

  public String getGname() {
    return gname;
  }

  public String getGheader() {
    return gheader;
  }

  public String getGfooter() {
    return gfooter;
  }
}