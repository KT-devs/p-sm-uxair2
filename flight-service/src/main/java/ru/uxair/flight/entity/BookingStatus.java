package ru.uxair.flight.entity;

public enum BookingStatus {
    RESERVED("Зарезервировано"), PAID("Оплачено"), CANCELED("Отменено");

    private String value;

    private BookingStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
