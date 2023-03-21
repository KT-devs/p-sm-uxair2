package ru.uxair.flight.entity;

public enum FlightStatus {
    SCHEDULED("По расписанию"), ONTIME("Вовремя"), DELAYED("С задержкой"), DEPARTED("Отбыл"),
    ARRIVED("Прибыл"), CANCELED("Отменен");

    private String value;

    private FlightStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
