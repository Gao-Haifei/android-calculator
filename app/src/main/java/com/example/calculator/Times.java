package com.example.calculator;

public class Times extends Operation {
    public Times(double a, double b) {
        super(a, b);
    }
    @Override
    public double getResult() {
        return getNumber_a()*getNumber_b();
    }
}
