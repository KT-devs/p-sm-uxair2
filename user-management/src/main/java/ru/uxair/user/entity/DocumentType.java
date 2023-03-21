package ru.uxair.user.entity;

public enum DocumentType {
    NATIONAL_PASSPORT("Пасспорт"), INTERNATIONAL_PASSPORT("Международный пасспорт");
    private String value;
    private DocumentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
