package com.example.demo.controller.core2;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping({"/account/user/jv2/ex2", "/account/admin/jv2/ex2"})
public class Exercise2 {

    HashSet<String> nation = new HashSet<>();
    @PostMapping("/add")
    public HashSet<String> ex2_add(@RequestBody String[] str){
        for(String s : str){
            nation.add(s);
        }
        return nation;
    }

    @GetMapping("/display")
    public HashSet<String> ex2_display(){
        return nation;
    }

    @PostMapping("/existing")
    public boolean ex2_existing(@RequestBody String str){
        return nation.contains(str);
    }

    @PostMapping("/del")
    public HashSet<String> ex2_del(@RequestBody String str){
        nation.remove(str);
        return nation;
    }

    @GetMapping("/size")
    public int ex2_size(){
        return nation.size();
    }
}
