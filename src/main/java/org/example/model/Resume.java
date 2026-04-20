package org.example.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public final class Resume implements Comparable<Resume> {
  private final String uuid;
  private final String fullname;
  private final Map<ContactType, AbstractSection> contacts;
  private final Map<SectionType, AbstractSection> sections;

  public Resume() {
    this(UUID.randomUUID().toString());
  }

  public Resume(String uuid) {
    this(uuid, "Default Name");
  }

  public Resume(String uuid, String fullname) {
    this(uuid, fullname, new HashMap<>());
  }

  public Resume(String uuid, String fullname, Map<ContactType, AbstractSection> contacts) {
    this(uuid, fullname, contacts, new HashMap<>());
  }

  public Resume(String uuid, String fullname, Map<ContactType, AbstractSection> contacts,
      Map<SectionType, AbstractSection> sections) {
    Objects.requireNonNull(uuid, "Uuid must not be null");
    Objects.requireNonNull(fullname, "Fullname must not be null");
    Objects.requireNonNull(contacts, "Contacts must not be null");
    Objects.requireNonNull(sections, "Sections must not be null");
    if (uuid.isBlank()) {
      throw new IllegalArgumentException("Uuid must not be blank");
    }
    if (fullname.isBlank()) {
      throw new IllegalArgumentException("Fullname must not be blank");
    }
    this.uuid = uuid;
    this.fullname = fullname;
    this.contacts = new HashMap<>(contacts);
    this.sections = new HashMap<>(sections);
  }

  public String getUuid() {
    return uuid;
  }

  public String getFullname() {
    return fullname;
  }

  public Map<ContactType, AbstractSection> getContacts() {
    return Map.copyOf(contacts);
  }

  public Map<SectionType, AbstractSection> getSections() {
    return Map.copyOf(sections);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Resume resume = (Resume) o;
    return uuid.equals(resume.uuid);
  }

  @Override
  public int hashCode() {
    return uuid.hashCode();
  }

  @Override
  public int compareTo(Resume o) {
    Objects.requireNonNull(o, "Cannot compare with null");
    return uuid.compareTo(o.uuid);
  }
}
