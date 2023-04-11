package com.example.calculator;

public abstract class Operation {
    private double a,b;

    public Operation(double a, double b) {
        a = a;
        b = b;
    }

    public abstract double getResult();
    public double getNumber_a() {
        return a;
    }
    public void setNumber_a(double a) {
        this.a = a;
    }
    public double getNumber_b() {
        return b;
    }
    public void setNumber_b(double b) {
        this.b = b;
    }
}
