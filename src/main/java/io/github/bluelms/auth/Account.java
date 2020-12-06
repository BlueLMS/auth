package io.github.bluelms.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    private String id;

    @Column
    private String email;

    @Column
    private String password;

    public Account(String id, Email email, String password) {
        this.id = id;
        this.email = email.toString();
        this.password = password;
    }

    public String id() {
        return id;
    }

    public Email email() {
        try {
            return Email.fromString(email);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public String password() {
        return password;
    }
}
