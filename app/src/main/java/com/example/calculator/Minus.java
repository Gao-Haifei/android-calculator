package com.example.calculator;

public class Minus extends Operation{
    public Minus(double a, double b) {
        super(a, b);
    }
    @Override
    public double getResult() {
        return getNumber_a()-getNumber_b();
    }
}