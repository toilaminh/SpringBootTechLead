package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "film_actor")
@Getter
@Setter
public class FilmActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_actor_id")
    private Integer id;

    @Id
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
}
