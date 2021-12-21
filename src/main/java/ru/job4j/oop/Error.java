package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() { }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 10, "Hello, world!");
        Error error3 = new Error(false, 100, "Abracadabra!");
        Error error4 = new Error(true, 1000, "Good night!");
        error1.printInfo();
        System.out.println();
        error2.printInfo();
        System.out.println();
        error3.printInfo();
        System.out.println();
        error4.printInfo();
    }
}
