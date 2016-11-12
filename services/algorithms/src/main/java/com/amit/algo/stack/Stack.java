package com.amit.algo.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<T>{

  public boolean bounded = false;
  int limit = 0;
  int currentSize = 0;

  List<T> stackHolder = new ArrayList();

  public Stack(){}

  public Stack(int limit){
    this.limit = limit;
    bounded = true;
  }

  public T pop() throws StackEmptyException{

        if(currentSize==0) throw new StackEmptyException();
        T value = stackHolder.get(currentSize-1);
        stackHolder.remove(currentSize-1);
        currentSize--;
        return value;

  }

  public T top() throws StackEmptyException{

    if(currentSize==0) throw new StackEmptyException();
    T value = stackHolder.get(currentSize-1);
    currentSize--;
    return value;
  }

  public void push(T value) throws StackFullException{

      if(bounded && currentSize==limit) throw new StackFullException();
      stackHolder.add(value);
      currentSize++;
  }

    public List<T> emptyMe() {

        return this.stackHolder;
    }
}
