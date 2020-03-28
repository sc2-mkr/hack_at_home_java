package com.sc2.hackathome.deliveryman;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Deliveryman {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long id;

    private String email;
    private String name;
    private String surname;
    private String password;

    public Deliveryman(long id) {
        this.id = id;
    }

    public Deliveryman(long id, String username, String name, String surname, String password) {
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
