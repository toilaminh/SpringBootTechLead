package com.example.demo.model.entity;

import com.example.demo.model.entity.fenum.FilmRating;
import com.example.demo.model.entity.fenum.FilmRatingConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "film")
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Integer id;
    private String title;
    private String description;
    @Column(name = "release_year")
    private Integer releaseYear;
    @Column(name = "rental_duration")
    private Integer rentalDuration;
    @Column(name = "rental_rate")
    private Double rentalRate;
    private Integer length;
    @Column(name = "replacement_cost")
    private Double replacementCost;
    @Convert(converter = FilmRatingConverter.class)
    private FilmRating rating;
    @Column(name = "special_features")
    private String specialFeature;

    @Transient
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @Transient
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language originalLanguage;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private Set<FilmActor> filmActors;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private Set<FilmCategory> filmCategories;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private Set<Inventory> inventories;
}
