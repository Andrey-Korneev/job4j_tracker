package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает клиента (пользователя) банковской системы
 * @author Andrey Korneev
 * @version 1.0
 */
public class User {
    /**
     * В строковом поле passport хранятся данные паспорта клиента,
     * также в строковом поле username хранится имя клиента
     */
    private String passport;
    private String username;

    /**
     * Конструктор позволяет создавать объекты типа User (клиент)
     * @param passport данные паспорта клиента
     * @param username имя клиента
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить паспортные данные клиента
     * @return возвращает паспортные данные
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет установить новые паспортные данные клиента
     * @param passport новые паспортные данные клиента
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить имя клиента
     * @return возвращает имя клиента
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет установить новое имя для клиента
     * @param username новое имя клиента
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод для сравнения двух клиентов - текущего и того,
     * что передается в параметре
     * @param o клиент, с которым сравнивается текущий клиент
     * @return {@code true} если два объекта клиента равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод для получения хэш-кода объекта клиента
     * @return возвращает хэш-код объекта клиента
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
