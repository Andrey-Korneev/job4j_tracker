package ru.job4j.inheritance;

import java.util.Date;

public class Engineer extends Profession {

    private String qualification;

    public Engineer(String name, String surname, String education, Date birthday, String qualification) {
        super(name, surname, education, birthday);
        this.qualification = qualification;
    }

    public Project design(String task) {
        return new Project();
    }
}
