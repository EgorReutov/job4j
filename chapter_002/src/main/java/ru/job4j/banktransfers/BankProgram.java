package ru.job4j.banktransfers;

import java.util.*;

public class BankProgram {
    Map<User, List<Account>> users = new HashMap<>();


    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        if (users.containsKey(user)) {
            users.remove(user);
        }
    }

    public void addAccountToUser(String passport, Account account) {
        // добавить счёт пользователю.
        if (users.containsKey(findUser(passport))) {
            users.get(findUser(passport)).add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        // удалить один счёт пользователя.
        if (users.containsKey(findUser(passport))) {
            users.remove(findUser(passport), account);
        }
    }
    public List<Account> getUserAccounts(String passport) {
        // получить список счетов для пользователя.
        return users.get(findUser(passport));
    }


    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        if ((findUser(srcPassport)) != null && findUser(destPassport) != null && findByRequisite(srcPassport,
                srcRequisite).getValue() > amount) {
            findByRequisite(srcPassport, srcRequisite).setValue(findByRequisite(srcPassport, srcRequisite).getValue() - amount);
            findByRequisite(srcPassport, srcRequisite).setValue(findByRequisite(destPassport, dstRequisite).getValue() + amount);
            result = true;
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisites) {
        Account result = new Account();
        List<Account> temp = getUserAccounts(passport);
        for (Account account : temp) {
            if (account.getRequisites().equals(requisites)) {
                result = account;
            }
        }
        return result;
    }

    public User findUser(String passport) {
        User resultUser = new User();
        for (Map.Entry<User, List<Account>> user : users.entrySet()) {
            if (user.getKey().getPassport().contains(passport)) {
                resultUser = (User) user;
            }
        }
        return resultUser;
    }

}

