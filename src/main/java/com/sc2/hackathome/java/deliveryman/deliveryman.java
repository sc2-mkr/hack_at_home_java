package com.sc2.hackathome.java.deliveryman;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class deliveryman {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long id;

    private String email;
    private String name;
    private String surname;
    private String password;

    public deliveryman(long id) {
        this.id = id;
    }

    public deliveryman(long id, String username, String name, String surname, String password) {
        this.id = id;
        this.email = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }
}
