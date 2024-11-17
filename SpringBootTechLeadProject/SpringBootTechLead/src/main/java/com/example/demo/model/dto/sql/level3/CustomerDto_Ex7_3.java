package com.example.demo.model.dto.sql.level3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto_Ex7_3 {
    private String firstName;
    private String lastName;
    private Long count;
    public CustomerDto_Ex7_3(String firstName, String lastName, Long count){
        this.firstName = firstName;
        this.lastName = lastName;
        this.count = count;
    }
}
