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

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "ADDRESS")
    @NotNull
    private String address;

    @Column(name = "PHONE_NUMBER")
    @NotNull
    private String phoneNumber;

    @Column(name = "CITY")
    @NotNull
    private String city;
}