package com.example.demo.controller;

import com.example.demo.model.dto.LoginDto;
import com.example.demo.model.dto.UserDto;
import com.example.demo.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody UserDto userDto, BindingResult result){
        return accountService.register(userDto, result);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDto loginDto, BindingResult result){
        return accountService.login(loginDto,result);
    }

    @GetMapping("/profile")
    public ResponseEntity<Object> profile(Authentication authentication){
        return accountService.profile(authentication);
    }

    @GetMapping("/admin")
    public String admin(){
        return "Admin";
    }

    @GetMapping("/user/")
    public String user(){
        return "User";
    }
}