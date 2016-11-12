package com.amit.gauva;

import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit on 10/10/16.
 */
public class OrderingClassTest {


    public void test(){

        List<Integer> values = new ArrayList<Integer>();
        values.add(6);
        values.add(88);
        values.add(1);
        values.add(222);
        values.add(10);
        values.add(123);


        Ordering ordering = Ordering.natural();
        System.out.println("Input List: ");
        System.out.println(values);
        System.out.println(Ordering.natural().leastOf(values,3));
        System.out.println(Ordering.natural().greatestOf(values,3));
        System.out.println(Ordering.natural().isOrdered(values));
        System.out.println(Ordering.natural().isStrictlyOrdered(values));
        System.out.println(Ordering.natural().min(values));
        System.out.println(Ordering.natural().sortedCopy(values));

    }
}
