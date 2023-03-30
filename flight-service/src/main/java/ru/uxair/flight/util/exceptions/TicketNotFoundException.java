package ru.uxair.flight.util.exceptions;

public class TicketNotFoundException extends AbstractResourceNotFoundException{
    public TicketNotFoundException(String resourceId) {
        super(resourceId);
    }

    public TicketNotFoundException() {
    }

    @Override
    protected String getResourceAlias() {
        return "Ticket";
    }
}
