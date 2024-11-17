package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "staff")
@Getter
@Setter
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private Integer active;
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private Set<Store> stores;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private Set<Payment> payments;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private Set<Rental> rentals;
}
