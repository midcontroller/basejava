package org.example.model;

public enum ContactType {
    PHONE("Тел."),
    EMAIL("Почта"),
    SKYPE("Skype"),
    GITHUB("Github"),
    LINKEDIN("Профиль Linkedin"),
    HOMEPAGE("Домашняя страница"),
    STACKOVERFLOW("Профиль Stackoverflow");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
