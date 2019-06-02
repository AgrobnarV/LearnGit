package omnicomm.test.addressbook.model;

import java.util.Objects;

public class GroupData {
  private int id;
  private final String gname;
  private final String gheader;
  private final String gfooter;

  public GroupData(String gname, String gheader, String gfooter) {
    this.id = 0;
    this.gname = gname;
    this.gheader = gheader;
    this.gfooter = gfooter;
  }
  public GroupData(int id, String gname, String gheader, String gfooter) {
    this.id = id;
    this.gname = gname;
    this.gheader = gheader;
    this.gfooter = gfooter;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id &&
            Objects.equals(gname, groupData.gname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, gname);
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", gname='" + gname + '\'' +
            '}';
  }

  public int getId() { return id;  }

  public void setId(int id) {
    this.id = id;
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