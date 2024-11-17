package com.example.demo.model.dto.sql.level3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto_Ex9_3 {
    private String firstName;
    private String lastName;
    public CustomerDto_Ex9_3(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
