package com.example.demo.repository;

import com.example.demo.model.dto.sql.level1.FilmDto_Ex3_1;
import com.example.demo.model.dto.sql.level1.FilmDto_Ex8_1;
import com.example.demo.model.dto.sql.level2.FilmDto_Ex10_2;
import com.example.demo.model.dto.sql.level2.FilmDto_Ex3_2;
import com.example.demo.model.dto.sql.level2.FilmDto_Ex8_2;
import com.example.demo.model.dto.sql.level3.FilmDto_Ex5_3;
import com.example.demo.model.dto.sql.level3.FilmDto_Ex8_3;
import com.example.demo.model.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer>, JpaRepository<Film, Integer> {
    //Level1
    @Query(value = "SELECT * FROM film f ORDER BY f.film_id", nativeQuery = true)
    List<Film> findAllTitle();

    @Query("SELECT new com.example.demo.model.dto.sql.level1.FilmDto_Ex3_1( f.id, f.title, COUNT(r.inventory.id))\n" +
            "FROM film f\n" +
            "JOIN f.inventories i ON f.id = i.film.id\n" +
            "JOIN i.rentals r ON r.inventory.id = i.id\n" +
            "GROUP BY f.id\n" +
            "ORDER BY COUNT(r.inventory.id) DESC")
    List<FilmDto_Ex3_1> findTop5MostRentedFilms();

    @Query("SELECT new com.example.demo.model.dto.sql.level1.FilmDto_Ex8_1(f.title)\n" +
            "FROM film f\n" +
            "WHERE f.rating = 'PG-13' AND f.length >= 120\n" +
            "ORDER BY f.id ASC")
    List<FilmDto_Ex8_1> findAllTitleRatingPG13And120sLength();

    //Level2
    @Query("SELECT new com.example.demo.model.dto.sql.level2.FilmDto_Ex3_2( f.title)\n" +
            "FROM film f\n" +
            "JOIN f.inventories i ON i.film.id = f.id\n" +
            "JOIN i.rentals r ON r.inventory.id = i.id\n" +
            "WHERE r.returnDate IS NULL AND r.rentalDate IS NOT NULL\n" +
            "ORDER BY film.id ASC")
    List<FilmDto_Ex3_2> findFilmTitleWhichRentedButNeverReturned();

    @Query("SELECT new com.example.demo.model.dto.sql.level2.FilmDto_Ex8_2(f.title)\n" +
            "FROM film f\n" +
            "JOIN inventory i ON i.film.id = f.id\n" +
            "JOIN rental r ON r.inventory.id = i.id\n" +
            "JOIN customer c ON c.id = r.customer.id\n" +
            "GROUP BY f.id\n" +
            "HAVING COUNT(DISTINCT r.customer.id) > 25")
    List<FilmDto_Ex8_2> findAllFilmsWhichRentedMoreThan50();

    @Query("SELECT new com.example.demo.model.dto.sql.level2.FilmDto_Ex10_2( f.title)\n" +
            "FROM film f\n" +
            "JOIN film_category fc ON fc.film.id = f.id\n" +
            "JOIN category ctg ON ctg.id = fc.category.id\n" +
            "JOIN inventory i ON i.film.id = f.id\n" +
            "JOIN rental r ON r.inventory.id = i.id\n" +
            "JOIN customer c ON c.id = r.customer.id\n" +
            "WHERE ctg.name <> 'Action'\n" +
            "GROUP BY f.id\n" +
            "HAVING COUNT(DISTINCT r.customer.id) = COUNT(c.id)")
    List<FilmDto_Ex10_2> findAllFilmRentedByAllCustomersButAction();

    //Level3
    @Query("SELECT new com.example.demo.model.dto.sql.level3.FilmDto_Ex5_3(f.title, c.firstName, c.lastName, COUNT(f.id))\n" +
            "FROM film f\n" +
            "JOIN inventory i ON f.id = i.film.id\n" +
            "JOIN rental r ON r.inventory.id = i.id\n" +
            "JOIN customer c ON c.id = r.customer.id\n" +
            "GROUP BY c.id, f.id, r.rentalDate\n" +
            "HAVING COUNT(DATE(r.rentalDate)) > 1")
    List<FilmDto_Ex5_3> allFilmsWasRentedByOneCustomerMoreThanOnceInSingleDay();

    @Query("SELECT new com.example.demo.model.dto.sql.level3.FilmDto_Ex8_3(f.title, COUNT(f.id))\n" +
            "FROM film f\n" +
            "JOIN inventory i ON i.film.id = f.id\n" +
            "JOIN rental r ON r.inventory.id = i.id\n" +
            "GROUP BY f.id\n" +
            "HAVING COUNT(f.id) > 100")
    List<FilmDto_Ex8_3> findAllFilmsWereRentedMoreThan100TimesButNotByCustomersWhoRentedAnyFilmG();

    //Level4
    @Query(value = "select film.*\n" +
            "    from film\n" +
            "\tJOIN inventory ON inventory.film_id = film.film_id\n" +
            "\tJOIN rental ON rental.inventory_id = inventory.inventory_id\n" +
            "\tGROUP BY film.film_id\n" +
            "\tHAVING COUNT(film.film_id) > 10;", nativeQuery = true)
    List<Film> listFilmsUpdate1();

    @Query(value = "select film.*\n" +
            "    from film\n" +
            "\tJOIN inventory ON inventory.film_id = film.film_id\n" +
            "\tJOIN rental ON rental.inventory_id = inventory.inventory_id\n" +
            "\tGROUP BY film.film_id\n" +
            "\tHAVING COUNT(film.film_id) > 5;", nativeQuery = true)
    List<Film> listFilmsUpdate2();

    @Query(value = "select film.*\n" +
            "    from film\n" +
            "\tJOIN film_category ON film_category.film_id = film.film_id\n" +
            "\tJOIN category ON category.category_id = film_category.category_id\n" +
            "    where film.release_year < 2005 and category.name = 'Action'\n" +
            "\tGROUP BY film.film_id", nativeQuery = true)
    List<Film> listFilmsUpdate3();

    @Query(value = "select f.*\n" +
            "\tfrom film f\n" +
            "\tjoin inventory i on i.film_id = f.film_id\n" +
            "\tjoin rental r on r.inventory_id = i.inventory_id\n" +
            "\twhere f.rental_rate <= 3.8\n" +
            "\tgroup by f.film_id\n" +
            "\thaving count(f.film_id) > 10", nativeQuery = true)
    List<Film> listFilmsUpdate5();

    @Query(value = "select * from film where film.rating='PG-13' and film.length>120", nativeQuery = true)
    List<Film> listFilmsUpdate6();

    @Query(value = "select f.*\n" +
            "\tfrom film f\n" +
            "    join film_category fc on fc.film_id = f.film_id\n" +
            "\tjoin category c on c.category_id = fc.category_id\n" +
            "    where c.name='Sci-Fi' and f.release_year = 2010", nativeQuery = true)
    List<Film> listFilmsUpdate7();

    @Query(value = "select f.*\n" +
            "    from film f\n" +
            "    join film_category fc on fc.film_id = f.film_id\n" +
            "    join category c on c.category_id = fc.category_id\n" +
            "    where c.name = 'Comedy' and f.release_year >= 2007", nativeQuery = true)
    List<Film> listFilmsUpdate9();

    @Query(value = "select * from film where length < 60 and rating = 'G'", nativeQuery = true)
    List<Film> listFilmsUpdate10();
}
