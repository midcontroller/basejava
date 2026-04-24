package org.example.model;

public enum SectionType {
    PERSONAL,
    OBJECTIVE,
    ACHIEVEMENT,
    QUALIFICATIONS,
    EXPERIENCE,
    EDUCATION;

    public String getTitle() {
        return name() + ": ";
    }
}
