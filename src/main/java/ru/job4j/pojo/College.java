package ru.job4j.pojo;

import java.time.LocalDateTime;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Korneev Andrey");
        student.setGroup("AEP-043");
        student.setAdmission(LocalDateTime.now());
        System.out.println("The student " + student.getFio()
                + " is enrolled in the group " + student.getGroup()
                + " on " + student.getAdmission()
        );
    }
}
