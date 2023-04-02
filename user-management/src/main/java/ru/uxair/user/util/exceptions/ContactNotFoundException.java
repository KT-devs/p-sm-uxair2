package ru.uxair.user.util.exceptions;

public class ContactNotFoundException extends AbstractResourceNotFoundException{
    public ContactNotFoundException(String resourceId) {
        super(resourceId);
    }

    public ContactNotFoundException() {
    }

    @Override
    protected String getResourceAlias() {
        return "Contact";
    }
}
