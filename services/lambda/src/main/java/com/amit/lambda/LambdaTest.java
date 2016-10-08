package com.amit.lambda;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by amit on 27/6/16.
 */
public class LambdaTest {


    public static boolean filterResult(int a,int b){
        if(a>b)
            return true;
        return false;
    }

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        List<Integer> intList= new ArrayList();
        int b =4;
        intList.add(1);intList.add(2);intList.add(3);intList.add(4);intList.add(5);intList.add(6);
        intList.add(7);intList.add(8);intList.add(9);intList.add(10);intList.add(11);




//        Map<String,Integer> map =new HashMap();
//        map.put("a",1);
//        map.put("b",2);map.put("c",3);map.put("d",4);map.put("e",5);
//        Map<String,Integer> cbv = map.entrySet().stream().filter(a-> a.getValue()>3).collect(Collectors.toMap(a-> a.getKey(),a-> a.getValue()));
//        System.out.println(cbv);

        //System.out.println(map.entrySet().stream().filter(a-> a.getValue()>3));;

//        System.out.println(intList.stream().filter( a-> filterResult(a,b))
//                .filter(a-> filterResult(a,7)).collect(Collectors.toList()));
    }

}
