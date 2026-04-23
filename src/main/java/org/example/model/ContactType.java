package org.example.model;

public enum ContactType {
    PHONE,
    EMAIL,
    SKYPE,
    GITHUB,
    LINKEDIN,
    HOMEPAGE,
    STACKOVERFLOW;

    public String getTitle() {
        return name() + ": ";
    }
}
