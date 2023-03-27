package ru.uxair.flight.entity;

public enum BookingStatus {
    RESERVED("Зарезервирован"), PAID("Оплачен"), CANCELED("Отменен");

    private String value;

    private BookingStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
