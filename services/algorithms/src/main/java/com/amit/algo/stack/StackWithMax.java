package com.amit.algo.stack;


import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Stack;
/**
 * Created by amit on 12/11/16.
 */
@ToString
@EqualsAndHashCode
public class StackWithMax {

    Stack<Integer> stack = new Stack<>();
    int max ;

    public void push(int value){
       // System.out.println("push");
       // System.out.println(this.toString());
        if(stack.isEmpty()){
            stack.push(value);
            max=value;
            return;
        }
        if(value<=max){
            stack.push(value);
        }else{
            stack.push(2*value-max);
            max = value;
        }
       // System.out.println(this.toString());
    }

    public int pop(){
       // System.out.println("pop");
      //  System.out.println(this.toString());
        int elem = stack.pop();
        if(stack.isEmpty())
            max=0;
        if(elem<=max){
     //       System.out.println(this.toString());
            return elem;
        }else{
            int maxReturn = max;
             max = 2*max-elem;
       //     System.out.println(this.toString());
             return maxReturn;
        }

    }

    public int getMax(){
        return max;
    }

}
