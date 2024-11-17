package com.example.demo.controller.mysql;

import com.example.demo.model.dto.sql.level2.*;
import com.example.demo.service.sql.ActorService;
import com.example.demo.service.sql.CustomerService;
import com.example.demo.service.sql.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account/admin/api/v1/lv2")
public class Sql2 {
    @Autowired
    ActorService actorService;
    @Autowired
    CustomerService customerService;
    @Autowired
    FilmService filmService;

    @GetMapping("/ex1")
    public List<CustomerDto_Ex1_2> find10CustomerWhoSpentMostMoney(){
        return customerService.find10CustomerWhoSpentMostMoney();
    }

    @GetMapping("/ex2")
    public List<CustomerDto_Ex2_2> findCustomerRentedAllCategories(){
        return customerService.findCustomerRentedAllCategories();
    }

    @GetMapping("/ex3")
    public List<FilmDto_Ex3_2> findFilmTitleWhichRentedButNeverReturned(){
        return filmService.findFilmTitleWhichRentedButNeverReturned();
    }

    @GetMapping("/ex4")
    public List<ActorDto_Ex4_2> findAllActorsWhoAppearedAtLeastOnceInEachCategory(){
        return actorService.findAllActorsWhoAppearedAtLeastOnceInEachCategory();
    }

    @GetMapping("/ex5")
    public List<CustomerDto_Ex5_2> findCustomersRentedSameFilmMoreThanOnce(){
        return customerService.findCustomersRentedSameFilmMoreThanOnce();
    }

    @GetMapping("/ex6")
    public List<ActorDto_Ex6_2> totalRevenueGeneratedByEachActor(){
        return actorService.totalRevenueGeneratedByEachActor();
    }

    @GetMapping("/ex7")
    public List<ActorDto_Ex7_2> findActorsWhoAppearedInRButG(){
        return actorService.findActorsWhoAppearedInRButG();
    }

    @GetMapping("/ex8")
    public List<FilmDto_Ex8_2> findAllFilmsWhichRentedMoreThan50() {
        return filmService.findAllFilmsWhichRentedMoreThan50();
    }

    @GetMapping("/ex9")
    public List<CustomerDto_Ex9_2> findCustomersRentedFilmFromCategoryThatNeverRentedBefore(){
        return customerService.findCustomersRentedFilmFromCategoryThatNeverRentedBefore();
    }

    @GetMapping("/ex10")
    public List<FilmDto_Ex10_2> findAllFilmRentedByAllCustomersButAction(){
        return filmService.findAllFilmRentedByAllCustomersButAction();
    }
 }
