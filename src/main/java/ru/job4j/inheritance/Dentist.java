package ru.job4j.inheritance;

import java.util.Date;

public class Dentist extends Doctor {

    private int numberOfTeeth;

    public Dentist(String name, String surname, String education,
                   Date birthday, Clinic clinic, int numberOfTeeth) {
        super(name, surname, education, birthday, clinic);
        this.numberOfTeeth = numberOfTeeth;
    }

    public void dentalcare(Pacient pacient) {
    }
}
