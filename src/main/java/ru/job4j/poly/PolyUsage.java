package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle bus = new Bus2();
        Vehicle plane = new Plane();
        Vehicle train = new Train();

        Vehicle[] transport = new Vehicle[]{bus, plane, train};
        for (Vehicle v : transport) {
            v.move();
        }
    }
}
