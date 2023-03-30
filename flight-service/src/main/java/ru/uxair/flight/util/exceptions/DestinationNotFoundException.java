package ru.uxair.flight.util.exceptions;

public class DestinationNotFoundException extends AbstractResourceNotFoundException {

    public DestinationNotFoundException() {}

    public DestinationNotFoundException(String id) {
        super(id);
    }

    @Override
    protected String getResourceAlias() {
        return "Destination";
    }
}
