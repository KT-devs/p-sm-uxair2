package ru.uxair.flight.entity;

public enum WeekDay {
    MONDAY("Понедельник", "ПН"), TUESDAY("Вторник", "ВТ"), WEDNESDAY("Среда", "СР"),
    THURSDAY("Четверг", "ЧТ"), FRIDAY("Пятница", "ПТ"), SATURDAY("Суббота", "СБ"),
    SUNDAY("Воскресенье", "ВС");

    private String longName;
    private String shortName;

    private WeekDay(String value, String shortName) {
        this.longName = value;
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public String getShortName() {
        return shortName;
    }
}
