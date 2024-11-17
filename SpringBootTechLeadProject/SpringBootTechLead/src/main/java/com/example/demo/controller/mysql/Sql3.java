package com.example.demo.controller.mysql;

import com.example.demo.model.dto.sql.level3.*;
import com.example.demo.service.sql.ActorService;
import com.example.demo.service.sql.CustomerService;
import com.example.demo.service.sql.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account/admin/api/v1/lv3")
public class Sql3 {
    @Autowired
    ActorService actorService;
    @Autowired
    CustomerService customerService;
    @Autowired
    FilmService filmService;

    @GetMapping("/ex1")
    public List<ActorDto_Ex1_3> avgRentalDuration(){
        return actorService.avgRentalDuration();
    }

    @GetMapping("/ex2")
    public List<ActorDto_Ex2_3> findActorsAppearedIn2HoursFilmRButG(){
        return actorService.findActorsAppearedIn2HoursFilmRButG();
    }

    @GetMapping("/ex3")
    public List<CustomerDto_Ex3_3> findAllCustomersRentedMoreThan10Films(){
        return customerService.findAllCustomersRentedMoreThan10Films();
    }

    @GetMapping("/ex4")
    public List<CustomerDto_Ex4_3> allCustomersRentedAllFilmsFromOneCategory(){
        return customerService.allCustomersRentedAllFilmsFromOneCategory();
    }

    @GetMapping("/ex5")
    public List<FilmDto_Ex5_3> allFilmsWereRentedByOneCustomerMoreThanOnceInSingleDay(){
        return filmService.allFilmsWasRentedByOneCustomerMoreThanOnceInSingleDay();
    }

    @GetMapping("/ex6")
    public List<ActorDto_Ex6_3> allActorsWhoAppearedWithEveryOtherActorsAtLeastOnce(){
        return actorService.allActorsWhoAppearedWithEveryOtherActorsAtLeastOnce();
    }

    @GetMapping("/ex7")
    public List<CustomerDto_Ex7_3> findAllCustomerRentedAtLeastOnceFilmFromEveryCategory(){
        return customerService.findAllCustomerRentedAtLeastOnceFilmFromEveryCategory();
    }

    @GetMapping("/ex8")
    public List<FilmDto_Ex8_3> findAllFilmsWereRentedMoreThan100TimesButNotByCustomersWhoRentedAnyFilmG(){
        return filmService.findAllFilmsWereRentedMoreThan100TimesButNotByCustomersWhoRentedAnyFilmG();
    }

    @GetMapping("/ex9")
    public List<CustomerDto_Ex9_3> findCustomersRentedFilmFromCategoryThatNeverRentedBeforeAndNeverRentedAFilmLonger3Hours(){
        return customerService.findCustomersRentedFilmFromCategoryThatNeverRentedBeforeAndNeverRentedAFilmLonger3Hours();
    }

    @GetMapping("/ex10")
    public List<ActorDto_Ex10_3> findActorAppearedInPG13MoreThan2AndRMoreThan1_5(){
        return actorService.findActorAppearedInPG13MoreThan2AndRMoreThan1_5();
    }
}
