package com.example.demo.model.dto.sql.level3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmDto_Ex5_3 {
    private String title;
    private String firstName;
    private String lastName;
    private Long count;
    public FilmDto_Ex5_3(String title,String firstName,String lastName, Long count){
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.count = count;
    }
}
