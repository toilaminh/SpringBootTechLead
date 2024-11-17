package com.example.demo.model.dto.core4;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class EmpData {
    private Emp EMP;
    private List<HashMap<String, HashMap<String, Double>>> DAY_SALARY;
    private double MONTH_SALARY;
    public EmpData(){
        EMP = new Emp();

        MONTH_SALARY = 0;
    }
    public EmpData(Emp e, List<HashMap<String, HashMap<String, Double>>> day, double month){
        EMP = e;
        DAY_SALARY = day;
        MONTH_SALARY = month;
    }
}
