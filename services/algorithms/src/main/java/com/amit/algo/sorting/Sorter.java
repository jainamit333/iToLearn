package com.amit.algo.sorting;

/**
 * Created by amit on 11/10/16.
 */
public class Sorter {

    public static Integer[] heapSort(Integer[] array) {
        int n = array.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxheapify(array, n, i);
        }
        System.out.println("create min heap");
        for (int i = n - 1; i >= 0; i--) {
            swap(0, i, array);
            maxheapify(array, i, 0);
        }

        return array;
    }

    public static Integer[] bubbleSort(Integer[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                swap(i, j, array);
            }
        }

        return array;
    }

    public static Integer[] selectionSort(Integer[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = i; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            swap(i, index, array);
        }

        return array;
    }

    public static Integer[] quickSort(Integer[] array, int first, int last) {

        if (first < last) {
            int pivot = partition(array, first, last);
            quickSort(array, first, pivot - 1);
            quickSort(array, pivot + 1, last);
        }
        return array;
    }

    private static int partition(Integer[] array, int first, int last) {

        int pivot = first;
        int leftParam = first + 1;
        int rightParam = last;

        while (true) {
            while (leftParam <= rightParam && array[leftParam] <= array[pivot])
                leftParam++;
            while (rightParam >= leftParam && array[rightParam] >= array[pivot])
                rightParam--;
            if (rightParam > leftParam)
                blindswap(leftParam, rightParam, array);
            else
                break;
        }
        blindswap(first, rightParam, array);
        return rightParam;
    }

    private static void swap(int i, int j, Integer[] array) {

        if (array[i] > array[j]) {
            Integer temp = array[i];
            array[i] = array[j];
            array[j] = temp;

        }
    }

    private static void blindswap(int i, int j, Integer[] array) {
        Integer temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int leftChild(int i) {
        return (2 * i) + 1;
    }

    private static int rightChild(int i) {
        return (2 * i) + 2;
    }

    private static void maxheapify(Integer[] array, int n, int i) {

        int largest = i;
        int l = leftChild(i);
        int r = rightChild(i);
        //System.out.println("root "+i+"    ---   "+n+"  l = "+l+"  r = "+r);
        if (l < n && array[l] > array[largest]) {
            largest = l;
        }
        if (r < n && array[r] > array[largest]) {
            largest = r;
        }

        if (largest != i) {
            //System.out.println("swap "+ i + "  l " +largest);
            blindswap(i, largest, array);
            //System.out.println(Arrays.toString(array));
            maxheapify(array, n, largest);
        }
    }

    private static void minHeapify(Integer[] array, int n, int i) {

        int smalest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < n && array[left] < array[smalest]) {
            smalest = i;
        }
        if (right < n && array[right] < array[smalest]) {
            smalest = right;
        }
        if (smalest != i) {
            blindswap(i, smalest, array);
            minHeapify(array, n, smalest);
        }
    }

}
