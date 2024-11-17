package com.example.demo.service;

import com.example.demo.model.dto.LoginDto;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.AppUser;
import com.example.demo.model.entity.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;

@Service
public class AccountService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;

    public AccountService(UserRepository userRepository, AuthenticationManager authenticationManager, RoleRepository roleRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
        this.jwtService = jwtService;
    }


    public ResponseEntity<Object> profile(Authentication auth){
        var response = new HashMap<String, Object>();
        response.put("Username",auth.getName());
        response.put("Authentication",auth.getAuthorities());

        var user = userRepository.findByUsername(auth.getName());
        response.put("User",user);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Object> login(LoginDto loginDto, BindingResult result){
        if(result.hasErrors()){
            var errorList = result.getAllErrors();
            var errorMap = new HashMap<String, String>();
            for(int i = 0;i < errorList.size();i++){
                var error = (FieldError) errorList.get(i);
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMap);
        }

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUsername(),loginDto.getPassword()
                    )
            );

            AppUser user = userRepository.findByUsername(loginDto.getUsername());
            if(user == null){
                return ResponseEntity.badRequest().body("Username isn't exist!");
            }
            String jwtToken = jwtService.generateToken(user);
            var response = new HashMap<String, Object>();
            response.put("token", jwtToken);
            response.put("user", user.getUsername());
            return ResponseEntity.ok(response);

        } catch (Exception e){
            System.out.println("There is an exception : ");
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body("Wrong username or password!");
    }

    private boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public ResponseEntity<Object> register(UserDto userDto, BindingResult result){

        if(result.hasErrors()){
            var errorList = result.getAllErrors();
            var errorMap = new HashMap<String, String>();
            for(int i = 0;i < errorList.size();i++){
                var error = (FieldError) errorList.get(i);
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMap);
        }

        if(userDto.getUsername().contains(" ") || userDto.getPassword().contains(" ")){
            var errorMap = new HashMap<String, String>();
            errorMap.put("Error","Username/Password is not valid!");
            return ResponseEntity.badRequest().body(errorMap);
        }

        if(!isValid(userDto.getEmail())){
            var errorMap = new HashMap<String, String>();
            errorMap.put("Error","Email is not valid!");
            return ResponseEntity.badRequest().body(errorMap);
        }

        var bCryptEncoder = new BCryptPasswordEncoder();
        Role role = roleRepository.findById(userDto.getRoleId()).orElse(null);
        AppUser user = new AppUser();
        user.setUsername(userDto.getUsername());
        user.setPassword(bCryptEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setRole(role);

        AppUser userCheck = userRepository.findByUsername(userDto.getUsername());
        if(userCheck != null){
            return ResponseEntity.badRequest().body("Username already used!");
        }
        userRepository.save(user);

        String jwtToken = jwtService.generateToken(user);

        var response = new HashMap<String, Object>();
        response.put("token", jwtToken);
        response.put("user", user.getUsername());

        return ResponseEntity.ok(response);
    }

}
