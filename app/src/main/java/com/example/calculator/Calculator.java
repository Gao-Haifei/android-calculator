package com.example.calculator;

public class Calculator {
    private static Operation operation;
    private static double a,b;
    private static Operation generateOperation(char operator) {
        switch (operator) {
            case '+':
                operation = new Add(a,b);
                break;
            case '-':
                operation = new Minus(a,b);
                break;
            case '*':
                operation = new Times(a,b);
                break;
            case '÷':
                operation = new Divide(a,b);
                break;
        }
        return operation;
    }
    public static double calculate(double a, double b, char operator) {
        generateOperation(operator);
        operation.setNumber_a(a);
        operation.setNumber_b(b);
        return operation.getResult();
    }
}
