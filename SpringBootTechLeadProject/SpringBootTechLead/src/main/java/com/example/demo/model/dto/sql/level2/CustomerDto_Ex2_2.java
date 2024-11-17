package com.example.demo.model.dto.sql.level2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto_Ex2_2 {
    private String firstName;
    private String lastName;
    private String email;
    public CustomerDto_Ex2_2(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
