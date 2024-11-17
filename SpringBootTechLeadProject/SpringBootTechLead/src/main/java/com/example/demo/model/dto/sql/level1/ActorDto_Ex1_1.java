package com.example.demo.model.dto.sql.level1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActorDto_Ex1_1 {
//    private Integer id;
    private String firstName;
    private String lastName;
    public ActorDto_Ex1_1(String fn, String ln){
//        this.id = id;
        this.firstName = fn;
        this.lastName = ln;
    }
}
