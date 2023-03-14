package ru.uxair.authorization.util.exceptions;

public class Base64DecodeException  extends RuntimeException{

    private final String message;

    public Base64DecodeException(final String argument) {
        this.message = buildMessage(argument);
    }

    @Override
    public String getMessage() {
        return message;
    }

    private String buildMessage(final String argument) {
        return "Param was not URL-safe encoded: " + argument;
    }
}
