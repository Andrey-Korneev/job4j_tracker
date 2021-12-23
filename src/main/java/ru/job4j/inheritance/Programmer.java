package ru.job4j.inheritance;

import java.util.Date;

public class Programmer extends Engineer {

    private String language;

    public Programmer(String name, String surname, String education,
                      Date birthday, String qualification, String language) {
        super(name, surname, education, birthday, qualification);
        this.language = language;
    }

    public Program develop(String task) {
        return new Program();
    }
}
