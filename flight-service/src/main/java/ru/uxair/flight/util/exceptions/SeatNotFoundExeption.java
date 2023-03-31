package ru.uxair.flight.util.exceptions;

import ru.uxair1.flightService.util.exceptions.AbstractResourceNotFoundException;

public class SeatNotFoundExeption extends AbstractResourceNotFoundException {

    public SeatNotFoundExeption(String id) {
            super(id);
        }

        @Override
        protected String getResourceAlias() {
            return "Seat";
        }
    }
