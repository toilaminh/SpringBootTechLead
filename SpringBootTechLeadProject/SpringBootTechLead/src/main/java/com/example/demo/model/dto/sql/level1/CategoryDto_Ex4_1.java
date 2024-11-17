package com.example.demo.model.dto.sql.level1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto_Ex4_1 {
//    private Integer id;
    private String name;
    private Double avg; //Average use Double
    public CategoryDto_Ex4_1(String name, Double avg){
//        this.id = id;
        this.name = name;
        this.avg = avg;
    }
}
