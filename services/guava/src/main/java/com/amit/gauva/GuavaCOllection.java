package com.amit.gauva;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.*;

/**
 * Created by amit on 10/10/16.
 */
public class GuavaCOllection {

    public void test(){


        Multiset<Integer> integers = HashMultiset.create();
        integers.add(1);integers.add(1);integers.add(1);integers.add(1);
        integers.add(2);
        integers.add(3);integers.add(3);
        System.out.println(integers);
        System.out.println(integers.count(3));
        System.out.println(integers.entrySet());
        System.out.println(integers.remove(1,5));
        System.out.println(integers.setCount(5,5));
        integers.add(null);integers.add(null);
        System.out.println(integers.size());


        Multimap<String,Integer> map = HashMultimap.create();
        map.put("a",null);map.put("a",1);map.put("a",2);
        map.put(null,null);map.put(null,1);
        System.out.println(map);
        System.out.println(map.get("a").size());


        BiMap<Integer, String> empIDNameMap = HashBiMap.create();
        empIDNameMap.put(1,"a");
        empIDNameMap.put(1,"b");
        empIDNameMap.put(1,"c");
        empIDNameMap.put(null,"a");
        empIDNameMap.put(null,null);
        empIDNameMap.forcePut(2,"c");
        System.out.println(empIDNameMap.inverse().get("c"));;
//        empIDNameMap.put(2,"c");
//        empIDNameMap.put(null,"c");
        System.out.println(empIDNameMap);



        Table<String, String, String> employeeTable = HashBasedTable.create();
        employeeTable.put("a","a1","a2");
        employeeTable.put("a","a2","a2");
        employeeTable.put("a","a2","a3");
        employeeTable.put("a","a3","a5");
        System.out.println(employeeTable);
        System.out.println(employeeTable.get("a","a1"));;
        System.out.println(employeeTable.get("a4","a1"));;

        System.out.println(Splitter.on(",").omitEmptyStrings().trimResults().limit(2).split("a,s,d,f,g,h,,j,jk,k,l,l,cf,d,d,d,d,d"));
        System.out.println(Splitter.on(",").withKeyValueSeparator(":").split("a:1,b:2"));

        System.out.println(CharMatcher.javaLowerCase().retainFrom("ASD"));;
    }
}
