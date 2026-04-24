package org.example.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public final class Resume implements Comparable<Resume> {
    private final String uuid;
    private final String fullname;
    private final Map<ContactType, AbstractContent> contacts;
    private final Map<SectionType, AbstractContent> sections;

    public Resume() {
        this(UUID.randomUUID().toString());
    }

    public Resume(String uuid) {
        this(uuid, "Default Name");
    }

    public Resume(String uuid, String fullname) {
        this(uuid, fullname, new EnumMap<>(ContactType.class));
    }

    public Resume(String uuid, String fullname, Map<ContactType, AbstractContent> contacts) {
        this(uuid, fullname, contacts, new EnumMap<>(SectionType.class));
    }

    public Resume(
            String uuid,
            String fullname,
            Map<ContactType, AbstractContent> contacts,
            Map<SectionType, AbstractContent> sections) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullname, "fullname must not be null");
        Objects.requireNonNull(contacts, "contacts must not be null");
        Objects.requireNonNull(sections, "sections must not be null");
        if (uuid.isBlank()) {
            throw new IllegalArgumentException("uuid must not be blank");
        }
        if (fullname.isBlank()) {
            throw new IllegalArgumentException("fullname must not be blank");
        }
        this.uuid = uuid;
        this.fullname = fullname;
        this.contacts = new EnumMap<>(contacts);
        this.sections = new EnumMap<>(sections);
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullname() {
        return fullname;
    }

    public Map<ContactType, AbstractContent> getContacts() {
        return Map.copyOf(contacts);
    }

    public Map<SectionType, AbstractContent> getSections() {
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
