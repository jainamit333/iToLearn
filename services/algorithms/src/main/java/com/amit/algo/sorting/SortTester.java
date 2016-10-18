package com.amit.algo.sorting;

import java.util.Arrays;

/**
 * Created by amit on 12/10/16.
 */
public class SortTester {

    public static void main(String[] args) {
        SortTester sortTester = new SortTester();
        sortTester.test();
    }

    private void test() {

        Integer[] array = {23,1,100,2,34,55,99,5};
        System.out.println("array before sort");
        System.out.println(Arrays.toString(array));
        System.out.println("Array after Sort");
        array = Sorter.quickSort(array,0,array.length-1);

        System.out.println(Arrays.toString(array));
    }
}
