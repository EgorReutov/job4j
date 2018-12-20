package ru.job4j.synchronizy;

import net.jcip.annotations.GuardedBy;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    @GuardedBy("this")
    private List<User> storage;

    public UserStorage() {
        this.storage = new ArrayList<>();
    }

    public synchronized boolean add (User user) {
        return storage.add(user);
    }

    public synchronized boolean update(User user) {
        boolean result = false;
        int index;
        index = this.findById(user.getId());
        if (index != -1) {
            storage.set(index, user);
            result = true;
        }
        return result;
    }

    public synchronized boolean delete(User user) {
        return storage.remove(user);
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        int userIndexFrom = this.findById(fromId);
        int userIndexTo = this.findById(toId);
        if (userIndexFrom != -1 && userIndexTo != -1 && storage.get(userIndexFrom).getAmount() >= amount) {
            storage.get(userIndexFrom).setAmount(storage.get(userIndexFrom).getAmount() - amount);
            storage.get(userIndexTo).setAmount(storage.get(userIndexTo).getAmount() + amount);
            result = true;
        }
        return result;
    }

    public int findById(int id) {
        int index = -1;
        for (User i : storage) {
            if (i.getId() == id) {
                index = id;
                break;
            }
        }
        return index;
    }
}
