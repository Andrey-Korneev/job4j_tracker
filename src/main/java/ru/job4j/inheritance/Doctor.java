package ru.job4j.inheritance;

import java.util.Date;

public class Doctor extends Profession {

    private Clinic clinic;

    public Doctor(String name, String surname, String education, Date birthday, Clinic clinic) {
        super(name, surname, education, birthday);
        this.clinic = clinic;
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }
}
