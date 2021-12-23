package ru.job4j.pojo;

import java.time.LocalDateTime;

public class Student {
    private String fio;
    private String group;
    private LocalDateTime admission;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDateTime getAdmission() {
        return admission;
    }

    public void setAdmission(LocalDateTime admission) {
        this.admission = admission;
    }
}
