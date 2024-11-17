package com.example.demo.model.dto.sql.level3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmDto_Ex8_3 {
    private String title;
    private Long count;
    public FilmDto_Ex8_3(String title, Long count){
        this.title = title;
        this.count = count;
    }
}
