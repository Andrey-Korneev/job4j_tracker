package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        result = minus(7);
        System.out.println(result);

        Calculator calculator = new Calculator();
        result = calculator.multiply(5);
        System.out.println(result);
        result = calculator.divide(15);
        System.out.println(result);

        result = calculator.sumAllOperation(25);
        System.out.println(result);
    }
}
