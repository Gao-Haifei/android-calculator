package com.example.calculator;

public class Divide extends Operation {
    public Divide(double a, double b) {
        super(a, b);
    }
    @Override
    public double getResult() {
        if (getNumber_b() == 0) throw new IllegalArgumentException("除数不能为0");
        return getNumber_a() / getNumber_b();
    }
}
