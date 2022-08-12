package com.example.calculate.model;

import java.util.Objects;
import javax.validation.constraints.NotBlank;



public class Expression {
    @NotBlank(message="????????????????????")
    private String expr ;
    @NotBlank(message="????????????????????")
    private double numOne;
    @NotBlank(message="????????????????????")
    private double numTwo;
    private double resylt;

    public Expression() {
    }

    public Expression(String expr, double numOne, double numTwo, double resylt) {
        this.expr = expr;
        this.numOne = numOne;
        this.numTwo = numTwo;
        this.resylt = resylt;
    }

    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public double getNumOne() {
        return numOne;
    }

    public void setNumOne(double numOne) {
        this.numOne = numOne;
    }

    public double getNumTwo() {
        return numTwo;
    }

    public void setNumTwo(double numTwo) {
        this.numTwo = numTwo;
    }

    public double getResylt() {
        return resylt;
    }

    public void setResylt(double result) {
        this.resylt = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return Double.compare(that.numOne, numOne) == 0 && Double.compare(that.numTwo, numTwo) == 0 && Double.compare(that.resylt, resylt) == 0 && expr.equals(that.expr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expr, numOne, numTwo, resylt);
    }

}
