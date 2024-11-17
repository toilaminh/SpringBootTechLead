package com.example.demo.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
    private Integer roleId;
    public UserDto(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
