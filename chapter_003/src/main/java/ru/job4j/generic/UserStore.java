package ru.job4j.generic;

public class UserStore extends AbstractStore<User> {

    public UserStore(SimpleArray<Object> objects) {
        super();
    }

    public UserStore(int size) {
        super(size);
    }
}
