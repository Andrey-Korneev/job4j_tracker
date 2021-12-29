package ru.job4j.poly;

public class Bus implements Transport {

    private int passengers;
    private int fuelTank;

    @Override
    public void move() {
        System.out.println("Bus is moving.");
    }

    @Override
    public void passengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public float fuel(int gallons) {
        this.fuelTank += gallons;
        return 7.5f * gallons;
    }
}
