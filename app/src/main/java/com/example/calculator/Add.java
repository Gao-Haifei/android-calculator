package com.example.calculator;

public class Add extends Operation {
    public Add(double a, double b) {
        super(a, b);
    }
    @Override
    public double getResult() {
        return getNumber_a()+getNumber_b();
    }
}

