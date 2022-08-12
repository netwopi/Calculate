package com.example.calculate.service;


import com.example.calculate.model.Expression;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpressionService {

    public final List<Expression> expressionList = new ArrayList<>();

    public double getResult(double a, double b, String expr) {
         double res = 0;
        switch (expr) {
            case "+" -> res = a + b;
            case "-" -> res = a - b;
            case "/" -> res = a / b;
            case "*" -> res = a * b;
        }
        return res;
    }

    public List<Expression>list(){
        return expressionList;
    }
    public void saveExpression(Expression expression){
        expressionList.add(expression);
    }
    public  void  addExpression(String expr,double numOne,double numTwo,double resylt){
        expressionList.add(new Expression(expr,numOne,numTwo,resylt));

    }
    public double multiplication(double a, double b,String expr) {
        expr = "*";
            return a * b;
    }
    public double division(double a, double b,String expr) {
        expr = "/";
        return a / b;
    }
    public double addition(double a, double b,String expr) {
        expr = "+";
        return a + b;
    }
    public double subtraction(double a, double b,String expr) {
        expr = "-";
        return a - b;
    }


}
