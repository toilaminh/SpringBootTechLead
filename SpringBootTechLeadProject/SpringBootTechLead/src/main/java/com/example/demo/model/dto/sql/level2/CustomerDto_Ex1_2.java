package com.example.demo.model.dto.sql.level2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto_Ex1_2 {
    private String firstName;
    private String lastName;
    private Double sum; //Sum use Double
    public CustomerDto_Ex1_2(String firstName, String lastName, Double sum){
        this.firstName = firstName;
        this.lastName = lastName;
        this.sum = sum;
    }
}
