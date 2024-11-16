package com.example.demo.controller.core1;

import com.example.demo.model.dto.core1.*;
import com.example.demo.service.core1.ServiceJV1_5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account/admin/jv1/lvl5")
public class Level5 {
    @Autowired
    ServiceJV1_5 serviceJV15;

    @PostMapping("/ex1")
    public String[] ex1(@RequestBody String[] str){
        return serviceJV15.reverseString(str);
    }

    @PostMapping("/ex2")
    public List<String[]> ex2(@RequestBody ObjLvl5_2 obj){
        return serviceJV15.splitString(obj.getStr_arr(), obj.getN_split());
    }

    @PostMapping("/ex3")
    public List<String> ex3(@RequestBody String[] str){
        return serviceJV15.uniq(str);
    }

    @PostMapping("/ex4")
    public List<ObjLvl5_4> ex4(@RequestBody ObjLvl5_4[] obj){
        return serviceJV15.uniq(obj);
    }

    @PostMapping("/ex5")
    public List<ObjLvl5_5Res[]> ex5(@RequestBody ObjLvl5_5 obj){
        return serviceJV15.groupBy(obj.getObjarr(), obj.getX());
    }

    @PostMapping("/ex6")
    public String ex6(@RequestBody String str){
        return serviceJV15.trimAll(str);
    }

    @PostMapping("/ex7")
    public List<Map<String,Integer>> ex7(@RequestBody ObjLvl5_7 obj){
        return serviceJV15.mapKey(obj.getObjarr(), obj.getKeyarr());
    }

    @PostMapping("/ex8")
    public ObjLvl5_8Res[] ex8(@RequestBody ObjLvl5_8 obj){
        return serviceJV15.switchOrder(obj.getObjarr(), obj.getId(), obj.getIndex());
    }

    @PostMapping("/ex9")
    public ObjLvl5_9Res ex9(@RequestBody ObjLvl5_9 obj){
        return serviceJV15.sumObj(obj.getObjarr());
    }
}
