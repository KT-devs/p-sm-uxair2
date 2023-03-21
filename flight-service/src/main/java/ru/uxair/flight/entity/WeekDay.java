package ru.uxair.flight.entity;

public enum WeekDay {
    MONDAY("Понедельник"), TUESDAY("Вторник"), WEDNESDAY("Среда"), THURSDAY("Четверг"), FRIDAY("Пятница"),
    SATURDAY("Суббота"), SUNDAY("Воскресенье");

    private String value;

    private WeekDay(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
