package ru.job4j.synchronizy;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class User {
    private int id;
    private int amount;

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public synchronized void setAmount(int amount) {
        this.amount = amount;
    }
}
