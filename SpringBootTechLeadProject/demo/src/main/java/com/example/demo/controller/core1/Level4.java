package com.example.demo.controller.core1;


import com.example.demo.model.dto.core1.ObjLvl4_10;
import com.example.demo.model.dto.core1.ObjLvl4_10Res;
import com.example.demo.model.dto.core1.ObjLvl4_2;
import com.example.demo.service.core1.ServiceJV1_4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/admin/jv1/lvl4")
public class Level4 {
    @Autowired
    ServiceJV1_4 serviceJV14;

    @PostMapping("/ex1")
    public int ex1(@RequestBody int[] arr){
        return serviceJV14.bubbleSortTimes(arr);
    }

    @PostMapping("/ex2")
    public int ex2(@RequestBody ObjLvl4_2 objLvl4_2){
        return serviceJV14.totalSumINT2(objLvl4_2.getArray(), objLvl4_2.getTarget());
    }

    @PostMapping("/ex3")
    public int ex3(@RequestBody String[] arr){
        return serviceJV14.longestSubstringLength(arr);
    }

    @PostMapping("/ex6")
    public int ex6(@RequestBody int[] arr){
        return serviceJV14.maximumProduct(arr);
    }

    @PostMapping("/ex7")
    public String[] ex7(@RequestBody String[] arr){
        return serviceJV14.sortStringByLength(arr);
    }

    @PostMapping("/ex9")
    public int ex9(@RequestBody int[] arr){
        return serviceJV14.longestIntSubsequence(arr);
    }

    @PostMapping("/ex10")
    public ObjLvl4_10Res ex10(@RequestBody ObjLvl4_10 objLvl4_10){
        ObjLvl4_10Res res = new ObjLvl4_10Res();
        res.setStr(serviceJV14.searchLongestSub(objLvl4_10.getStr_arr(), objLvl4_10.getStr_length()));
        res.setLength(res.getStr().length());
        return res;
    }
}
