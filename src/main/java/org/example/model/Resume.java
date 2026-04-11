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

    Objects.requireNonNull(fullName, "FullName must not be null");
    if (fullName.isBlank()) {
      throw new IllegalArgumentException();
    }
    this.fullName = fullName;
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
}
