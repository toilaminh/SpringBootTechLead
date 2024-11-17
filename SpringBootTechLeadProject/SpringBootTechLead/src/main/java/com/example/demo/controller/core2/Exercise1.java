package com.example.demo.controller.core2;

import com.example.demo.model.dto.core2.ObjEx1_MaxMin;
import com.example.demo.service.core2.ServiceJV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping({"/account/user/jv2/ex1", "/account/admin/jv2/ex1"})
public class Exercise1 {
    @Autowired
    ServiceJV2 serviceJV2;

    ArrayList<Integer> globalArrList = new ArrayList<>();
    @PostMapping("/add")
    public ArrayList<Integer> ex1_add(@RequestBody ArrayList<Integer> arr){
        globalArrList.addAll(arr);
        return globalArrList;
    }

    @GetMapping("/display")
    public ArrayList<Integer> ex1_display(){
        return globalArrList;
    }

    @GetMapping("/sum")
    public int ex1_sum(){
        return serviceJV2.sumArrList(globalArrList);
    }

    @GetMapping("/maxmin")
    public ObjEx1_MaxMin ex1_maxmin(){
        return serviceJV2.maxminArrList(globalArrList);
    }

    @PostMapping("/del")
    public ArrayList<Integer> ex1_del(@RequestBody int target){
        globalArrList.remove(Integer.valueOf(target));
        return globalArrList;
    }

    @PostMapping("/existing")
    public boolean ex1_existing(@RequestBody int target){
        return globalArrList.contains(target);
    }
}
