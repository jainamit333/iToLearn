package com.amit.algo.stack;

import java.util.*;
import java.util.Stack;

/**
 * Created by amit on 12/11/16.
 */
public class StackWithMin {


    Stack<Integer> stack = new Stack();
    int minElement;

    public Integer pop() {
        int elem = stack.pop();
        if (elem >= minElement) {
            return elem;
        } else {
            int temp = minElement;
            minElement = 2 * minElement - elem;
            return temp;

        }
    }

    public int peep() {

        int elem = stack.pop();
        if (elem >= minElement) {
            return elem;
        } else {
            return minElement;
        }

    }

    public void push(int value) {

        if(stack.isEmpty()|| minElement<=value){
            stack.push(value);
        }else{
            stack.push(2*minElement-value);
            minElement=value;

        }

    }

    public int getMin() {
        return minElement;
    }
}
