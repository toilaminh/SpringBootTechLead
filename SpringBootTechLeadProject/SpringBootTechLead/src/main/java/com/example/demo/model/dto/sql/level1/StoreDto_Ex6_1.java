package com.example.demo.model.dto.sql.level1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreDto_Ex6_1 {
    private Integer id;
    private Double sum;
    public StoreDto_Ex6_1(Integer id, Double sum){
        this.id = id;
        this.sum = sum;
    }
}
