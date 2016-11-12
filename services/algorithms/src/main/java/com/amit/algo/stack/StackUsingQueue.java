package com.amit.algo.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by amit on 11/11/16.
 */
public class StackUsingQueue<T> {

    Queue<T> queue = new LinkedList<T>();

    public T pop(){
        
        int size = queue.size();
        for (int i = 0; i < size-1; i++) {
            T item = queue.poll();
            queue.offer(item);
        }
        return queue.poll();
    }

    public void push(T value){
        queue.offer(value);
    }

    public T peek(){

        int size = queue.size();
        for (int i = 0; i < size-1; i++) {
            T item = queue.poll();
            queue.offer(item);
        }
        T temp = queue.poll();
        queue.offer(temp);
        return temp;
    }

    public static void main(String[] args) {
    StackWithMax stackWithMax = new StackWithMax();
        stackWithMax.push(97);
        stackWithMax.pop();
        stackWithMax.push(20);
        stackWithMax.pop();
        stackWithMax.push(26);
        stackWithMax.push(20);
        stackWithMax.pop();
        System.out.println(stackWithMax.getMax());
        stackWithMax.push(91);
        System.out.println(stackWithMax.getMax());


    }

}
