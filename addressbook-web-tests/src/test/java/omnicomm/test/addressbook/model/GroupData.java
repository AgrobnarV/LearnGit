package omnicomm.test.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Objects;

@XStreamAlias("group")

public class GroupData {
  @XStreamOmitField
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
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", gname='" + gname + '\'' +
            '}';
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
}