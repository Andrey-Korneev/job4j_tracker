package ru.job4j.inheritance;

import java.util.Date;

public class Surgeon extends Doctor {

    private int numberOfOperations;

    public Surgeon(String name, String surname, String education, Date birthday,
                   Clinic clinic, int numberOfOperations) {
        super(name, surname, education, birthday, clinic);
        this.numberOfOperations = numberOfOperations;
    }

    public void operate(Pacient pacient) {
    }
}
