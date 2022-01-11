package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает банковский счет клиента
 * @author Andrey Korneev
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты банковского счета хранятся в поле requisite типа String,
     * баланс банковского счета хранится в поле balance типа double
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор, позволяет создавать объекты типа Account (банковский счет)
     * @param requisite реквизиты банковского счета
     * @param balance баланс банковского счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты счета
     * @return возвращает реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет устанавливать новые реквизиты счета
     * @param requisite новые реквизиты счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить баланс счета
     * @return возвращает баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет устанавливать новый баланс счета
     * @param balance новый баланс счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод для сравнения двух банковских счетов - текущего и того,
     * что передается в параметре
     * @param o банковский счет, с которым сравнивается текущий счет
     * @return {@code true} если два счета равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод для получения хэш-кода объекта счета
     * @return возвращает хэш-код объекта счета
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
