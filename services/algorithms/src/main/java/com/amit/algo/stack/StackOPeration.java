package com.amit.algo.stack;

import java.util.*;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * Created by amit on 11/11/16.
 */
public class StackOPeration {

    static Map<String,String> mapper = new HashMap();
    static {
        mapper.put("{","}");
        mapper.put("[","]");
        mapper.put("(",")");
        mapper.put("<",">");
    }

    public void reverse(Stack stack){

        if(!stack.empty()){
            Object temp = stack.pop();
            reverse(stack);
            insertAtBottom(stack,temp);
        }

    }

    private void insertAtBottom(Stack stack, Object temp) {

        if(stack.empty()){
            stack.push(temp);
        }else{
            Object item = stack.pop();
            insertAtBottom(stack,temp);
            stack.push(item);
        }
    }

    public List<Integer> nextGreatest(List<Integer> input){

        Stack<Integer> stack = new Stack();
        stack.push(input.get(0));
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < input.size(); i++) {

            while (!stack.isEmpty()&&stack.peek()<input.get(i)){
                result.add(input.get(i));

            }
            stack.push(input.get(i));
        }
        stack.stream().forEach(value-> result.add(-1));
        return result;
    }

    public boolean checkParanthesis(Stream<String> stream){

        Stack stack = new Stack();
        stream.forEach(value -> {
            if(openningParanthesis(value)){
                stack.push(value);
            }
            if(clossingParanthesis(value) && reveseParanthesis(value,stack.peek())){
                stack.pop();
            }
        });
        return stack.size()==0;
    }

    private boolean reveseParanthesis(String value, Object peek) {
        return mapper.containsKey(value) && mapper.get(value).equals(peek);
    }
    private boolean clossingParanthesis(String value) {
        return !mapper.containsKey(value);
    }
    private boolean openningParanthesis(String value) {
        return mapper.containsKey(value);
    }


}
