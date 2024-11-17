package com.example.demo.model.dto.sql.level2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto_Ex5_2 {
    private String firstName;
    private String lastName;
    private Long count; //Count use Long
    public CustomerDto_Ex5_2(String firstName, String lastName, Long count){
        this.firstName = firstName;
        this.lastName = lastName;
        this.count = count;
    }
}
