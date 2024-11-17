package com.example.demo.model.dto.sql.level3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActorDto_Ex2_3 {
    private String firstName;
    private String lastName;
    public ActorDto_Ex2_3(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
