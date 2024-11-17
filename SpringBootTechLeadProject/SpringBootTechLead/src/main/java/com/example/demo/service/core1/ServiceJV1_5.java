package com.example.demo.service.core1;

import com.example.demo.model.dto.core1.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceJV1_5 {
    public String[] reverseString(String[] arr){
        String[] result = new String[arr.length];
        int reverse_index = arr.length - 1;
        for(String i : arr){
            result[reverse_index] = i;
            reverse_index -= 1;
        }
        return result;
    }

    public List<String[]> splitString(String[] arr, int n_split){
        List<String[]> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int flag = 0;
        for (int i = 0;i < arr.length;i++){
            if(flag < n_split){
                temp.add(arr[i]);
                flag += 1;
            }
            else{
                String[] t = temp.toArray(new String[0]);
                result.add(t);
                temp.clear();
                temp.add(arr[i]);
                flag = 1;
            }
        }
        if(!temp.isEmpty()){
            String[] t = temp.toArray(new String[0]);
            result.add(t);
        }
        return result;
    }

    public List<String> uniq(String[] arr){
        List<String> result = new ArrayList<>();
        for(int i = 0;i < arr.length;i++){
            boolean flag = false;
            for (String str : result){
                if(str.equals(arr[i])){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                result.add(arr[i]);
            }
        }
        return result;
    }

    public List<ObjLvl5_4> uniq(ObjLvl5_4[] arr){
        List<ObjLvl5_4> result = new ArrayList<>();
        for(int i = 0;i < arr.length;i++){
            boolean flag = false;
            for (ObjLvl5_4 object : result){
                if(object.getX() == arr[i].getX() && object.getY() == arr[i].getY()){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                result.add(arr[i]);
            }
        }
        return result;
    }

    public List<ObjLvl5_5Res[]> groupBy(ObjLvl5_5Res[] arr, char c){
        List<ObjLvl5_5Res> arrX = new ArrayList<>();
        Collections.addAll(arrX,arr);
        List<ObjLvl5_5Res[]> result = new ArrayList<>();
        List<ObjLvl5_5Res> temp = new ArrayList<>();
        for(int i = 0;i < arrX.size();i++){
            //Luc dau clear temp va them phan tu dau
            temp.clear();
            temp.add(arrX.get(i));
            if(c == 'a'){
                for(int j = i; j < arrX.size(); j++){
                    // Kiem tra xem i dat toi arr.length chua. neu da den thi return ngay
                    if(i >= arrX.size()){
                        result.add(temp.toArray(new ObjLvl5_5Res[0]));
                        return result;
                    }
                    // Check tu phan tu dau tien toi phan tu i co bi trung lap khong, bi trung lap thi tang i len 1 va kiem tra lai
                    if(arrX.get(j).getA() == arrX.get(i).getA() && i!=j){
                        if(i != arrX.size()){
                            temp.add(arrX.get(j));
                            arrX.remove(j);
                            j = i;
                        }
                    }

                }
            }
            else if(c == 'b'){
                for(int j = i; j < arrX.size(); j++){
                    if(i >= arrX.size()){
                        result.add(temp.toArray(new ObjLvl5_5Res[0]));
                        return result;
                    }
                    // Check tu phan tu dau tien toi phan tu i co bi trung lap khong, bi trung lap thi tang i len 1 va kiem tra lai
                    if(arrX.get(j).getB() == arrX.get(i).getB() && i!=j){
                        if(i != arrX.size()){
                            temp.add(arrX.get(j));
                            arrX.remove(j);
                            j = i;
                        }
                    }
                }
            }
            if(!temp.isEmpty()){
                result.add(temp.toArray(new ObjLvl5_5Res[0]));
                arrX.remove(i);
                i = -1;
            }
        }
        return result;
    }

    public String trimAll(String arr){
        arr = arr.trim().replaceAll("\\s+"," ");
        return arr;
    }

    public List<Map<String,Integer>> mapKey(ObjLvl5_7Res[] objects, String[] key){
        List<Map<String,Integer>> result = new ArrayList<>();
        for(ObjLvl5_7Res o : objects){
            LinkedHashMap<String,Integer> temp = new LinkedHashMap<>();
            for(String k : key){
                if(k.equals("a")){
                    temp.put("a", o.getA());
                }
                else if (k.equals("b")){
                    temp.put("b", o.getB());
                }
                else if (k.equals("c")){
                    temp.put("c", o.getC());
                }
                else if (k.equals("d")){
                    temp.put("d", o.getD());
                }
                else if (k.equals("e")){
                    temp.put("e", o.getE());
                }
                else if (k.equals("f")){
                    temp.put("f", o.getF());
                }
                else if (k.equals("g")){
                    temp.put("g", o.getG());
                }
            }
            result.add(temp);
        }
        return result;
    }

    public ObjLvl5_8Res[] switchOrder(ObjLvl5_8Res[] objects, int id, int index) {
        for(int i = 0;i < objects.length; i++){
            if(objects[i].getId() == id){
                ObjLvl5_8Res temp = objects[i];
                objects[i] = objects[index];
                objects[index] = temp;
                break;
            }
        }
        return objects;
    }

    public ObjLvl5_9Res sumObj(ObjLvl5_9Res[] arr){
        ObjLvl5_9Res res = new ObjLvl5_9Res();
        for (int i = 0;i < arr.length;i++){
            res.setA(res.getA() + arr[i].getA());
            res.setB(res.getB() + arr[i].getB());
            res.setC(res.getC() + arr[i].getC());
            res.setD(res.getD() + arr[i].getD());
            res.setE(res.getE() + arr[i].getE());
            res.setF(res.getF() + arr[i].getF());
            res.setG(res.getG() + arr[i].getG());
        }
        return res;
    }
}
