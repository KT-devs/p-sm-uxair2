package ru.uxair.flight.util.exceptions;

public class AircraftNotFoundException extends AbstractResourceNotFoundException{

    public AircraftNotFoundException() {}

    public AircraftNotFoundException(String id) {
        super(id);
    }

    @Override
    protected String getResourceAlias() {
        return "Aircraft";
    }
}
