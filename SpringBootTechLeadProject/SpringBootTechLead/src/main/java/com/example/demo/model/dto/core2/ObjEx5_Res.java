package com.example.demo.model.dto.core2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObjEx5_Res {
    private int[] res = new int[2];
    public ObjEx5_Res(int a, int b){
        res[0] = a;
        res[1] = b;
    }
}
