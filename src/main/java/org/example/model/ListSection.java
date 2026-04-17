package org.example.model;

import java.util.List;
import java.util.Objects;

public class ListSection extends Section {
  private final List<String> items;

  public ListSection(List<String> items) {
    this.items = items;
  }

  public List<String> getItems() {
    return items;
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    ListSection other = (ListSection) obj;
    return Objects.equals(items, other.items);
  }
}
