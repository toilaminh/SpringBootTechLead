package com.example.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {
    private String name;
    private Integer userId;
    public RoleDto(String name, Integer userId){
        this.name = name;
        this.userId = userId;
    }
}
