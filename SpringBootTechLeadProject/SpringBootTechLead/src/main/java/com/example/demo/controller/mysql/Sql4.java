package com.example.demo.controller.mysql;

import com.example.demo.service.sql.AddressService;
import com.example.demo.service.sql.CustomerService;
import com.example.demo.service.sql.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/admin/api/v1/lv4")
public class Sql4 {
    @Autowired
    FilmService filmService;
    @Autowired
    CustomerService customerService;
    @Autowired
    AddressService addressService;

    @PutMapping("/ex1")
    public String updateRentalRateAllFilmsWereRentedMoreThan100sTo110(){
        try {
            filmService.updateRentalRateAllFilmsWereRentedMoreThan100sTo110();
            return "UPDATED";
        }
        catch (Exception e){
            return "ERROR :\n" + e.getMessage();
        }
    }

    @PutMapping("/ex2")
    public String updateRentalDurationAllFilmsWereRentedMoreThan5sTo105(){
        try {
            filmService.updateRentalDurationAllFilmsWereRentedMoreThan5sTo105();
            return "UPDATED";
        }
        catch (Exception e){
            return "ERROR :\n" + e.getMessage();
        }
    }

    @PutMapping("/ex3")
    private String updateRateAllFilmsWereReleasedBefore2005(){
        try {
            filmService.updateRateAllFilmsWereReleasedBefore2005();
            return "UPDATED";
        }
        catch (Exception e){
            return "ERROR :\n" + e.getMessage();
        }
    }

    @PutMapping("/ex4")
    private String updateEmailOfAllCustomersHorror102002(){
        try {
            customerService.updateEmailOfAllCustomersHorror102002();
            return "UPDATED";
        }
        catch (Exception e){
            return "ERROR :\n" + e.getMessage();
        }
    }

    @PutMapping("/ex5")
    private String updateRentelRateAllFilmsWereRentedMoreThan10s(){
        try {
            filmService.updateRentelRateAllFilmsWereRentedMoreThan10s();
            return "UPDATED";
        }
        catch (Exception e){
            return "ERROR :\n" + e.getMessage();
        }
    }

    @PutMapping("/ex6")
    private String updateRentalRateAllFilmsWhichHadRatingPG13AndLength120s(){
        try {
            filmService.updateRentalRateAllFilmsWhichHadRatingPG13AndLength120s();
            return "UPDATED";
        }
        catch (Exception e){
            return "ERROR :\n" + e.getMessage();
        }
    }

    @PutMapping("/ex7")
    private String updateRentalDurationEqualLength(){
        try {
            filmService.updateRentalDurationEqualLength();
            return "UPDATED";
        }
        catch (Exception e){
            return "ERROR :\n" + e.getMessage();
        }
    }

    @PutMapping("/ex8")
    private String updateNewAddressName(){
        try {
            addressService.updateNewAddressName();
            return "UPDATED";
        }
        catch (Exception e){
            return "ERROR :\n" + e.getMessage();
        }
    }

    @PutMapping("/ex9")
    private String updateRentalRate2007sComedy(){
        try {
            filmService.updateRentalRate2007sComedy();
            return "UPDATED";
        }
        catch (Exception e){
            return "ERROR :\n" + e.getMessage();
        }
    }

    @PutMapping("/ex10")
    private String updateRentalRateEqualLengths60G(){
        try {
            filmService.updateRentalRateEqualLengths60G();
            return "UPDATED";
        }
        catch (Exception e){
            return "ERROR :\n" + e.getMessage();
        }
    }
}
