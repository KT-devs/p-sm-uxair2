package ru.uxair.flight.entity;

public enum SeatCategory {
    FIRST("Первый класс"), BUSINESS("Бизнес"), ECONOMY("Эконом");

    private String value;

    private SeatCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
