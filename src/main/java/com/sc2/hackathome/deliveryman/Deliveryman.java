package com.sc2.hackathome.deliveryman;
import javax.persistence.*;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "DELIVERY_MAN")
public class Deliveryman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="EMAIL",unique = true)
    @NotNull
    private String email;
    @Column(name="NAME")
    @NotNull
    private String name;
    @Column(name="SURNAME")
    @NotNull
    private String surname;
    @Column(name="PASSWORD")
    @NotNull
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
