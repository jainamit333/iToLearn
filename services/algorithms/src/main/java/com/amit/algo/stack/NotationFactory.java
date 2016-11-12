package com.amit.algo.stack;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import javax.annotation.PostConstruct;

import static com.amit.algo.stack.Notation.INFIX;
import static com.amit.algo.stack.Notation.POSTFIX;

public class NotationFactory{

  private Table<Notation,Notation,Convertor> factoryTable = HashBasedTable.create();
  private static NotationFactory factory = new NotationFactory();

  private NotationFactory(){}
  public static NotationFactory getInstance(){
    return factory;
  }

  @PostConstruct
  public void init(){

      factoryTable.put(INFIX,POSTFIX,InfixToPostfixConvertor.getInstance());
  }

  public Convertor getConvertor(Notation source,Notation destination){

      return factoryTable.get(source,destination);
  }

}
