package com.example.demo.model.dto.sql.level1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmDto_Ex3_1 {
    private Integer id;
    private String title;
    private Long total;
    public FilmDto_Ex3_1(Integer id, String title, Long total) {
        this.id = id;
        this.title = title;
        this.total = total;
    }
}