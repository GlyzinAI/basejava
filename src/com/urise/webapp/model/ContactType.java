package com.urise.webapp.model;

public enum ContactType {
    PHONE("Телефон"),
    LIVE("Проживание"),
    EMAIL("Почта"),
    SKYPE("Skype");

    private String title;

    ContactType(String title) {
        this.title = title;
    }
}
