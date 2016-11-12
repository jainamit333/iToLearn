package com.amit.gauva;


import com.google.common.base.Optional;

/**
 * Created by amit on 10/10/16.
 */
public class Test1 {

    public static void main(String []args) {
        System.out.println("Hello World");
        GuavaCOllection test = new GuavaCOllection();
        test.test();
    }
    public void test(){
        Integer int1 = null;
        Integer int2 = new Integer(1);

        Optional<Integer> value = Optional.fromNullable(int1);
        Optional<Integer> value2 = Optional.of(int1);
        int2 = new Integer(4);

        System.out.println(sum(value,value2));

    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());

        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.or - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.or(new Integer(0));

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();

        return value1 + value2;
    }
}
