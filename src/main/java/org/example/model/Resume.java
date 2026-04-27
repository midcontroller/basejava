package org.example.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public final class Resume implements Comparable<Resume> {
    private final String uuid;
    private final String fullName;
    private final Map<ContactType, Section> contacts = new EnumMap<>(ContactType.class);
    private final Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

    public Resume() {
        this(UUID.randomUUID().toString());
    }

    public Resume(String uuid) {
        this(uuid, "Default name");
    }

    public Resume(
            String uuid,
            String fullName) {
        Objects.requireNonNull(uuid, "uuid cannot be null");
        if (uuid.isBlank()) {
            throw new IllegalArgumentException("uuid cannot be blank");
        }
        this.uuid = uuid;

        Objects.requireNonNull(fullName, "fullName cannot be null");
        if (fullName.isBlank()) {
            throw new IllegalArgumentException("fullName cannot be blank");
        }
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public Map<ContactType, Section> getContacts() {
        return Map.copyOf(contacts);
    }

    public Map<SectionType, Section> getSections() {
        return Map.copyOf(sections);
    }

    public void addContacts(ContactType type, Section section) {
        contacts.put(type, section);
    }

    public void addSection(SectionType type, Section section) {
        sections.put(type, section);
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
        return Objects.equals(uuid, resume.uuid)
                && Objects.equals(fullName, resume.fullName)
                && Objects.equals(contacts, resume.contacts)
                && Objects.equals(sections, resume.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, contacts, sections);
    }

    @Override
    public int compareTo(Resume o) {
        Objects.requireNonNull(o, "Cannot compare with null");
        return uuid.compareTo(o.uuid);
    }
}
