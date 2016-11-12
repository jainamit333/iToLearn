package com.amit.algo.stack;

import java.util.ArrayList;
import java.util.List;

public class InfixToPostfixConvertor extends Convertor{

  private static InfixToPostfixConvertor convertor = new InfixToPostfixConvertor();
  private InfixToPostfixConvertor(){}

  public static InfixToPostfixConvertor getInstance(){
      return convertor;
    }

    public List<String> convert(List input, Association association){

      Stack stack = new Stack();
      List<String> result = new ArrayList();
//      input.stream()
//           .forEach((value,stack,result) -> Evaluator::operandHandler);

      result.addAll(stack.emptyMe());
      return result;
    }
}
