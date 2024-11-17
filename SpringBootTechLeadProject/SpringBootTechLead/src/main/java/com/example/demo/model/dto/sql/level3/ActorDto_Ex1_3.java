package com.example.demo.model.dto.sql.level3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActorDto_Ex1_3 {
    private String firstName;
    private String lastName;
    private String categoryName;
    private Double avg;
    public ActorDto_Ex1_3(String firstName, String lastName, String categoryName, Double avg){
        this.firstName = firstName;
        this.lastName = lastName;
        this.categoryName = categoryName;
        this.avg = avg;
    }
}
