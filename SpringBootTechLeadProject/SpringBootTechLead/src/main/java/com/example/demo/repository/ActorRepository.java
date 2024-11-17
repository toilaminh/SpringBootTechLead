package com.example.demo.repository;

import com.example.demo.model.dto.sql.level1.ActorDto_Ex7_1;
import com.example.demo.model.dto.sql.level2.ActorDto_Ex4_2;
import com.example.demo.model.dto.sql.level2.ActorDto_Ex6_2;
import com.example.demo.model.dto.sql.level2.ActorDto_Ex7_2;
import com.example.demo.model.dto.sql.level3.ActorDto_Ex10_3;
import com.example.demo.model.dto.sql.level3.ActorDto_Ex1_3;
import com.example.demo.model.dto.sql.level3.ActorDto_Ex2_3;
import com.example.demo.model.dto.sql.level3.ActorDto_Ex6_3;
import com.example.demo.model.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer>, JpaRepository<Actor,Integer> {
    //Level1
    @Query(value = "SELECT * FROM actor a ORDER BY a.actor_id", nativeQuery = true)
    List<Actor> findAll();

    @Query("SELECT new com.example.demo.model.dto.sql.level1.ActorDto_Ex7_1(a.firstName, a.lastName)\n" +
            "FROM actor a\n" +
            "JOIN a.filmActors fa ON a.id = fa.actor.id\n" +
            "GROUP BY a.id\n" +
            "HAVING COUNT(fa.actor.id) >= 20")
    List<ActorDto_Ex7_1> findAllActorsWhoAppearedMoreThan20Films();

    //Level2
    @Query("SELECT new com.example.demo.model.dto.sql.level2.ActorDto_Ex4_2(a.firstName, a.lastName)\n" +
            "FROM actor a\n" +
            "JOIN a.filmActors fa ON fa.actor.id = a.id\n" +
            "JOIN fa.film f ON f.id = fa.film.id\n" +
            "JOIN f.filmCategories fc ON fc.film.id = f.id\n" +
            "GROUP BY a.id\n" +
            "HAVING COUNT(distinct fc.category.id) = (select count(*) from category)\n" +
            "ORDER BY a.id ASC")
    List<ActorDto_Ex4_2> findAllActorsWhoAppearedAtLeastOnceInEachCategory();

    @Query("SELECT new com.example.demo.model.dto.sql.level2.ActorDto_Ex6_2(a.firstName, a.lastName, SUM(f.rentalRate))\n" +
            "FROM actor a\n" +
            "JOIN a.filmActors fa ON fa.actor.id = a.id\n" +
            "JOIN fa.film f ON f.id = fa.film.id\n" +
            "GROUP BY a.id")
    List<ActorDto_Ex6_2> totalRevenueGeneratedByEachActor();

    @Query("SELECT new com.example.demo.model.dto.sql.level2.ActorDto_Ex7_2(a.firstName, a.lastName)\n" +
            "FROM actor a\n" +
            "JOIN a.filmActors fa ON fa.actor.id = a.id\n" +
            "JOIN fa.film f ON f.id = fa.film.id\n" +
            "WHERE f.rating = 'R' AND f.rating <> 'G'\n" +
            "GROUP BY a.id")
    List<ActorDto_Ex7_2> findActorsWhoAppearedInRButG();

    //Level3
    @Query("SELECT new com.example.demo.model.dto.sql.level3.ActorDto_Ex1_3(a.firstName, a.lastName, ctg.name, AVG(f.rentalDuration))\n" +
            "FROM actor a\n" +
            "JOIN film_actor fa ON fa.actor.id = a.id\n" +
            "JOIN film f ON f.id = fa.film.id\n" +
            "JOIN film_category fc ON fc.film.id = f.id\n" +
            "JOIN category ctg ON ctg.id = fc.category.id\n" +
            "GROUP BY a.id, ctg.id\n" +
            "having count(f.id) > 0")
    List<ActorDto_Ex1_3> avgRentalDuration();

    @Query("SELECT new com.example.demo.model.dto.sql.level3.ActorDto_Ex2_3(a.firstName, a.lastName)\n" +
            "FROM actor a\n" +
            "JOIN film_actor fa ON fa.actor.id = a.id\n" +
            "JOIN film f ON f.id = fa.film.id\n" +
            "WHERE f.rating = 'R' AND f.length > 120\n" +
            "GROUP BY a.id\n" +
            "HAVING COUNT(f.rating = 'G') = 0")
    List<ActorDto_Ex2_3> findActorsAppearedIn2HoursFilmRButG();

    @Query("SELECT new com.example.demo.model.dto.sql.level3.ActorDto_Ex6_3( a.firstName, a.lastName, COUNT(f.id))\n" +
            "FROM actor a\n" +
            "JOIN film_actor fa ON fa.actor.id = a.id\n" +
            "JOIN film f ON f.id = fa.film.id\n" +
            "WHERE f.id IN (\n" +
            "SELECT fax.film.id\n" +
            "FROM film_actor fax\n" +
            "GROUP BY fax.film.id\n" +
            "HAVING COUNT(fax.film.id) > 1\n" +
            ")\n" +
            "GROUP BY a.id")
    List<ActorDto_Ex6_3> allActorsWhoAppearedWithEveryOtherActorsAtLeastOnce();

    @Query("SELECT new com.example.demo.model.dto.sql.level3.ActorDto_Ex10_3(a.firstName, a.lastName)\n" +
            "FROM actor a\n" +
            "JOIN film_actor fa ON fa.actor.id = a.id\n" +
            "JOIN film f ON f.id = fa.film.id\n" +
            "WHERE (f.rating = 'PG-13' AND f.length > 120) OR (f.rating = 'R' AND f.length < 90)\n" +
            "GROUP BY a.id")
    List<ActorDto_Ex10_3> findActorAppearedInPG13MoreThan2AndRMoreThan1_5();
}
