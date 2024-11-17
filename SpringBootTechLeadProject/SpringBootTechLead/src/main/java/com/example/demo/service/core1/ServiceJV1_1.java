package com.example.demo.service.core1;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ServiceJV1_1 {
    public double biggestNumber(double[] arr){
        double biggest = arr[0];
        for(double i : arr){
            if(biggest < i){
                biggest = i;
            }
        }
        return biggest;
    }

    public String shortestString(String[] arr){
        String shortest = arr[0];
        for(int i = 0;i < arr.length;i++){
            if(arr[i].length() < shortest.length()){
                shortest = arr[i];
            }
        }
        return shortest;
    }

    public String smest2bestINT(int[] arr){
        Arrays.sort(arr);
        String res = "";
        for (int i : arr){
            res += i + " ";
        }
        return res;
    }

    public String smest2bestSTRING(String[] arr){
        Arrays.sort(arr);
        String res = "";
        for (String i : arr){
            res += i + " ";
        }
        return res;
    }

    public double medianNumber(double[] arr){
        if(arr.length % 2 == 1){
             return arr[(arr.length + 1)/2 - 1];
        }
        else {
            return  (arr[((arr.length - 1)/2)] + arr[(arr.length + 1)/2])/2;
        }
    }

    public int numberOfWords(String str){
        int word_num = 0;
        if(str.charAt(0) != ' ')
        {
            word_num += 1;
        }
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                if(str.charAt(i+1) != ' '){
                    word_num += 1;
                }
            }
        }
        return word_num;
    }

    public int numberOfStrCtnA(String[] str){
        int str_ca = 0;
        for(String s : str){
            if (s.contains("a")){
                str_ca += 1;
            }
        }
        return str_ca;
    }
}
