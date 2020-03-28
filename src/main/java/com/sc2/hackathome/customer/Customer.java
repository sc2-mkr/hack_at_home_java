package com.sc2.hackathome.customer;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "address")
    @NotNull
    private String address;

    public Customer(long id) {
        this.id = id;
    }

    public Customer(long id, String name, String surname, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }
}
