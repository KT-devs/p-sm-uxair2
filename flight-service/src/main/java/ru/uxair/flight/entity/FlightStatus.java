package ru.uxair.flight.entity;

public enum FlightStatus {
    SCHEDULED("Запланирован"), ONTIME("По расписанию"), DELAYED("Задержан"), DEPARTED("Вылетел"),
    ARRIVED("Прибыл"), CANCELED("Отменен");

    private String value;

    private FlightStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
