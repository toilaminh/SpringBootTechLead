package com.example.demo.model.dto.sql.level1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto_Ex5_1 {
    private String firstName;
    private String lastName;
    private String address;

    public CustomerDto_Ex5_1(String firstName, String lastName, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
}
