package ru.job4j.inheritance;

import java.util.Date;

public class Builder extends Engineer {

    private String specialty;

    public Builder(String name, String surname, String education, Date birthday,
                   String qualification, String specialty) {
        super(name, surname, education, birthday, qualification);
        this.specialty = specialty;
    }

    public Building build(String task) {
        return new Building();
    }
}
