package com.example.demo.service.core1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class ServiceJV1_3 {
    public double secondSmallest(double[] arr){
        double sec_number = 0.0F;
        for(int i = 0; i < arr.length; ++i) {
            int num_of_smaller = 0;

            for(int j = 0; j < arr.length; ++j) {
                if (arr[j] < arr[i]) {
                    ++num_of_smaller;
                }
            }

            if (num_of_smaller == 1) {
                sec_number = arr[i];
                break;
            }
        }
        return sec_number;
    }

    public int biggestDiff(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1] - arr[0];
    }

    public int lengthOfLongestINC(int[] arr){
        int counter = 1;
        int arr_large = arr.length;
        for (int i = 0; i < arr_large - 1; i++) {
            int sub_counter = 1;
            float temp = arr[i];
            for (int j = i + 1; j < arr_large; j++) {
                if (temp < arr[j]) {
                    temp = arr[j];
                    sub_counter += 1;
                }
            }
            if (sub_counter > counter) {
                counter = sub_counter;
            }
        }
        if(counter>1){
            return counter;
        }
        return 0;
    }

    public static int checkSameElements(String a, String b){
        int counter = 0;
        for(int i = 0;i < a.length();i++){
            String temp = b;
            int indx = 0;
            while(true){
                if(temp.contains(String.valueOf(a.charAt(indx)))){
                    int index = temp.indexOf(String.valueOf(a.charAt(indx)));
                    temp = temp.substring(0,index) + temp.substring(index+1);
                    counter += 1;
                }
                indx++;
                if(indx == a.length() - 1){
                    break;
                }
            }
        }
        return counter;
    }

    public String[] twoStringBestOverlap(String[] arr){
        int counter = 0;
        int ind1 = 0, ind2 = 0;
        for(int i = 0;i < arr.length - 1;i++){
            for (int j = i + 1;j < arr.length;j++){
                if(counter < checkSameElements(arr[i],arr[j])){
                    counter = checkSameElements(arr[i],arr[j]);
                    ind1 = i;
                    ind2 = j;
                }
            }
        }
        String[] res = new String[2];
        res[0] = arr[ind1];
        res[1] = arr[ind2];
        return res;
    }

    public int smallestSum(int[] arr){
        Arrays.sort(arr);
        int sum = 1;
        for(int i : arr){
            if(i > sum){
                break;
            }
            sum += i;
        }
        return sum;
    }

    public double medianNumber(List<Integer> arr1, List<Integer> arr2){
        List<Integer> arr = new ArrayList<>();
        for (int i = 0;i < arr1.size();i++){
            arr.add(arr1.get(i));
        }
        for(int i = arr1.size();i < arr1.size() + arr2.size();i++){
            arr.add(arr2.get(i - arr1.size()));
        }
        arr.sort(Integer::compareTo);
        if(arr.size() % 2 == 1){
            return (double) arr.get((arr.size() + 1)/2 - 1);
        }
        else {
            return  (double) (arr.get((arr.size() - 1)/2) + arr.get((arr.size() + 1)/2))/2;
        }
    }

    public int longestPalindrome(String str){
        String regex = "[,\\.\\s]";
        String[] word = str.split(regex);
        StringBuilder sb = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--){
            if (str.charAt(i) != ' '){
                sb.append(str.charAt(i));
            }
        }
        String rev_str = sb.toString();
        String result = "";
        for(int i = 0;i < word.length;i++){
            for(int j = i; j < word.length;j++){
                String sub_str = "";
                for (int k = i; k <= j;k++){
                    sub_str = sub_str.concat(word[k]);
                    if(rev_str.indexOf(sub_str) >= 0){
                        if(result.length() < sub_str.length()){
                            result = sub_str;
                        }
                    }
                }
            }
        }
        return result.length();
    }

    public String[] sortedStringLV3(String[] str_arr){
        Arrays.sort(str_arr, Comparator.comparing(String::length));
        int[] counter = new int[str_arr.length];
        int index = 0;
        for(String s : str_arr){
            int s_c = 1;
            for(int i = 0;i < s.length(); i++){
                for(int j = i;j < s.length(); j++){
                    if(s.charAt(i) == s.charAt(j) && j!=i){
                        s_c += 1;
                    }
                }
            }
            counter[index] = s_c;
            index += 1;
        }
        for(int i = 0;i < str_arr.length;i++){
            for (int j = i;j < str_arr.length;j++){
                if(i!=j && counter[i] > counter[j] && str_arr[i].length() == str_arr[j].length()){
                    String s_t = str_arr[i];
                    str_arr[i] = str_arr[j];
                    str_arr[j] = s_t;
                    int n_t = counter[i];
                    counter[i] = counter[j];
                    counter[j] = n_t;
                    break;
                }
            }
        }
        return str_arr;
    }
}
