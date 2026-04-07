package org.example.model;

import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume> {
  private final String uuid;
  private final String fullName;

  public Resume() {
    this(UUID.randomUUID().toString(), "Default Name");
  }

  public Resume(String uuid) {
    this(Objects.requireNonNull(uuid), "Default name");
  }

  public Resume(String uuid, String fullName) {
    this.uuid = Objects.requireNonNull(uuid, "Uuid must not be null");
    this.fullName = validateFullName(Objects.requireNonNull(fullName, "FullName must not be null"));
  }

  public String getUuid() {
    return uuid;
  }

  public String getFullName() {
    return fullName;
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
  public String toString() {
    return uuid;
  }

  @Override
  public int compareTo(Resume o) {
    return uuid.compareTo(o.uuid);
  }

  private String validateFullName(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException();
    }
    return name;
  }
}
