package com.example.demo.controller.core1;

import com.example.demo.service.core1.ServiceJV1_3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping({"/account/user/jv1/lvl3", "/account/admin/jv1/lvl3"})
public class Level3 {
    @Autowired
    ServiceJV1_3 serviceJV13;

    @PostMapping("/ex1")
    public double ex1(@RequestBody double[] arr){
        return serviceJV13.secondSmallest(arr);
    }

    @PostMapping("/ex2")
    public int ex2(@RequestBody int[] arr){
        return serviceJV13.biggestDiff(arr);
    }

    @PostMapping("/ex3")
    public int ex3(@RequestBody int[] arr){
        return serviceJV13.lengthOfLongestINC(arr);
    }

    @PostMapping("/ex4")
    public String[] ex4(@RequestBody String[] arr){
        return serviceJV13.twoStringBestOverlap(arr);
    }

    @PostMapping("/ex5")
    public int ex5(@RequestBody int[] arr){
        return serviceJV13.smallestSum(arr);
    }

    @PostMapping("/ex6")
    public double ex6(@RequestBody List<List<Integer>> arrays){
        List<Integer> arr1 = arrays.get(0);
        List<Integer> arr2 = arrays.get(1);
        int[] arr = new int[arr1.size() + arr2.size()];
        for (int i = 0;i < arr1.size();i++){
            arr[i] = arr1.get(i);
        }
        for(int i = arr1.size();i < arr1.size() + arr2.size();i++){
            arr[i] = arr2.get(i - arr1.size());
        }
        Arrays.sort(arr);
        System.out.println(arr1 + " " + arr2 + " " + arr);
        return serviceJV13.medianNumber(arr1, arr2);
    }

    @PostMapping("/ex7")
    public int ex7(@RequestParam String str){
        return serviceJV13.longestPalindrome(str);
    }

    @PostMapping("/ex10")
    public String[] ex10(@RequestBody String[] str){
        return serviceJV13.sortedStringLV3(str);
    }
}

