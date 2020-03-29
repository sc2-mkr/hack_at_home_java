package com.sc2.hackathome.deliveryman;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sc2.hackathome.user.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "DELIVERY_MAN")
public class Deliveryman {

    @Id
    @Column(name = "ID")
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
    @Column(name = "PASSWORD")
    @NotNull
    private String password;

    @OneToOne(targetEntity = User.class)
    @MapsId
    @JsonIgnore
    private User user;

    public Deliveryman() {}

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
}
