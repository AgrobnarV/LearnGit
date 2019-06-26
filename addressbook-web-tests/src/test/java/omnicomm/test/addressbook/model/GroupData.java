package omnicomm.test.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupData {

  @XStreamOmitField
  @Id
  @Column(name = "group_id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "group_name")
  private String gname;

  @Expose
  @Column(name = "group_header")
  @Type(type = "text")
  private String gheader;

  @Column(name = "group_footer")
  @Type(type = "text")
  @Expose
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
            Objects.equals(gname, groupData.gname) &&
            Objects.equals(gheader, groupData.gheader) &&
            Objects.equals(gfooter, groupData.gfooter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, gname, gheader, gfooter);
  }
}