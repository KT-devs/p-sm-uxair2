package ru.uxair.notification.util.exceptions;

public final class AliasConstants {

    public static final String USER = "User";
    public static final String GUEST = "Guest";
    public static final String ROLE = "Role";
    public static final String PERMISSION = "Permission";

    private AliasConstants() {
        throw new AssertionError("Suppress default constructor for non instantiability");
    }
}
