package com.example.demo.repository;

import com.example.demo.model.dto.sql.level1.CustomerDto_Ex5_1;
import com.example.demo.model.dto.sql.level2.CustomerDto_Ex1_2;
import com.example.demo.model.dto.sql.level2.CustomerDto_Ex2_2;
import com.example.demo.model.dto.sql.level2.CustomerDto_Ex5_2;
import com.example.demo.model.dto.sql.level2.CustomerDto_Ex9_2;
import com.example.demo.model.dto.sql.level3.CustomerDto_Ex3_3;
import com.example.demo.model.dto.sql.level3.CustomerDto_Ex4_3;
import com.example.demo.model.dto.sql.level3.CustomerDto_Ex7_3;
import com.example.demo.model.dto.sql.level3.CustomerDto_Ex9_3;
import com.example.demo.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //Level1
    @Query("SELECT new com.example.demo.model.dto.sql.level1.CustomerDto_Ex5_1( c.firstName, c.lastName, a.address)\n" +
            "FROM customer c\n" +
            "JOIN c.address a ON a.id = c.address.id\n" +
            "JOIN c.rentals r ON r.customer.id = c.id\n" +
            "WHERE r.rentalDate >= :startDate AND r.rentalDate <= :endDate\n" +
            "GROUP BY c.id")
    List<CustomerDto_Ex5_1> findAllCustomerWhoRentedFilmIn2022(@Param("startDate") LocalDate start, @Param("endDate") LocalDate end);

    //Level2
    @Query("SELECT new com.example.demo.model.dto.sql.level2.CustomerDto_Ex1_2(c.firstName, c.lastName, SUM(p.amount))\n" +
            "FROM customer c\n" +
            "JOIN c.payments p ON c.id = p.customer.id\n" +
            "GROUP BY c.id\n" +
            "ORDER BY SUM(p.amount) DESC\n" +
            "LIMIT 10")
    List<CustomerDto_Ex1_2> find10CustomerWhoSpentMostMoney();

    @Query("SELECT new com.example.demo.model.dto.sql.level2.CustomerDto_Ex2_2(c.firstName, c.lastName, c.email)\n" +
            "FROM customer c\n" +
            "JOIN c.rentals r ON r.customer.id = c.id\n" +
            "JOIN r.inventory i ON i.id = r.inventory.id\n" +
            "JOIN film_category fc ON fc.film.id = i.film.id\n" +
            "GROUP BY c.id\n" +
            "HAVING COUNT(distinct fc.category.id) = 16\n" +
            "ORDER BY c.id ASC")
    List<CustomerDto_Ex2_2> findCustomerRentedAllCategories();

    @Query("SELECT new com.example.demo.model.dto.sql.level2.CustomerDto_Ex5_2(c.firstName, c.lastName, COUNT(f.id))\n" +
            "FROM customer c\n" +
            "JOIN c.rentals r ON r.customer.id = c.id\n" +
            "JOIN r.inventory i ON i.id = r.inventory.id\n" +
            "JOIN film_category fc ON fc.film.id = i.film.id\n" +
            "JOIN fc.film f ON f.id = fc.film.id\n" +
            "GROUP BY c.id\n" +
            "HAVING COUNT(f.id) > 1\n" +
            "ORDER BY c.id")
    List<CustomerDto_Ex5_2> findCustomersRentedSameFilmMoreThanOnce();

    @Query("SELECT new com.example.demo.model.dto.sql.level2.CustomerDto_Ex9_2( c.firstName, c.lastName)\n" +
            "FROM customer c\n" +
            "JOIN rental r ON r.customer.id = c.id\n" +
            "JOIN inventory i ON i.id = r.inventory.id\n" +
            "JOIN film f ON f.id = i.film.id\n" +
            "join film_category fc on fc.film.id = f.id\n" +
            "join category ctg on ctg.id = fc.category.id\n" +
            "WHERE not exists (\n" +
            "select 1\n" +
            "from rental r1\n" +
            "join customer c1 on c1.id = r1.customer.id\n" +
            "JOIN inventory i1 ON i1.id = r1.inventory.id\n" +
            "join film f1 on f1.id = i1.film.id\n" +
            "join film_category fc1 on fc1.film.id = f1.id\n" +
            "where c1.id = c.id and fc1.category.id = fc.category.id and r1.returnDate < r.returnDate)\n" +
            "GROUP BY c.id")
    List<CustomerDto_Ex9_2> findCustomersRentedFilmFromCategoryThatNeverRentedBefore();

    //Level3
    @Query("SELECT new com.example.demo.model.dto.sql.level3.CustomerDto_Ex3_3(c.firstName, c.lastName, COUNT(f.id), SUM(p.amount))\n" +
            "FROM customer c\n" +
            "JOIN rental r ON r.customer.id = c.id\n" +
            "JOIN inventory i ON i.id = r.inventory.id\n" +
            "JOIN film f ON f.id = i.film.id\n" +
            "JOIN payment p ON r.id = p.rental.id\n" +
            "GROUP BY c.id\n" +
            "HAVING COUNT(f.id) > 10")
    List<CustomerDto_Ex3_3> findAllCustomersRentedMoreThan10Films();

    @Query("SELECT new com.example.demo.model.dto.sql.level3.CustomerDto_Ex4_3(c.firstName, c.lastName, COUNT(f.id), SUM(p.amount))\n" +
            "FROM customer c\n" +
            "JOIN rental r ON r.customer.id = c.id\n" +
            "JOIN inventory i ON i.id = r.inventory.id\n" +
            "JOIN film f ON f.id = i.film.id\n" +
            "JOIN film_category fc ON fc.film.id = f.id\n" +
            "JOIN category ctg ON ctg.id = fc.category.id\n" +
            "JOIN payment p ON r.id = p.rental.id\n" +
            "GROUP BY c.id\n" +
            "HAVING COUNT(distinct fc.category.id) = (\n" +
            "SELECT COUNT(ctgx.id)\n" +
            "FROM category ctgx)")
    List<CustomerDto_Ex4_3> allCustomersRentedAllFilmsFromOneCategory();

    @Query("SELECT new com.example.demo.model.dto.sql.level3.CustomerDto_Ex7_3(c.firstName, c.lastName, COUNT(DISTINCT f.id))\n" +
            "FROM customer c\n" +
            "JOIN rental r ON r.customer.id = c.id\n" +
            "JOIN inventory i ON i.id = r.inventory.id\n" +
            "JOIN film f ON f.id = i.film.id\n" +
            "JOIN film_category fc ON fc.film.id = f.id\n" +
            "JOIN category ctg ON ctg.id = fc.category.id\n" +
            "GROUP BY c.id,ctg.id\n" +
            "HAVING COUNT(DISTINCT ctg.id) = (select count(*) from category)")
    List<CustomerDto_Ex7_3> findAllCustomerRentedAtLeastOnceFilmFromEveryCategory();

    @Query("SELECT new com.example.demo.model.dto.sql.level3.CustomerDto_Ex9_3(c.firstName, c.lastName)\n" +
            "FROM customer c\n" +
            "JOIN rental r ON r.customer.id = c.id\n" +
            "JOIN inventory i ON i.id = r.inventory.id\n" +
            "JOIN film f ON f.id = i.film.id\n" +
            "JOIN film_category fc ON fc.film.id = f.id\n" +
            "JOIN category ctg ON ctg.id = fc.category.id\n" +
            "WHERE f.length <= 180 AND NOT EXISTS (\n" +
            "SELECT 1\n" +
            "FROM rental rx\n" +
            "JOIN inventory ix ON ix.id = rx.inventory.id\n" +
            "JOIN film fx ON fx.id = ix.film.id\n" +
            "JOIN film_category fcx ON fcx.film.id = fx.id\n" +
            "JOIN category cx ON cx.id = fcx.category.id\n" +
            "WHERE rx.customer.id = customer.id AND fcx.category.id = fc.category.id AND rx.rentalDate < r.rentalDate\n" +
            ")\n" +
            "GROUP BY c.id")
    List<CustomerDto_Ex9_3> findCustomersRentedFilmFromCategoryThatNeverRentedBeforeAndNeverRentedAFilmLonger3Hours();

    //Level4
    @Query(value = "select c.*\n" +
            "\tfrom customer c\n" +
            "\tjoin rental r on r.customer_id = c.customer_id\n" +
            "\tjoin inventory i on i.inventory_id = r.inventory_id\n" +
            "\tjoin film f on f.film_id = i.film_id\n" +
            "\tjoin film_category fc on fc.film_id = f.film_id\n" +
            "\tjoin category cg on cg.category_id = fc.category_id\n" +
            "\twhere year(r.rental_date) = 2022 and month(r.rental_date) = 10 and cg.name='Horror'\n", nativeQuery = true)
    List<Customer> listCustomersUpdate4();


}
