package ru.uxair.user.entity;

public enum ContactType {
    EMAIL("Email"), PHONE("Телефон"), WHATSAPP("Whatsapp"), TELEGRAM("Telegram");

    private String value;
    private ContactType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
