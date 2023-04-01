package ru.uxair.flight.util.exceptions;



public class SeatTypeNotFoundExeption extends AbstractResourceNotFoundException {

    public SeatTypeNotFoundExeption(String id) {
        super(id);
    }

    @Override
    protected String getResourceAlias() {
        return "Seat";
    }
}