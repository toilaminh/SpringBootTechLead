package com.example.demo.controller.core3;

import com.example.demo.service.core3.ServiceJV3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/account/user/jv3", "/account/admin/jv3"})
public class CoreJava3 {
    @Autowired
    ServiceJV3 serviceJV3;

    @PostMapping("/calculator")
    public double jvcore3(@RequestBody String str){
        return serviceJV3.evaluateExpression(str);
    }
}
