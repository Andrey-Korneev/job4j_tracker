package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод для поиска счета по реквизитам. Клиент идентифицируется
     * по данным паспорта
     * @param passport данные паспорта клиента
     * @param requisite реквизиты искомого счета
     * @return возвращает найденный счет или null,
     * если указанный счет не найден
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value).stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst());
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
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (src.isPresent() && dest.isPresent() && (src.get().getBalance() - amount) >= 0) {
            src.get().setBalance(src.get().getBalance() - amount);
            dest.get().setBalance(dest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
