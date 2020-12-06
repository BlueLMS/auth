package io.github.bluelms.auth;

import org.apache.commons.validator.routines.EmailValidator;

public class Email {
    private String address;

    private Email(String address) {
        this.address = address;
    }

    public static Email fromString(String address) throws IllegalArgumentException {
        EmailValidator validator = EmailValidator.getInstance();

        if (!validator.isValid(address)) {
            throw new IllegalArgumentException("Invalid email address.");
        }

        return new Email(address);
    }

    public String address() {
        return address;
    }

    @Override
    public String toString() {
        return address();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Email && ((Email) obj).address.equals(address);
    }
}
