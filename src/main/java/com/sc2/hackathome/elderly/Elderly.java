package com.sc2.hackathome.elderly;

import javax.persistence.*;

@Entity
@Table(name="ELDERLY")
public class Elderly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    private String name;
    private String surname;
    private String address;

    public Elderly(long id) {
        this.id = id;
    }

    public Elderly(long id, String name, String surname, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }
}
