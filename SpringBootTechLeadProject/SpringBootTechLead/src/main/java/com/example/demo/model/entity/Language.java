package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "language")
@Getter
@Setter
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Integer id;
    private String name;

    @Transient
    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
    private Set<Film> film1;

    @Transient
    @OneToMany(mappedBy = "originalLanguage", cascade = CascadeType.ALL)
    private Set<Film> film2;
}
