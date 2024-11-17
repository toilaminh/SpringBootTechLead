package com.example.demo.controller.core1;

import com.example.demo.service.core1.ServiceJV1_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/account/user/jv1/lvl1", "/account/admin/jv1/lvl1"})
public class Level1 {
    @Autowired
    ServiceJV1_1 serviceJV11;

    @PostMapping("/ex1")
    public double ex1(@RequestParam double a, @RequestParam double b){
        System.out.println(a+b);
        return a+b;
    }
    @PostMapping("/ex2")
    public int ex2(@RequestBody String str1){
        return str1.length();
    }

    @PostMapping("/ex3")
    public double ex3(@RequestParam double a){
        return a*a;
    }

    @PostMapping("/ex4")
    public double ex4(@RequestBody double[] arr){
        return serviceJV11.biggestNumber(arr);
    }

    @PostMapping("/ex5")
    public String ex5(@RequestBody String[] arr){
        return serviceJV11.shortestString(arr);
    }

    @PostMapping("/ex6")
    public String ex6(@RequestBody int[] arr){
        return serviceJV11.smest2bestINT(arr);
    }

    @PostMapping("/ex7")
    public String ex7(@RequestBody String[] arr){
        return serviceJV11.smest2bestSTRING(arr);
    }

    @PostMapping("/ex8")
    public Double ex8(@RequestBody double[] arr){
        return serviceJV11.medianNumber(arr);
    }

    @PostMapping("/ex9")
    public int ex9(@RequestParam String str2){
        return serviceJV11.numberOfWords(str2);
    }

    @PostMapping("/ex10")
    public int ex10(@RequestBody String[] arr){
        return serviceJV11.numberOfStrCtnA(arr);
    }
}
