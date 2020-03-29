package com.sc2.hackathome.deliveryman;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "DELIVERY_MAN")
public class Deliveryman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMAIL")
    @NotNull
    private String email;
    @Column(name = "NAME")
    @NotNull
    private String name;
    @Column(name = "SURNAME")
    @NotNull
    private String surname;

    public Deliveryman() {}

    public Deliveryman(long id) {
        this.id = id;
    }

    public Deliveryman(long id, String username, String name, String surname) {
        this.id = id;
        this.email = username;
        this.name = name;
        this.surname = surname;
    }
}
