package com.example.demo.model.dto.sql.level3;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto_Ex3_3 {
    private String firstName;
    private String lastName;
    private Long count;
    private Double sum;
    public CustomerDto_Ex3_3(String firstName, String lastName, Long count, Double sum){
        this.firstName = firstName;
        this.lastName = lastName;
        this.count = count;
        this.sum = sum;
    }
}
