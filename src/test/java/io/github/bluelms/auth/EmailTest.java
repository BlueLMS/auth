package io.github.bluelms.auth;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailTest {

    @ParameterizedTest
    @MethodSource("invalidAddresses")
    void creating_from_invalid_address(String address) {
        assertThrows(IllegalArgumentException.class, () -> {
            Email.fromString(address);
        });
    }

    static Stream<String> invalidAddresses() {
        return Stream.of("invalid", "@example.com", "example.com");
    }

    @Test
    void creating_from_valid_address() throws IllegalArgumentException {
        Email email = Email.fromString("dejan@example.com");

        assertSame("dejan@example.com", email.address());
    }
}
