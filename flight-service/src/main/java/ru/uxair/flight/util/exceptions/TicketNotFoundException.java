package ru.uxair.flight.util.exceptions;

public class TicketNotFoundException extends AbstractResourceNotFoundException{
    public TicketNotFoundException(String message) {
        super(message);
    }

    @Override
    protected String getResourceAlias() {
        return null;
    }
}
