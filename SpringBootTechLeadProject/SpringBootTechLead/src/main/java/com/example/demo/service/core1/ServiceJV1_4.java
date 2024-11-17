package com.example.demo.service.core1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceJV1_4 {
    public int bubbleSortTimes(int[] arr){
        int counter = 0;
        int n = arr.length;
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    counter += 1;
                }
            }
            if (swapped == false)
                break;
        }
        return counter;
    }

    public int totalSumINT2(int[] arr1, int a){
        int counter = 0;
        int totalSubsets = 1 << arr1.length;
        for (int subsetMask = 0; subsetMask < totalSubsets; subsetMask++) {
            int currentSum = 0;
            for (int i = 0; i < arr1.length; i++) {
                if ((subsetMask & (1 << i)) != 0) {
                    currentSum += arr1[i];
                }
            }
            if(currentSum == a){
                counter += 1;
            }
        }
        return counter;
    }

    public int longestSubstringLength(String[] arr){
        int arr_counter = 0;
        String shortest_string = arr[0];
        String sub_string = "";
        for(String test_string : arr) {
            arr_counter += 1;
            if(shortest_string.length() > test_string.length())
            {
                shortest_string = test_string;
            }
        }
        for(int i = 0;i < shortest_string.length(); i++) {
            for(int j = i; j <= shortest_string.length(); j++)
            {
                String sub_string_t = shortest_string.substring(i,j);
                int sub_counter = 0;
                for(String test_string : arr)
                {
                    int sub_index = test_string.indexOf(sub_string_t);
                    if(sub_index >= 0)
                    {
                        sub_counter += 1;
                    }

                }
                if(sub_counter == arr_counter)
                {
                    if(sub_string_t.length() > sub_string.length())
                    {
                        sub_string = sub_string_t;
                    }
                }
            }
        }
        return sub_string.length();
    }

    public int maximumProduct(int[] arr){
        List<Integer> mul = new ArrayList<>();
        int arr_large = arr.length;
        for (int i = 0; i < (1<<arr_large); i++)
        {
            List<Integer> temp = new ArrayList<>();
            int flag = 0;
            for (int j = 0; j < arr_large; j++) {
                if ((i & (1 << j)) > 0) {
                    flag += 1;
                    temp.add(arr[j]);
                }
            }
            if(flag == 3){
                int t_mul = 1;
                for (int t : temp){
                    t_mul *= t;
                }
                mul.add(t_mul);
            }
            temp.clear();
        }
        int biggest = mul.get(0);
        for(int i : mul){
            if (i > biggest){
                biggest = i;
            }
        }
        return biggest;
    }

    public String[] sortStringByLength(String[] arr){
        int arr_large = arr.length;
        for (int i = 0;i < arr_large;i++){
            for (int j = i;j < arr_large;j++){
                if (arr[i].length() < arr[j].length() && i!=j){
                    String t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
                else if(arr[i].length() == arr[j].length() && i!=j){
                    if(arr[i].compareTo(arr[j]) < 0) {
                        String t = arr[i];
                        arr[i] = arr[j];
                        arr[j] = t;
                    }
                }
            }
        }
        return arr;
    }

    public int longestIntSubsequence(int[] arr){
        int length_flag = 1;
        int longest = 1;
        for (int i = 0;i < arr.length - 1;i++){
            if(arr[i] + 1 == arr[i+1]){
                length_flag += 1;
            }
            else {
                // Reset lai bien co` do do dai cua subsequence
                if(longest < length_flag)
                {
                    longest = length_flag;
                }
                length_flag = 1;
            }
        }
        return longest;
    }

    public String searchLongestSub(String[] arr, int k){
        int arr_counter = 0;
        String shortest_string = arr[0];
        String sub_string = "";
        for(String test_string : arr)
        {
            arr_counter += 1;
            if(shortest_string.length() > test_string.length())
            {
                shortest_string = test_string;
            }
        }
        for(int i = 0;i < shortest_string.length(); i++)
        {
            for(int j = i; j <= shortest_string.length(); j++)
            {
                String sub_string_t = shortest_string.substring(i,j);
                int sub_counter = 0;
                for(String test_string : arr)
                {
                    int sub_index = test_string.indexOf(sub_string_t);
                    if(sub_index >= 0)
                    {
                        sub_counter += 1;
                    }

                }
                if(sub_counter == arr_counter && sub_counter >= k)
                {
                    if(sub_string_t.length() > sub_string.length())
                    {
                        sub_string = sub_string_t;
                    }
                }
            }
        }
        return sub_string;
    }
}
