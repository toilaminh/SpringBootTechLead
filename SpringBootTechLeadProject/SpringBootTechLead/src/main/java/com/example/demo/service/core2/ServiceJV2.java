package com.example.demo.service.core2;

import com.example.demo.model.dto.core2.ObjEx1_MaxMin;
import com.example.demo.model.dto.core2.ObjEx5;
import com.example.demo.model.dto.core2.ObjEx5_Res;
import com.example.demo.model.dto.core2.ObjEx8;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ServiceJV2 {
    private final HashMap<String, ObjEx8> products = new HashMap<>();

    public void addProduct(ObjEx8 product) {
        products.put(product.getId(), product);
    }

    public HashMap<String, ObjEx8> getAllProducts() {
        return products;
    }

    public ObjEx8 findInfoProductBasedOnId(String id) {
        return products.get(id);
    }

    public boolean removeProductBasedOnId(String id) {
        return products.remove(id) != null;
    }

    public boolean updateInfoProduct(ObjEx8 product) {
        if(products.containsKey(product.getId())) {
            products.put(product.getId(), product);
            return true;
        }
        return false;
    }


    public int sumArrList(ArrayList<Integer> arr){
        int sum = 0;
        for (int i : arr){
            sum += i;
        }
        return sum;
    }

    public ObjEx1_MaxMin maxminArrList(ArrayList<Integer> arr){
        ObjEx1_MaxMin target = new ObjEx1_MaxMin();
        target.setMax(arr.get(0));
        target.setMin(arr.get(0));
        for (int i : arr){
            if (target.getMax() < i){
                target.setMax(i);
            }
            if (target.getMin() > i){
                target.setMin(i);
            }
        }
        return target;
    }

    public ObjEx5_Res sumTarget(ObjEx5 obj){
        int sum = 0, ind1 = 0, ind2 = 0;
        for (int i = 0;i < obj.getObjarr().length - 1;i++){
            for (int j = i+1;j < obj.getObjarr().length;j++){
                if(obj.getObjarr()[i] + obj.getObjarr()[j] == obj.getTarget()){
                    sum = obj.getObjarr()[i] + obj.getObjarr()[j];
                    ind1 = i;
                    ind2 = j;
                    return new ObjEx5_Res(i, j);
                }
            }
        }
        return null;
    }
}
