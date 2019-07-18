package omnicomm.test.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupData> {
  private Set<GroupData> delegate;

  public Groups(Groups groups) {
    this.delegate = new HashSet<GroupData>(groups.delegate);
  }

  public Groups() {
    this.delegate = new HashSet<GroupData>();
  }

  public Groups(Collection<GroupData> groups) {
    this.delegate = new HashSet<GroupData>(groups);
  }

  @Override
  protected Set<GroupData> delegate() {
    return delegate;
  }
  public Groups withAdded(GroupData groupData) {
    Groups groups = new Groups(this);
    groups.add(groupData);
    return groups;
  }
  public Groups withoutGroup(GroupData groupData) {
    Groups groups = new Groups(this);
    groups.remove(groupData);
    return groups;
  }

  public Groups withEdited(GroupData editedGroup, GroupData group) {
    Groups groups = new Groups(this);
    groups.remove(editedGroup);
    groups.add(group);
    return groups;
  }
}
