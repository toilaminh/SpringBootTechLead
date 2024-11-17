package com.example.demo.controller.mysql;

import com.example.demo.model.dto.sql.level1.*;
import com.example.demo.service.sql.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account/admin/api/v1/lv1")
public class Sql1 {
    @Autowired
    ActorService actorService;
    @Autowired
    FilmService filmService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CustomerService customerService;
    @Autowired
    StoreService storeService;

    @GetMapping("/ex1")
    public List<ActorDto_Ex1_1> actorDtoList() {
        return actorService.findAllFirstNameAndLastName();
    }

    @GetMapping("/ex2")
    public List<FilmDto_Ex2_1> filmDtoList() {
        return filmService.findAllTitle();
    }

    @GetMapping("/ex3")
    public List<FilmDto_Ex3_1> top5Films() {
        return filmService.findTop5MostRentedFilms();
    }

    @GetMapping("/ex4")
    public List<CategoryDto_Ex4_1> findAvgRentalDuration() {
        return categoryService.findAvgRentalDuration();
    }

    @GetMapping("/ex5")
    public List<CustomerDto_Ex5_1> findAllCustomerWhoRentedFilmIn2022() {
        return customerService.findAllCustomerWhoRentedFilmIn2022();
    }

    @GetMapping("/ex6")
    public List<StoreDto_Ex6_1> findRevenueGeneratedByEachStore() {
        return storeService.findRevenueGeneratedByEachStore(2005);
    }

    @GetMapping("/ex7")
    public List<ActorDto_Ex7_1> findAllActorsWhoAppearedMoreThan20Films() {
        return actorService.findAllActorsWhoAppearedMoreThan20Films();
    }

    @GetMapping("/ex8")
    public List<FilmDto_Ex8_1> findAllTitleRatingPG13And120sLength(){
        return filmService.findAllTitleRatingPG13And120sLength();
    }
}
