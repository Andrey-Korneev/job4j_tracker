package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает систему банковского обслуживания
 * @author Andrey Korneev
 * @version 1.0
 */
public class BankService {
    /**
     * База данных о клиентах хранится в коллекции типа HashMap.
     * Ключом является сам клиент, а значением - список его счетов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет добавлять клиента в базу.
     * Если указанный клиент уже есть в базе, то никаких
     * действий не производится. Каждому новому клиенту
     * ставится в соответствие пустой список счетов
     * @param user добавляемый клиент
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет добавить новый счет клиенту.
     * Клиент идентифицируется по данным паспорта.
     * Если указанный счет уже есть у клиента, то никаких
     * действий не производится.
     * @param passport данные паспорта клиента
     * @param account добавляемый счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод позволяет найти клиента в базе по данным паспорта.
     * @param passport данные паспорта искомого клиента
     * @return возвращает найденного клиента или null,
     * если клиент в базе не найден
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод для поиска счета по реквизитам. Клиент идентифицируется
     * по данным паспорта
     * @param passport данные паспорта клиента
     * @param requisite реквизиты искомого счета
     * @return возвращает найденный счет или null,
     * если указанный счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод для перечисления денег с одного счета на другой.
     * Если сумма перевода превышает баланс счета-источника, то
     * никаких действий не производится.
     * @param srcPassport данные паспорта клиента, которому принадлежит счет-источник
     * @param srcRequisite реквизиты счета-источника
     * @param destPassport данные паспорта клиента, которому принадлежит счет-приемник
     * @param destRequisite реквизиты счета-приемника
     * @param amount сумма перевода
     * @return {@code true} если операция была совершена
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && (src.getBalance() - amount) >= 0) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
